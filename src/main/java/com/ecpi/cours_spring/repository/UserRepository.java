package com.ecpi.cours_spring.repository;

import com.ecpi.cours_spring.model.Patient;
import com.ecpi.cours_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Patient findByUsername(String username);

}
