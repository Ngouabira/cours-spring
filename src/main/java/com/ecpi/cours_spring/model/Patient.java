package com.ecpi.cours_spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Patient {

    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;

    private String gender;
    @Column(unique = true)
    private String phone;
    @Column(unique = true, nullable = true)
    private String email;
    private String address;

    @OneToMany
    private List<Consultation> consultation;

    public Patient(Integer id, String fullName){
        this.fullName = fullName;
        this.id = id;
    }


}
