package com.appointmentservice.controller;

import com.appointmentservice.model.Appointment;
import com.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Create new appointment
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    // Get all appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.getAllAppointments(), HttpStatus.OK);
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(id), HttpStatus.OK);
    }

    // Update appointment
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.updateAppointment(id, appointment), HttpStatus.OK);
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get all appointments by doctorId
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByDoctorId(doctorId), HttpStatus.OK);
    }

    // Get all appointments by patientId
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByPatientId(patientId), HttpStatus.OK);
    }
}
