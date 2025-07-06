package com.gaurav.employee.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.employee.dto.EmployeeDTO;
import com.gaurav.employee.dto.EmployeeDetailsDTO;
import com.gaurav.employee.dto.EmployeeProjectDTO;
import com.gaurav.employee.dto.PerformanceReviewDTO;
import com.gaurav.employee.entity.Employee;
import com.gaurav.employee.entity.PerformanceReview;
import com.gaurav.employee.repository.EmployeeRepository;
import com.gaurav.employee.repository.PerformanceReviewRepository;
import com.gaurav.employee.service.EmployeeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PerformanceReviewRepository performanceReviewRepository;

	@Override
	public List<EmployeeDTO> getEmployeesWithFilters(LocalDate reviewDate, List<String> departmentNames,
			List<String> projectNames) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Employee> employee = query.from(Employee.class);

		Join<Object, Object> department = employee.join("department", JoinType.LEFT);
		Join<Object, Object> projects = employee.join("employeeProjects", JoinType.LEFT);
		Join<Object, Object> reviews = employee.join("performanceReviews", JoinType.LEFT);

		Predicate predicate = cb.conjunction();

		if (reviewDate != null) {
			predicate = cb.and(predicate, cb.equal(reviews.get("reviewDate"), reviewDate));
		}

		if (departmentNames != null && !departmentNames.isEmpty()) {
			predicate = cb.and(predicate, department.get("name").in(departmentNames));
		}

		if (projectNames != null && !projectNames.isEmpty()) {
			predicate = cb.and(predicate, projects.get("name").in(projectNames));
		}

		query.multiselect(employee.get("id"), employee.get("name"), employee.get("email"),
				employee.get("dateOfJoining"), employee.get("salary"), department.get("name")).distinct(true)
				.where(predicate);

		List<Object[]> results = entityManager.createQuery(query).getResultList();

		return results.stream().map(row -> new EmployeeDTO((Long) row[0], (String) row[1], (String) row[2],
				(LocalDate) row[3], (Double) row[4], (String) row[5])).collect(Collectors.toList());
	}

	@Override
	public EmployeeDetailsDTO getEmployeeDetailsById(Long id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		if (employee == null)
			return null;

		List<PerformanceReviewDTO> lastThreeReviews = performanceReviewRepository
				.findTop3ByEmployeeIdOrderByReviewDateDesc(id).stream()
				.map(review -> new PerformanceReviewDTO(review.getId(), review.getReviewComments(),
						review.getReviewDate(), review.getScore()))
				.collect(Collectors.toList());

		Set<EmployeeProjectDTO> projectDTOs = employee.getEmployeeProjects().stream()
				.map(ep -> new EmployeeProjectDTO(ep.getProject().getId(), ep.getProject().getName(),
						ep.getProject().getStartDate(), ep.getProject().getEndDate(), ep.getRole()))
				.collect(Collectors.toSet());

		return new EmployeeDetailsDTO(employee.getId(), employee.getName(), employee.getEmail(),
				employee.getDepartment() != null ? employee.getDepartment().getName() : null, projectDTOs,
				lastThreeReviews);
	}

}
