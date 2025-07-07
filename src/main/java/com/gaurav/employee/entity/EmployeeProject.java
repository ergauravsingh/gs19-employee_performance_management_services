package com.gaurav.employee.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProject {

	@EmbeddedId
	private EmployeeProjectId id;

	@ManyToOne
	@MapsId("employeeId")
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@MapsId("projectId")
	@JoinColumn(name = "project_id")
	private Project project;

	private LocalDate assignedDate;
	private String role;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EmployeeProject))
			return false;
		EmployeeProject project = (EmployeeProject) o;
		return Objects.equals(id, project.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
