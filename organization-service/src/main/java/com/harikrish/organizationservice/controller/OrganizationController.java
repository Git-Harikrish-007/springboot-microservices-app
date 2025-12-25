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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;

	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

		return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);

	}

	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode) {

		OrganizationDto organizationByCode = organizationService.getOrganizationByCode(organizationCode);

		return ResponseEntity.ok(organizationByCode);

	}

}
