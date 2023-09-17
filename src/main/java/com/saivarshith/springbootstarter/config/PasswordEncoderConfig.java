package com.saivarshith.springbootstarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Following OWASP recommendations
        // Make it configurable through application.properties *only* if absolutely necessary
        return new Argon2PasswordEncoder(16, 32, 1, 12288, 3);
    }

}
