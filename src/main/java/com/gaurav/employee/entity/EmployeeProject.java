package com.gaurav.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class EmployeeProject {

    @Id
    private Long employeeId;

    @Id
    private Long projectId;

    private LocalDate assignedDate;
    private String role;

    @ManyToOne
    @JoinColumn(name = "employeeId", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;
}
