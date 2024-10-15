package com.college.service;

import com.college.model.User;
import com.college.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Spring Security password encoder

    public User authenticate(String username, String password, String role) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Check if the password matches (using password encoder)
            if (passwordEncoder.matches(password, user.getPassword())) {
                // Check if the role matches
                if (user.getRole().toString().equalsIgnoreCase(role)) {
                    return user; // Return the authenticated user
                }
            }
        }
        throw new IllegalArgumentException("Invalid username, password, or role"); // Throw exception for clarity
    }
}
