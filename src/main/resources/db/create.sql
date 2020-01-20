SET MODE PostgreSQL;


CREATE TABLE IF NOT EXISTS users (
 userId int PRIMARY KEY auto_increment,
 userName VARCHAR,
 placement VARCHAR,
 department VARCHAR,
 departmentsId int

);

CREATE TABLE IF NOT EXISTS departments (
 departmentId int PRIMARY KEY auto_increment,
 departmentName VARCHAR,
 departmentDescription VARCHAR,
 numberOfEmployees int

);



