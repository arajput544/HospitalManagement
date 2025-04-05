package com.appointmentservice.service;

import com.appointmentservice.model.Appointment;
import com.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create a new appointment
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    // Update appointment
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existing = getAppointmentById(id);
        existing.setPatientId(updatedAppointment.getPatientId());
        existing.setDoctorId(updatedAppointment.getDoctorId());
        existing.setDate(updatedAppointment.getDate());
        existing.setTime(updatedAppointment.getTime());
        existing.setReason(updatedAppointment.getReason());
        return appointmentRepository.save(existing);
    }

    // Delete appointment
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    // Get appointments by doctor ID
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    // Get appointments by patient ID
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
