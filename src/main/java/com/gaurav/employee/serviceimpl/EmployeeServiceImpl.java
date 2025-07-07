package com.gaurav.employee.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.employee.dto.EmployeeDTO;
import com.gaurav.employee.dto.EmployeeDetailsDTO;
import com.gaurav.employee.dto.EmployeeProjectDTO;
import com.gaurav.employee.dto.PerformanceReviewDTO;
import com.gaurav.employee.entity.Employee;
import com.gaurav.employee.repository.EmployeeRepository;
import com.gaurav.employee.repository.PerformanceReviewRepository;
import com.gaurav.employee.service.EmployeeService;

import jakarta.persistence.EntityManager;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PerformanceReviewRepository performanceReviewRepository;

	@Override
	public List<EmployeeDTO> getEmployeesWithFilters(LocalDate reviewDate, List<String> departmentNames, List<String> projectNames) {
	    List<Employee> employees = employeeRepository.getEmployeesWithFilters(reviewDate, departmentNames, projectNames);

	    return employees.stream()
	        .map(e -> new EmployeeDTO(
	            e.getId(),
	            e.getName(),
	            e.getEmail(),
	            e.getDateOfJoining(),
	            e.getSalary(),
	            e.getDepartment() != null ? e.getDepartment().getName() : null
	        ))
	        .collect(Collectors.toList());
	}

	@Override
	public EmployeeDetailsDTO getEmployeeDetailsById(Long id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		if (employee == null)
			return null;

		List<PerformanceReviewDTO> lastThreeReviews = performanceReviewRepository
				.findTop3ByEmployeeIdOrderByReviewDateDesc(id).stream()
				.map(review -> new PerformanceReviewDTO(review.getId(), review.getReviewComments(),
						review.getReviewDate(), review.getScore()))
				.collect(Collectors.toList());

		Set<EmployeeProjectDTO> projectDTOs = employee.getEmployeeProjects().stream()
				.map(ep -> new EmployeeProjectDTO(ep.getProject().getId(), ep.getProject().getName(),
						ep.getProject().getStartDate(), ep.getProject().getEndDate(), ep.getRole()))
				.collect(Collectors.toSet());

		return new EmployeeDetailsDTO(employee.getId(), employee.getName(), employee.getEmail(),
				employee.getDepartment() != null ? employee.getDepartment().getName() : null, projectDTOs,
				lastThreeReviews);
	}

}
