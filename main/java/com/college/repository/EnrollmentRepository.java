package com.college.repository;

import com.college.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentUserId(Long studentId);
    List<Enrollment> findByCourseId(Long courseId);
}
