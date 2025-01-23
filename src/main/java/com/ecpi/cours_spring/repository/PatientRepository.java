package com.ecpi.cours_spring.repository;

import com.ecpi.cours_spring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient, Integer> {

    Patient findByEmail(String email);

}
