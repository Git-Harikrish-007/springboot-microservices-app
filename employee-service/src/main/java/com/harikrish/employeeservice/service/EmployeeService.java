package com.harikrish.employeeservice.service;

import com.harikrish.employeeservice.dto.APIResponseDto;
import com.harikrish.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	APIResponseDto getEmployeeById(Long employeeId);

}
