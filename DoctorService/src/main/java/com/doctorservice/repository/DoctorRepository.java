package com.doctorservice.repository;

import com.doctorservice.model.Doctor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	List<Doctor> findBySpecializationIgnoreCase(String specialization);
}
