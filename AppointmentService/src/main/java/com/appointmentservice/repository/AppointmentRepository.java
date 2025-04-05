package com.appointmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentservice.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByPatientId(Long patientId);
}
