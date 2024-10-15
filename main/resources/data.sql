-- Insert initial departments
INSERT INTO departments (name, description) VALUES
('Computer Science', 'Department of Computer Science'),
('Mathematics', 'Department of Mathematics'),
('Physics', 'Department of Physics'),
('Chemistry', 'Department of Chemistry');

-- Insert initial users
INSERT INTO users (username, password, name, email, phone, role) VALUES
('student1', '$2a$10$5Wg/Z5IWqjP0HupKd3XY4uZoJ9BQahwXQ.JJZ2RlF.DtMgMC3jLV6', 'John Doe', 'john.doe@example.com', '123-456-7890', 'STUDENT'),
('faculty1', '$2a$10$5Wg/Z5IWqjP0HupKd3XY4uZoJ9BQahwXQ.JJZ2RlF.DtMgMC3jLV6', 'Jane Smith', 'jane.smith@example.com', '098-765-4321', 'FACULTY_MEMBER'),
('admin1', '$2a$10$5Wg/Z5IWqjP0HupKd3XY4uZoJ9BQahwXQ.JJZ2RlF.DtMgMC3jLV6', 'Admin User', 'admin@example.com', '555-555-5555', 'ADMINISTRATOR');

-- Insert student profiles
INSERT INTO student_profiles (user_id, photo, year, department_id) VALUES
((SELECT id FROM users WHERE username = 'student1'), 'https://example.com/photos/john_doe.jpg', 'Freshman',
(SELECT id FROM departments WHERE name = 'Computer Science'));

-- Insert faculty profiles
INSERT INTO faculty_profiles (user_id, photo, office_hours, department_id) VALUES
((SELECT id FROM users WHERE username = 'faculty1'), 'https://example.com/photos/jane_smith.jpg', 'MWF 10:00-12:00',
(SELECT id FROM departments WHERE name = 'Mathematics'));

-- Insert administrator profiles
INSERT INTO administrator_profiles (user_id, photo, department_id) VALUES
((SELECT id FROM users WHERE username = 'admin1'), 'https://example.com/photos/admin_user.jpg',
 (SELECT id FROM departments WHERE name = 'Computer Science'));

-- Insert courses
INSERT INTO courses (title, description, department_id, faculty_id) VALUES
('Introduction to Programming', 'Basic programming concepts using Python',
 (SELECT id FROM departments WHERE name = 'Computer Science'),
 (SELECT user_id FROM faculty_profiles WHERE user_id = (SELECT id FROM users WHERE username = 'faculty1'))),
('Calculus I', 'Differential and integral calculus',
 (SELECT id FROM departments WHERE name = 'Mathematics'),
 (SELECT user_id FROM faculty_profiles WHERE user_id = (SELECT id FROM users WHERE username = 'faculty1')));
