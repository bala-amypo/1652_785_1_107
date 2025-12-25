package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ApiResponse register(@RequestBody User user) {
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userService.register(user);
        return new ApiResponse(true, "User registered successfully", saved);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
            return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
        }
        throw new RuntimeException("Invalid credentials");
    }
}