package com.harikrish.departmentservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.harikrish.departmentservice.dto.DepartmentDto;
import com.harikrish.departmentservice.entity.Department;
import com.harikrish.departmentservice.exception.ResourceNotFoundException;
import com.harikrish.departmentservice.repository.DepartmentRepository;
import com.harikrish.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private ModelMapper modelMapper;

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		Department department = modelMapper.map(departmentDto, Department.class);

		Department saveDepartment = departmentRepository.save(department);

		return modelMapper.map(saveDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
				() -> new ResourceNotFoundException("Department not exists for following code: " + departmentCode));

		return modelMapper.map(department, DepartmentDto.class);
	}

}
