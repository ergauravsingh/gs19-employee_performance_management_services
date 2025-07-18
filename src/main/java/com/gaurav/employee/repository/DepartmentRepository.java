package com.gaurav.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.employee.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
