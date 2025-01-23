package com.ecpi.cours_spring.mapper;

import com.ecpi.cours_spring.dto.PatientDTO;
import com.ecpi.cours_spring.model.Patient;

public class PatientMapper {


    public static Patient toEntity(PatientDTO dto){

        if (dto == null) {
            return  null;
        }
        else {
            return Patient.builder()
                    .id(dto.getId())
                    .fullName(dto.getFullName())
                    .gender(dto.getGender())
                    .phone(dto.getPhone())
                    .email(dto.getEmail())
                    .build();
        }

    }


    public static PatientDTO toDTO(Patient patient){

        if (patient == null) {
            return  null;
        }
        else {
            return PatientDTO.builder()
                    .id(patient.getId())
                    .fullName(patient.getFullName())
                    .gender(patient.getGender())
                    .phone(patient.getPhone())
                    .email(patient.getEmail())
                    .build();
        }

    }
}
