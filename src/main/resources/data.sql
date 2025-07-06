-- src/main/resources/data.sql
INSERT INTO department (id, name, budget) VALUES (1, 'Engineering', 1000000), (2, 'HR', 500000);

INSERT INTO project (id, name, start_date, end_date, department_id) VALUES
(1, 'Apollo', '2025-01-01', '2025-06-30', 1),
(2, 'Zephyr', '2025-03-01', '2025-09-30', 2);

INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id) VALUES
(1, 'Alice Johnson', 'alice@example.com', 1, '2022-03-15', 95000, null),
(2, 'Bob Smith', 'bob@example.com', 1, '2023-05-10', 85000, 1),
(3, 'Carol Lee', 'carol@example.com', 2, '2024-01-20', 70000, null);

INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES
(1, 2, '2025-06-01', 88, 'Consistent performer.'),
(2, 2, '2025-03-01', 92, 'Excellent progress.'),
(3, 2, '2024-12-01', 85, 'Good improvement.');

INSERT INTO employee_project (employee_id, project_id) VALUES
(2, 1),
(3, 2);
