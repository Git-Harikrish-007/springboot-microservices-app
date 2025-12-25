package com.harikrish.employeeservice.service.impl;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.harikrish.employeeservice.dto.APIResponseDto;
import com.harikrish.employeeservice.dto.DepartmentDto;
import com.harikrish.employeeservice.dto.EmployeeDto;
import com.harikrish.employeeservice.dto.OrganizationDto;
import com.harikrish.employeeservice.entity.Employee;
import com.harikrish.employeeservice.exception.ResourceNotFoundException;
import com.harikrish.employeeservice.repository.EmployeeRepository;
import com.harikrish.employeeservice.service.APIClient;
import com.harikrish.employeeservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private EmployeeRepository employeeRepository;

	private ModelMapper modelMapper;

//	private RestTemplate restTemplate;

	private WebClient webClient;

//	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		Employee employee = modelMapper.map(employeeDto, Employee.class);

		Employee savedEmployee = employeeRepository.save(employee);

		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		
		LOGGER.info("Inside getEmployeeById() method");

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("EmployeeId not exists in database"));

//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//
//		DepartmentDto departmentDto = responseEntity.getBody();

		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();
		
		OrganizationDto organizationDto = webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode()).retrieve()
				.bodyToMono(OrganizationDto.class).block();

//		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

		APIResponseDto apiResponseDto = new APIResponseDto();

		apiResponseDto.setDepartment(departmentDto);

		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

		apiResponseDto.setEmployee(employeeDto);
		
		apiResponseDto.setOrganization(organizationDto);

		return modelMapper.map(apiResponseDto, APIResponseDto.class);
	}

	public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
		
		LOGGER.info("Inside getDefaultDepartment() method");

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("EmployeeId not exists in database"));

		DepartmentDto departmentDto = new DepartmentDto();

		departmentDto.setDepartmentName("R & D");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and Developement Department");

		APIResponseDto apiResponseDto = new APIResponseDto();

		apiResponseDto.setDepartment(departmentDto);

		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

		apiResponseDto.setEmployee(employeeDto);

		return modelMapper.map(apiResponseDto, APIResponseDto.class);

	}

}
