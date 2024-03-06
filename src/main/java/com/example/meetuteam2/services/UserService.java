package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public List<User> userList() {
        return userRepository.findAll();
    }
}