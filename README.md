# gs19-employee_performance_management_services

@Author: [Gaurav Singh](https://github.com/ergauravsingh)

---

#### Employee Performance Management System

To manage employee performance and provide review comments and score.

1) Sprint Boot Rest Microservice <br>
2) Java: 17 <br>
3) Spring Boot: 3.5 <br>
4) Default port: 8080 <br>
5) Server Context path: /employee-perf-mgmt <br>


6) Swagger Docs URL: http://<hostname>:<port>/employee-perf-mgmt/swagger-ui/index.html <br>
7) Postman Collection: [Employee Performance Management Services](https://github.com/ergauravsingh/gs19-employee_performance_management_services/blob/master/src/main/resources/postmanCollections/employee_performance_management_services_postmancollection.json) <br>
8) H2 Console Path: http://<hostname>:<port>/employee-perf-mgmt/h2-console <br>
9) H2 Connection URL: jdbc:h2:mem:employee-db <br><br>

---

##### Display Query

SELECT EMPLOYEE.ID, EMPLOYEE.NAME, EMPLOYEE.EMAIL, EMPLOYEE.DATE_OF_JOINING, EMPLOYEE.SALARY, 
DEPARTMENT.NAME, DEPARTMENT.BUDGET, 
EMPLOYEE_PROJECT.ASSIGNED_DATE, EMPLOYEE_PROJECT.ROLE,
PERFORMANCE_REVIEW.REVIEW_DATE, PERFORMANCE_REVIEW.SCORE, PERFORMANCE_REVIEW.REVIEW_COMMENTS

FROM EMPLOYEE, DEPARTMENT, EMPLOYEE_PROJECT, PERFORMANCE_REVIEW 
WHERE EMPLOYEE.DEPARTMENT_ID = DEPARTMENT.ID 
AND EMPLOYEE.ID = EMPLOYEE_PROJECT.EMPLOYEE_ID 
AND EMPLOYEE.ID = PERFORMANCE_REVIEW.EMPLOYEE_ID

---

##### Application Screenshots:

![Swagger Documentation](src/main/resources/screenshots/swaggerdocs.JPG)
*Employee Performance Management System - API Documentation*

---

![Employee Details](src/main/resources/screenshots/employeedetails.JPG)
*Fetch Employee details using ID*

---

![Search by reviewDate](src/main/resources/screenshots/searchbyreviewdate.JPG)
*Get employee details using reviewDate filter*

---

![Search without filters](src/main/resources/screenshots/searchwithoutfilters.JPG)
*Get employee details without using any filter*

---

