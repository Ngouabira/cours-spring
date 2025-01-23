package com.ecpi.cours_spring.controller;

import com.ecpi.cours_spring.dto.PatientDTO;
import com.ecpi.cours_spring.model.Patient;
import com.ecpi.cours_spring.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public Patient create(@Valid @RequestBody PatientDTO patient){
        return  patientService.create(patient);
    }

    @GetMapping
    public List<Patient> read(){
        return  patientService.read();
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient){
        return  patientService.update(patient);
    }

    @GetMapping("/{id}")
    public Patient find(@PathVariable("id") int id){
        return  patientService.find(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
          patientService.delete(id);
    }
}
