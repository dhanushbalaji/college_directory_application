package com.college.controller;

import com.college.model.User;
import com.college.service.AuthService;
import com.college.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        String role = loginRequest.get("role");

        // Validate request parameters
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Username and password are required"));
        }

        // Authenticate the user
        User user = authService.authenticate(username, password, role);
        if (user != null) {
            // Generate JWT token
            String token = jwtService.generateToken(user);

            // Create response payload
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("username", user.getUsername()); // Optional: include username in response
            response.put("role", user.getRole().toString());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
    }
}
