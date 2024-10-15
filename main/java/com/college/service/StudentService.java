package com.college.service;

import com.college.model.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private com.college.repository.studentProfileRepository studentProfileRepository;

    public StudentProfile getProfileById(Long id) {
        return studentProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentProfile updateProfile(Long id, StudentProfile updatedProfile) {
        Optional<StudentProfile> existingProfile = studentProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            StudentProfile profile = existingProfile.get();
            profile.setPhoto(updatedProfile.getPhoto());
            profile.setYear(updatedProfile.getYear());
            profile.setDepartment(updatedProfile.getDepartment());
            return studentProfileRepository.save(profile);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    public List<StudentProfile> searchStudents(String keyword) {
        return studentProfileRepository.findByNameContainingIgnoreCaseOrDepartmentNameContainingIgnoreCase(keyword, keyword);
    }
}
