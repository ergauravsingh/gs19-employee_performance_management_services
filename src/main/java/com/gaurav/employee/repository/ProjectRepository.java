package com.gaurav.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.employee.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
