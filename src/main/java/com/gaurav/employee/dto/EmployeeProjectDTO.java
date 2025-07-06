package com.gaurav.employee.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectDTO {
    private Long projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String role;
}
