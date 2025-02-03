package com.ecpi.cours_spring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column(nullable = true)
    private String role;

    private String password;
}
