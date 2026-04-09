package com.factory.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.factory.auth.entity.User;
import com.factory.auth.service.AuthService;
import com.factory.auth.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String home() {
        return "Auth Service Running Successfully";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = authService.login(user.getEmail(), user.getPassword());

        if (dbUser != null) {
            return jwtUtil.generateToken(dbUser.getEmail());
        }

        return "Invalid credentials";
    }

    // 🔐 ADD THIS
    @GetMapping("/secure")
    public String secure() {
        return "JWT Secured API Working";
    }
}