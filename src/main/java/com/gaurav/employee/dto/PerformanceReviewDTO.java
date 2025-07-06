package com.gaurav.employee.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerformanceReviewDTO {
	private Long id;
	private String comments;
	private LocalDate reviewDate;
	private int score;
	// constructor, getters, setters
}
