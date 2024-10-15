package com.college.security;

import com.college.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final UserUtils userUtils;

    @Autowired
    public JwtTokenProvider(UserUtils userUtils) {
        this.userUtils = userUtils;
        System.out.println("JwtTokenProvider initialized.");
    }

    public String getUsernameFromToken(String token) {
        return userUtils.extractUsernameFromToken(token);
    }

    public boolean validateToken(String token) {
        return userUtils.validateToken(token);
    }

    public String generateToken(String username) {
        return userUtils.generateToken(username);
    }
}
