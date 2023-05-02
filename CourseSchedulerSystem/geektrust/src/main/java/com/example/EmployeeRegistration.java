package com.example;

public class EmployeeRegistration {
    private final String registrationId;
    private final String employeeEmail;
    private final CourseOffering courseOffering;
    private String status;

    public EmployeeRegistration(String registrationId, String employeeEmail, CourseOffering courseOffering, String status) {
        this.registrationId = registrationId;
        this.employeeEmail = employeeEmail;
        this.courseOffering = courseOffering;
        this.status = status;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        status = newStatus;
    }
}
