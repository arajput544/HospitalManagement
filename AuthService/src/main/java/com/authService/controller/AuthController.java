package com.authService.controller;

import com.authService.dto.AuthRequest;
import com.authService.dto.AuthResponse;
import com.authService.model.User;
import com.authService.service.AuthService;
import com.authService.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;
    @GetMapping("/")
    public String welcomw() {
    	return "Welcome User";
    }
    @GetMapping("/hello")
    public String hello() {
    	return "Hello from AuthService";
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        return authService.findByUsername(request.getUsername())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .<ResponseEntity<?>>map(user -> {
                    String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
                    return ResponseEntity.ok(new AuthResponse(token));
                })
                .orElseGet(() -> ResponseEntity.status(401).body("Invalid Credentials"));
    }

 
}
