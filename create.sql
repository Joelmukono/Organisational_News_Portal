CREATE DATABASE news;
\c news;
CREATE TABLE users (userId SERIAL PRIMARY KEY,username VARCHAR,placement VARCHAR,department VARCHAR,departmentsId INTEGER);
CREATE TABLE departments (departmentId SERIAL PRIMARY KEY,departmentName VARCHAR,departmentDescription VARCHAR,numberOfEmployees INTEGER,newsId INTEGER);
CREATE TABLE news (newsId SERIAL PRIMARY KEY,description VARCHAR);
CREATE DATABASE news_test WITH TEMPLATE news;