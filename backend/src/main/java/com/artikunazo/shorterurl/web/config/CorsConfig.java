package com.artikunazo.shorterurl.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class CorsConfig {
    
    @Value("${app.cors.allowed-origins:*}")
    private String rawAllowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Split comma-separated values and strip any trailing slashes from each origin
                String[] cleanedOrigins = Arrays.stream(rawAllowedOrigins.split(","))
                        .map(String::trim)
                        .map(origin -> origin.replaceAll("/+$", ""))
                        .filter(origin -> !origin.isEmpty())
                        .toArray(String[]::new);

                registry.addMapping("/**")
                    .allowedOrigins(cleanedOrigins)
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH")
                    .allowedHeaders("*")
                    .maxAge(3600);
            }
        };
    }
}