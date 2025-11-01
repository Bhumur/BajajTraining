package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    // 🔒 Secured endpoint (requires GitHub login)
    @GetMapping("/secured")
    public ResponseEntity<String> getDetails(@AuthenticationPrincipal OAuth2User user) {

        // Fetching details from GitHub user info
        String name = user.getAttribute("name");       // GitHub full name
        String login = user.getAttribute("login");     // GitHub username
        String email = user.getAttribute("email");     // May be null if private

        String order = """
                {
                    "orderId": 101,
                    "customerName": "%s",
                    "githubUsername": "%s",
                    "email": "%s",
                    "orderValue": 4050
                }
                """.formatted(name, login, email != null ? email : "private");

        return ResponseEntity.ok(order);
    }

    // 🌐 Public endpoint
    @GetMapping("/unsecured")
    public ResponseEntity<String> unsecured() {
        return ResponseEntity.ok("Unsecured Service — No login required!");
    }
}
