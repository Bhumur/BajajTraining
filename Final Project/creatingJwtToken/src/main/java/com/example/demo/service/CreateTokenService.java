package com.example.demo.service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class CreateTokenService {

    @Value("${secret}")
    private String secret;

    public String generateToken(String username) {
        Instant now = Instant.now();

        return Jwts.builder()
                .issuer("bajaj")
                .subject(username)
                .claim("name", "trainee bhumur")
                .claim("scope", "read, write")
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(1, ChronoUnit.HOURS)))
                .signWith(getSignInKey()) // ✅ using HMAC-SHA key directly
                .compact();
    }

    private Key getSignInKey() {
        // ✅ use plain bytes (not Base64 decode)
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
