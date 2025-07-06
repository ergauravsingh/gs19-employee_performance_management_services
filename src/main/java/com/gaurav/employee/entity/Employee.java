package com.gaurav.employee.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfJoining;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeProject> employeeProjects;

    @OneToMany(mappedBy = "employee")
    private Set<PerformanceReview> performanceReviews;

    // Getters and Setters
}
