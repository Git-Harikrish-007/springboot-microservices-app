package com.harikrish.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harikrish.employeeservice.dto.APIResponseDto;
import com.harikrish.employeeservice.dto.EmployeeDto;
import com.harikrish.employeeservice.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;

	@Operation( 
			summary = "Save Employee Rest API",
			description =  "Save Employee Rest API is used to save Employee Object in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);

		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

	}

	@Operation( 
			summary = "Get Employee Rest API",
			description =  "Get Employee Rest API is used to retrieve a Employee details from a database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId) {

		APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);

		return ResponseEntity.ok(apiResponseDto);

	}

}
