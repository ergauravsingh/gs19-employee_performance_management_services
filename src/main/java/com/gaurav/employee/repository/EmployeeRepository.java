package com.gaurav.employee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaurav.employee.dto.EmployeeDTO;
import com.gaurav.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT DISTINCT e FROM Employee e " +
		       "LEFT JOIN FETCH e.department d " +
		       "LEFT JOIN FETCH e.employeeProjects ep " +
		       "LEFT JOIN FETCH ep.project p " +
		       "LEFT JOIN FETCH e.performanceReviews r " +
		       "WHERE (:reviewDate IS NULL OR r.reviewDate = :reviewDate) " +
		       "AND (:departmentNames IS NULL OR d.name IN :departmentNames) " +
		       "AND (:projectNames IS NULL OR p.name IN :projectNames)")
		List<Employee> getEmployeesWithFilters(@Param("reviewDate") LocalDate reviewDate,
		                                       @Param("departmentNames") List<String> departmentNames,
		                                       @Param("projectNames") List<String> projectNames);

}
