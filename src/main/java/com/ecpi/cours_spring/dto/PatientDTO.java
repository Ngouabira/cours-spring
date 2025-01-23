package com.ecpi.cours_spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientDTO {

    private Integer id;

    @NotBlank(message = "Le nom est obligatoire.")
    private String fullName;

    @NotBlank(message = "Le genre est obligatoire.")
    private String gender;

    @NotBlank(message = "Le téléphone est obligatoire.")
    private String phone;

    @Email(message = "Emain invalide.")
    private String email;

    private String address;
}
