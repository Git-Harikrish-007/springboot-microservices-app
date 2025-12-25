package com.harikrish.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harikrish.employeeservice.dto.DepartmentDto;

@FeignClient(value = "DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("/api/departments/{department-code}")
	DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}
