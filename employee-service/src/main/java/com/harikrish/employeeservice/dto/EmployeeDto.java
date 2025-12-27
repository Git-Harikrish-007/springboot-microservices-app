package com.harikrish.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Employee Service Model Representation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private Long id;

	@Schema(description = "Employee FirstName")
	private String firstName;

	@Schema(description = "Employee LastName")
	private String lastName;

	@Schema(description = "Employee Email Address")
	private String email;
	
	@Schema(description = "Employee Department Code")
	private String departmentCode;
	
	@Schema(description = "Employee Organization Code")
	private String organizationCode;

}
