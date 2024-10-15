package com.college.controller;

import com.college.model.FacultyProfile;
import com.college.model.Course;
import com.college.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // Fetch the profile of the logged-in faculty member
    @GetMapping("/profile/{id}")
    public ResponseEntity<FacultyProfile> getFacultyProfile(@PathVariable Long id) {
        FacultyProfile profile = facultyService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    // Update the profile of the logged-in faculty member
    @PutMapping("/profile/{id}")
    public ResponseEntity<FacultyProfile> updateFacultyProfile(@PathVariable Long id, @RequestBody FacultyProfile updatedProfile) {
        FacultyProfile profile = facultyService.updateProfile(id, updatedProfile);
        return ResponseEntity.ok(profile);
    }

    // Get the class list for a faculty member
    @GetMapping("/classlist/{facultyId}")
    public ResponseEntity<List<Course>> getClassList(@PathVariable Long facultyId) {
        List<Course> classList = facultyService.getClassList(facultyId);
        return ResponseEntity.ok(classList);
    }
}
