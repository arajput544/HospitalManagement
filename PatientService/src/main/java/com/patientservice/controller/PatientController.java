package com.patientservice.controller;

import com.patientservice.service.PatientService;
import com.patientservice.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
