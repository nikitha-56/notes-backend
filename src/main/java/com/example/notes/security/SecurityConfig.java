package com.example.notes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/notes/share/**").permitAll()  // public share links
            .requestMatchers("/api/auth/**").permitAll()         // allow login/register without auth
            .requestMatchers("/api/notes/**").authenticated()   // protect CRUD endpoints
            .and()
            .httpBasic();  // still keeps basic auth for /api/notes
        return http.build();
    }
}
