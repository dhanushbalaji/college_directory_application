package com.college.controller;

import com.college.model.StudentProfile;
import com.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Fetch the profile of the logged-in student
    @GetMapping("/profile/{id}")
    public ResponseEntity<StudentProfile> getStudentProfile(@PathVariable Long id) {
        StudentProfile profile = studentService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    // Update the profile of the logged-in student
    @PutMapping("/profile/{id}")
    public ResponseEntity<StudentProfile> updateStudentProfile(@PathVariable Long id, @RequestBody StudentProfile updatedProfile) {
        StudentProfile profile = studentService.updateProfile(id, updatedProfile);
        return ResponseEntity.ok(profile);
    }

    // Search for other students by name or department
    @GetMapping("/search")
    public ResponseEntity<List<StudentProfile>> searchStudents(@RequestParam String keyword) {
        List<StudentProfile> students = studentService.searchStudents(keyword);
        return ResponseEntity.ok(students);
    }
}
