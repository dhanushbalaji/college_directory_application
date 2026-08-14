package com.college.repository;

import com.college.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface studentProfileRepository extends JpaRepository<StudentProfile, Long> {
    List<StudentProfile> findByUserNameContainingIgnoreCaseOrDepartmentNameContainingIgnoreCase(String name, String departmentName);
}
