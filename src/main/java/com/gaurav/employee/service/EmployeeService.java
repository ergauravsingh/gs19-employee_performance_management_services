package com.gaurav.employee.service;

import java.time.LocalDate;
import java.util.List;

import com.gaurav.employee.dto.EmployeeDTO;
import com.gaurav.employee.dto.EmployeeDetailsDTO;

public interface EmployeeService {

	List<EmployeeDTO> getEmployeesWithFilters(LocalDate reviewDate, List<String> departmentNames,
			List<String> projectNames);

	EmployeeDetailsDTO getEmployeeDetailsById(Long id);
}
