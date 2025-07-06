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

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<EmployeeDTO> getEmployeesWithFilters(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,
			@RequestParam(required = false) List<String> departments,
			@RequestParam(required = false) List<String> projects) {
		return employeeService.getEmployeesWithFilters(reviewDate, departments, projects);
	}

	@GetMapping("/{id}")
	public EmployeeDetailsDTO getEmployeeDetails(@PathVariable Long id) {
		return employeeService.getEmployeeDetailsById(id);
	}
}
