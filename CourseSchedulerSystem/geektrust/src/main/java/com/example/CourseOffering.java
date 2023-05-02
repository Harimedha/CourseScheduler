package com.example;
import java.util.ArrayList;
import java.util.List;

public class CourseOffering {
    
    private final String courseId;
    private final String courseName;
    private final String instructor;
    private final String date;
    private final int minEmployees;
    private final int maxEmployees;
    private final List<EmployeeRegistration> registeredEmployees = new ArrayList<>();

    public CourseOffering(String courseId, String courseName, String instructor, String date, int minEmployees, int maxEmployees) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDate() {
        return date;
    }

    public int getMinEmployees() {
        return minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public List<EmployeeRegistration> getRegisteredEmployees() {
        return registeredEmployees;
    }

    public void addRegisteredEmployee(EmployeeRegistration registration) {
        registeredEmployees.add(registration);
    }

    public boolean isCourseFull() {
        return registeredEmployees.size() >= maxEmployees;
    }

    public boolean isCourseMinimumMet() {
        return registeredEmployees.size() >= minEmployees;
    }
}

