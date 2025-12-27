package com.harikrish.organizationservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(info = @Info(

		title = "Organization Service REST APIs", 
		description = "Organization Service REST APIs Documentation", 
		version = "v1.0", 
		contact = @Contact(
				name = "Harikrish", 
				email = "harikrisheee007@gmail.com",
				url = "https://mail.google.com"), 
		license = @License(
				name = "Apache 3.0", 
				url = "https://mail.google.com")
		), 
externalDocs = @ExternalDocumentation(
				description = "Spring Boot Microservice Project for Organization-service", 
				url = "https://mail.google.com"
)
)
@SpringBootApplication
@EnableDiscoveryClient
public class OrganizationServiceApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
