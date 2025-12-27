package com.harikrish.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harikrish.organizationservice.dto.OrganizationDto;
import com.harikrish.organizationservice.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Organization Service - OrganizationController", 
description = "Organization Controller exposes Rest APIs for Organization-Service")
@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;

	@Operation( 
			summary = "Save Organization Rest API",
			description =  "Save Organization Rest API is used to save Organization Object in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

		return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);

	}

	@Operation( 
			summary = "Get Organization Rest API",
			description =  "Get Organization Rest API is used to retrieve a Organization details from a database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode) {

		OrganizationDto organizationByCode = organizationService.getOrganizationByCode(organizationCode);

		return ResponseEntity.ok(organizationByCode);

	}

}
