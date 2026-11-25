
package com.exammanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // Allow homepage and frontend resources
                .requestMatchers(
                    "/",
                    "/*.html",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // Allow student registration
                .requestMatchers(
                    HttpMethod.POST,
                    "/api/auth/register"
                ).permitAll()

                // Allow error page
                .requestMatchers("/error").permitAll()

                // Block all other requests for now
                .anyRequest().denyAll()
            )

            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
