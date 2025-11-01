package com.example.demo.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

    @Value("${secret}")
    private String secret;

    private SecretKey key;

    @PostConstruct
    public void init() {
        // ✅ must match CreateTokenService
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ✅ extract all claims
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // ✅ check expiration
    public boolean isTokenExpired(String token) {
        Date expiration = getAllClaimsFromToken(token).getExpiration();
        return expiration.before(new Date());
    }

    // ✅ check overall validity
    public boolean isTokenValid(String token) {
        try {
            getAllClaimsFromToken(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            System.out.println("JWT validation failed: " + e.getMessage());
            return false;
        }
    }

    // ✅ extract username
    public String extractUsername(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }
}
