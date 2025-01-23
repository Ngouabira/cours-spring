package com.ecpi.cours_spring.service;

import com.ecpi.cours_spring.dto.PatientDTO;
import com.ecpi.cours_spring.exception.EntityNotFoundException;
import com.ecpi.cours_spring.mapper.PatientMapper;
import com.ecpi.cours_spring.model.Patient;
import com.ecpi.cours_spring.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient create(PatientDTO patient){
        return patientRepository.save(PatientMapper.toEntity(patient));
    }

    public List<Patient> read(){
        return patientRepository.findAll();
    }

    public Patient update(Patient patient){
        return patientRepository.save(patient);
    }

    public void delete(Integer id){
        patientRepository.deleteById(id);
    }

    public Patient find(int id){
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()){
            return optionalPatient.get();
        }
        throw new EntityNotFoundException("Patient not found", 404);
    }
}
