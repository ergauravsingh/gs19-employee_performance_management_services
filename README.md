# gs19-employee_performance_management_services

#### Employee Performance Management System

To manage employee performance and provide review comments and score.

1) Sprint Boot Rest Microservice <br>
2) Java: 17 <br>
3) Spring Boot: 3.5 <br>
4) Default port: 8080 <br>
5) Server Context path: /employee-perf-mgmt <br>
6) Swagger Docs URL: http://<hostname>:<port>/swagger-ui.html <br>
6) H2 Console Path: http://<hostname>:<port>/employee-perf-mgmt/h2-console <br>
7) H2 Connection URL: jdbc:h2:mem:employee-db <br><br>


##### Display Query

SELECT EMPLOYEE.ID, EMPLOYEE.NAME, EMPLOYEE.EMAIL, EMPLOYEE.DATE_OF_JOINING, EMPLOYEE.SALARY, 
DEPARTMENT.NAME, DEPARTMENT.BUDGET, 
EMPLOYEE_PROJECT.ASSIGNED_DATE, EMPLOYEE_PROJECT.ROLE,
PERFORMANCE_REVIEW.REVIEW_DATE, PERFORMANCE_REVIEW.SCORE, PERFORMANCE_REVIEW.REVIEW_COMMENTS

FROM EMPLOYEE, DEPARTMENT, EMPLOYEE_PROJECT, PERFORMANCE_REVIEW 
WHERE EMPLOYEE.DEPARTMENT_ID = DEPARTMENT.ID 
AND EMPLOYEE.ID = EMPLOYEE_PROJECT.EMPLOYEE_ID 
AND EMPLOYEE.ID = PERFORMANCE_REVIEW.EMPLOYEE_ID