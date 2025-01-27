package com.ecpi.cours_spring;


import com.ecpi.cours_spring.model.User;
import com.ecpi.cours_spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SampleDataLoader implements CommandLineRunner {

    UserRepository userRepository;
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

        var user1 = User.builder().role("ADMIN").username("gildasngouabira@gmail.com").password(encoder.encode("1234")).build();
        var user2 = User.builder().role("USER").username("valdyngouabira@gmail.com").password(encoder.encode("1234")).build();

        List<User> users = List.of(user1, user2);

        userRepository.saveAll(users);

    }
}