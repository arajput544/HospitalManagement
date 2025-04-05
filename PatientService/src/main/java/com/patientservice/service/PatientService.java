package com.patientservice.service;
import com.patientservice.model.Patient;


import java.util.List;

public interface PatientService {
	List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient addPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
