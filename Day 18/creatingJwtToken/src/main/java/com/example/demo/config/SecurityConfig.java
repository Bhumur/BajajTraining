package com.example.demo.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {	

	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	    }
	
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		
		http
		.csrf(csrf -> csrf.disable())
		.httpBasic(basic -> basic.disable())
		.formLogin(form -> form.disable())
		.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/auth/**")
				.permitAll()
				.anyRequest().authenticated())
		.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}
	
	@Bean
	UserDetailsService users(BCryptPasswordEncoder encoder) {
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(() -> "ROLE_ADMIN");

	    User admin = new User("india", encoder.encode("india"), authorities);
	    User guest = new User("bhutan", encoder.encode("bhutan"), List.of(new SimpleGrantedAuthority("ROLE_GUEST")));

	    return new InMemoryUserDetailsManager(admin, guest);
	}

}

