package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/orders/unsecured", "/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/oauth2/authorization/github")
                .defaultSuccessUrl("/orders/secured", true)
            )
            .logout(logout -> logout
                // 🧹 Clear Spring session + cookies
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                // ✅ Redirect to GitHub logout page
                .logoutSuccessHandler((request, response, authentication) -> {
                    // Log out locally
                    request.getSession().invalidate();
                    // Optional: Redirect to GitHub logout URL (to clear GitHub session too)
                    response.sendRedirect("https://github.com/logout");
                })
            )
            .csrf(csrf -> csrf.disable()); // disable CSRF for REST use

        return http.build();
    }
}
