CREATE TABLE department (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    budget BIGINT
);

CREATE TABLE project (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    start_date DATE,
    end_date DATE,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    department_id INT,
    date_of_joining DATE,
    salary BIGINT,
    manager_id INT,
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (manager_id) REFERENCES employee(id)
);

CREATE TABLE performance_review (
    id INT PRIMARY KEY,
    employee_id INT,
    review_date DATE,
    score INT,
    review_comments VARCHAR(1000),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE employee_project (
    employee_id INT,
    project_id INT,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);
