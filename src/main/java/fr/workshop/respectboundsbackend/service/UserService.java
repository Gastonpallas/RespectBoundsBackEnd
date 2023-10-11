package fr.workshop.respectboundsbackend.service;

import fr.workshop.respectboundsbackend.entity.User;
import fr.workshop.respectboundsbackend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> getUserById(Long id){

        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username){

        return Optional.ofNullable(userRepository.findByUsername(username));
    }



}
