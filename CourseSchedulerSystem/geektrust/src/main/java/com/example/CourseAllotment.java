package com.example;


import java.util.Comparator;
import java.util.List;
import java.util.Map;



public class CourseAllotment {
    private static final String COURSE_CANCELED = "COURSE_CANCELED";
    private static final String CONFIRMED = "CONFIRMED";
    private static final String CANCELLED = "CANCELLED";

        public void allot(String[] parts, Map<String, CourseOffering> offerings, Map<String, EmployeeRegistration> registrations) {
            if (parts.length != 2) {
                System.out.println("INPUT_DATA_ERROR");
                return;
            }
    
            String courseId = parts[1];
    CourseOffering courseOffering = offerings.get(courseId);

    if (courseOffering == null) {
        System.out.println("COURSE_NOT_FOUND_ERROR");
        return;
    }

    boolean courseMinimumMet = courseOffering.isCourseMinimumMet();
    List<EmployeeRegistration> registeredEmployees = courseOffering.getRegisteredEmployees();

    if (!courseMinimumMet) {
        for (EmployeeRegistration registration : registeredEmployees) {
            registration.updateStatus(COURSE_CANCELED); 
        }
    } else {
        for (EmployeeRegistration registration : registeredEmployees) {
            if (!registration.getStatus().equals(CANCELLED)) {
                registration.updateStatus(CONFIRMED);
            }
        }
    }

    // Sort registered employees based on the Registration number
    registeredEmployees.sort(Comparator.comparing(EmployeeRegistration::getRegistrationId));

    for (EmployeeRegistration registration : registeredEmployees) {
        if (!registration.getStatus().equals(CANCELLED)) {
            System.out.println(registration.getRegistrationId() + " "
                    + registration.getEmployeeEmail() + " "
                    + courseId + " "
                    + courseOffering.getCourseName() + " "
                    + courseOffering.getInstructor() + " "
                    + courseOffering.getDate() + " "
                    + registration.getStatus());
        }
    }
}
}

    
