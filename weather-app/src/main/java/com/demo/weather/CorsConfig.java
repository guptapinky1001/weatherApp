package com.demo.weather;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**") // Adjust the mapping based on your API endpoints
				.allowedOrigins("http://localhost:3000") // Allow requests from the origin where your ReactJS frontend
															// is hosted
				.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*")
				.allowCredentials(true);
	}
}

