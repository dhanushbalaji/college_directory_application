-- Enum for Role
CREATE TYPE Role AS ENUM ('STUDENT', 'FACULTY_MEMBER', 'ADMINISTRATOR');

-- User Table
CREATE TABLE users (
id SERIAL PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
role Role NOT NULL,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
phone VARCHAR(15)
);

-- Department Table
CREATE TABLE departments (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
description TEXT
);

-- StudentProfile Table
CREATE TABLE student_profiles (
user_id INTEGER PRIMARY KEY,
photo VARCHAR(255),
department_id INTEGER NOT NULL,
year VARCHAR(50),
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE
);

-- FacultyProfile Table
CREATE TABLE faculty_profiles (
user_id INTEGER PRIMARY KEY,
photo VARCHAR(255),
department_id INTEGER NOT NULL,
office_hours VARCHAR(255),
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE
);

-- AdministratorProfile Table
CREATE TABLE administrator_profiles (
user_id INTEGER PRIMARY KEY,
photo VARCHAR(255),
department_id INTEGER NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE
);

-- Course Table
CREATE TABLE courses (
id SERIAL PRIMARY KEY,
title VARCHAR(100) NOT NULL,
description TEXT,
department_id INTEGER NOT NULL,
faculty_id INTEGER NOT NULL,
FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE,
FOREIGN KEY (faculty_id) REFERENCES faculty_profiles(user_id) ON DELETE CASCADE
);

-- Enrollment Table
CREATE TABLE enrollments (
id SERIAL PRIMARY KEY,
student_id INTEGER NOT NULL,
course_id INTEGER NOT NULL,
FOREIGN KEY (student_id) REFERENCES student_profiles(user_id) ON DELETE CASCADE,
FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);
