package com.college.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty_profiles")
public class FacultyProfile {

    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "photo")
    private String photo;

    @Column(name = "office_hours")
    private String officeHours;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getOfficeHours() { return officeHours; }
    public void setOfficeHours(String officeHours) { this.officeHours = officeHours; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
