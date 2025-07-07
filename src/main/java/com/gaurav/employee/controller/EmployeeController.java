package com.gaurav.employee.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.employee.dto.EmployeeDTO;
import com.gaurav.employee.dto.EmployeeDetailsDTO;
import com.gaurav.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Controller", description = "Manage Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Operation(summary = "Get employees with filters", description = "Retrieve a list of employees filtered by review date, departments, and projects")
	@GetMapping
	public List<EmployeeDTO> getEmployeesWithFilters(
			@Parameter(description = "Review date to filter employees", required = false) @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,

			@Parameter(description = "List of departments to filter employees", required = false) @RequestParam(required = false) List<String> departments,

			@Parameter(description = "List of projects to filter employees", required = false) @RequestParam(required = false) List<String> projects) {
		return employeeService.getEmployeesWithFilters(reviewDate, departments, projects);
	}

	@Operation(summary = "Get detailed information of an employee by ID", description = "Retrieve full details of a specific employee using their ID")
	@GetMapping("/{id}")
	public EmployeeDetailsDTO getEmployeeDetails(
			@Parameter(description = "ID of the employee to retrieve", required = true) @PathVariable Long id) {
		return employeeService.getEmployeeDetailsById(id);
	}
}
