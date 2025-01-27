package com.ecpi.cours_spring.security;

import com.ecpi.cours_spring.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private static final String[] permitURLs = {"/swagger-ui.html",
            "/swagger-ui/index.html",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/swagger-ui.html/**",
            "/swagger-ui/index.html/**",
            "/api-docs/**",
            "/api/auth/**",
            "/api/password/forgot-password/**",
            "/api/password/reset-password/**",
    };

    private final MyUserDetailsService userDetailsService;

    public SecurityConfig(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Désactiver CSRF si nécessaire
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(permitURLs).permitAll() // URLs autorisées sans authentification
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.defaultSuccessUrl("/patients", true)) // Configurer la page de login
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/")); // Configurer la déconnexion

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
