package com.harikrish.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harikrish.departmentservice.dto.DepartmentDto;
import com.harikrish.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Departement Service - DepartmentController", 
	 description = "Department Controller exposes Rest APIs for Department-Service")
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;

	@Operation( 
			summary = "Save Department Rest API",
			description =  "Save Department Rest API is used to save Department Object in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {

		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);

	}

	@Operation( 
			summary = "Get Department Rest API",
			description =  "Get Department Rest API is used to retrieve a Department details from a database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {

		DepartmentDto departmentByCode = departmentService.getDepartmentByCode(departmentCode);

		return ResponseEntity.ok(departmentByCode);

	}

}
