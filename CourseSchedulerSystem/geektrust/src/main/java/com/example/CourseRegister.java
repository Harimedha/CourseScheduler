package com.example;

import java.util.Map;

public class CourseRegister {
    
    private static final int REGISTER_INPUT_LENGTH = 3;
    private static final String INPUT_DATA_ERROR = "INPUT_DATA_ERROR";
    private static final String COURSE_NOT_FOUND_ERROR = "COURSE_NOT_FOUND_ERROR";
    private static final String COURSE_FULL_ERROR = "COURSE_FULL_ERROR";
    private static final String ACCEPTED = "ACCEPTED";

    public void register(String[] parts, Map<String, CourseOffering> offerings, Map<String, EmployeeRegistration> registrations) {
        if (parts.length != REGISTER_INPUT_LENGTH) {
            System.out.println(INPUT_DATA_ERROR);
            return;
        }

        String email = parts[1];
        String courseId = parts[2];

        CourseOffering courseOffering = offerings.get(courseId);
        if (courseOffering == null) {
            System.out.println(COURSE_NOT_FOUND_ERROR);
            return;
        }

        if (courseOffering.isCourseFull()) {
            System.out.println(COURSE_FULL_ERROR);
            return;
        }

        String registrationId = "REG-COURSE-" + email.split("@")[0] + "-" + courseOffering.getCourseName();
        EmployeeRegistration registration = new EmployeeRegistration(registrationId, email, courseOffering, ACCEPTED);
        registrations.put(registrationId, registration);
        courseOffering.addRegisteredEmployee(registration);

        System.out.println(registrationId + " " + ACCEPTED);
    }
}
