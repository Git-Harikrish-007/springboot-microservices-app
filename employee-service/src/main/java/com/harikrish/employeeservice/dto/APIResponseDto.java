package com.harikrish.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

	private DepartmentDto department;

	private EmployeeDto employee;
	
	private OrganizationDto organization;

}
