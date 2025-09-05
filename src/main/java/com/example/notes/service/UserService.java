package com.example.notes.service;

import com.example.notes.model.User;
import com.example.notes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // For simplicity, store password as plain text (not recommended for production)
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean checkPassword(String rawPassword, String storedPassword) {
        // Simple plain text password check (not recommended for production)
        return rawPassword.equals(storedPassword);
    }
}
