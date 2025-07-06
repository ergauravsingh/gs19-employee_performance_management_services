package com.gaurav.employee.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeProjectId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long employeeId;
	private Long projectId;

	public EmployeeProjectId() {
	}

	public EmployeeProjectId(Long employeeId, Long projectId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, projectId);
	}
}
