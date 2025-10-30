package com.example.demo.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.LoginDto;
import com.example.demo.service.CreateTokenService;

@RestController
@RequestMapping("/auth")
public class JwtController {

    private final CreateTokenService service;
    private final AuthenticationManager authenticationManager;

    public JwtController(CreateTokenService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String generateToken(@RequestBody LoginDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password())
        );

        if (authentication.isAuthenticated()) {
            return service.generateToken(dto.username());
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
