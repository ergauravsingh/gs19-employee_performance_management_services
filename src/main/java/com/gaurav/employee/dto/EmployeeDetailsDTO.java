package com.gaurav.employee.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDTO {
	private Long id;
	private String name;
	private String email;
	private String departmentName;
	private Set<EmployeeProjectDTO> projects;
	private List<PerformanceReviewDTO> recentReviews;
}
