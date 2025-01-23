package com.ecpi.cours_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consultation {

    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    private String observation;
}
