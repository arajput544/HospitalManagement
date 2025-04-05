package com.appointmentservice.service;

import com.appointmentservice.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(Long id);

    Appointment updateAppointment(Long id, Appointment updatedAppointment);

    void deleteAppointment(Long id);

    List<Appointment> getAppointmentsByDoctorId(Long doctorId);

    List<Appointment> getAppointmentsByPatientId(Long patientId);
}
