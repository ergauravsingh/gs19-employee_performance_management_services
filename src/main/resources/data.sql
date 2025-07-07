-- src/main/resources/data.sql
INSERT INTO department (id, name, budget) VALUES (1, 'Engineering', 1000000), (2, 'Quality', 500000);

INSERT INTO project (id, name, start_date, end_date, department_id) VALUES
(1, 'Mobile App', '2025-01-01', '2025-06-30', 1),
(2, 'Perf Testing', '2025-03-01', '2025-09-30', 2);

INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id) VALUES
(1, 'Gaurav Singh', 'gaurav@example.com', 1, '2022-03-15', 95000, null),
(2, 'John Doe', 'john@example.com', 1, '2023-05-10', 75000, 1),
(3, 'Abhay Singh', 'abhay@example.com', 2, '2024-01-20', 70000, null),
(4, 'Bob Martin', 'bob@example.com', 2, '2024-01-20', 50000, 3);

INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES
(1, 2, '2025-02-01', 38, 'Under PIP.'),
(2, 2, '2025-03-01', 58, 'Not Acceptable.'),
(3, 2, '2025-04-01', 68, 'Need to work hard.'),
(4, 2, '2025-05-01', 78, 'Can be a good performer.'),
(5, 2, '2025-06-01', 88, 'Consistent performer.'),
(6, 4, '2025-03-01', 92, 'Excellent progress.');

INSERT INTO employee_project (employee_id, project_id, assigned_date, role) VALUES
(1, 1, '2025-01-01', 'Dev Lead'),
(2, 1, '2025-01-01', 'Jr. Dev'),
(3, 2, '2025-03-01', 'QA Lead'),
(4, 2, '2025-03-01', 'Jr. QA');
