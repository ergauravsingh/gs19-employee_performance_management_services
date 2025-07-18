package com.gaurav.employee.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double budget;
    
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;


    @OneToMany(mappedBy = "department")
    private List<Project> projects;
}
