package com.ecpi.cours_spring.service;

import com.ecpi.cours_spring.exception.EntityNotFoundException;
import com.ecpi.cours_spring.model.User;
import com.ecpi.cours_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public List<User> read(){
        return userRepository.findAll();
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public User find(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new EntityNotFoundException("User not found", 404);
    }
}
