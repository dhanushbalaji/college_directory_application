package com.college.service;

import com.college.model.FacultyProfile;
import com.college.model.Course;
import com.college.repository.FacultyProfileRepository;
import com.college.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private CourseRepository courseRepository;

    public FacultyProfile getProfileById(Long id) {
        return facultyProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Faculty member not found"));
    }

    public FacultyProfile updateProfile(Long id, FacultyProfile updatedProfile) {
        Optional<FacultyProfile> existingProfile = facultyProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            FacultyProfile profile = existingProfile.get();
            profile.setPhoto(updatedProfile.getPhoto());
            profile.setOfficeHours(updatedProfile.getOfficeHours());
            profile.setDepartment(updatedProfile.getDepartment());
            return facultyProfileRepository.save(profile);
        } else {
            throw new RuntimeException("Faculty member not found");
        }
    }

    public List<Course> getClassList(Long facultyId) {
        return courseRepository.findByFacultyId(facultyId);
    }
}
