package com.harikrish.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harikrish.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
