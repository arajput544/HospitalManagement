package com.patientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientservice.model.Patient;
import com.patientservice.repository.PatientRepository;
@Service
public class PatientServieImpl implements PatientService {
	@Autowired
	private PatientRepository repository;
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Patient getPatientById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
	}

	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return repository.save(patient);
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		// TODO Auto-generated method stub
		Patient existing = getPatientById(id);
		existing.setName(patient.getName());
        existing.setAge(patient.getAge());
        existing.setGender(patient.getGender());
        existing.setDisease(patient.getDisease());
        return existing;
	}

	@Override
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
