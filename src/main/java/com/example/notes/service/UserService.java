package com.example.notes.service;

import com.example.notes.model.User;
import com.example.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String register(User user, String confirmPassword) {
        if (repo.existsByEmail(user.getEmail())) return "Email already exists";
        if (repo.existsByUsername(user.getUsername())) return "Username already exists";
        if (!user.getPassword().equals(confirmPassword)) return "Passwords do not match";

        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "success";
    }

    public User login(String email, String password) {
        Optional<User> opt = repo.findByEmail(email);
        if (opt.isEmpty()) return null;
        User user = opt.get();
        if (encoder.matches(password, user.getPassword())) return user;
        return null;
    }
}
