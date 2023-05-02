package com.example;

import java.util.Map;

public class CourseCancel {

        public void cancel(String[] parts, Map<String, CourseOffering> offerings, Map<String, EmployeeRegistration> registrations) {
            if (parts.length != 2) {
                System.out.println("INPUT_DATA_ERROR");
                return;
            }
    
            String registrationId = parts[1];
            EmployeeRegistration registration = registrations.get(registrationId);
    
            if (registration == null) {
                System.out.println("REGISTRATION_NOT_FOUND_ERROR");
                return;
            }
    
            String status = registration.getStatus();
            if (status.equals("CONFIRMED") || status.equals("CANCELLED")) {
                System.out.println(registrationId + " " + "CANCEL_REJECTED");
            } else {
                registration.updateStatus("CANCELLED");
                System.out.println(registrationId + " " + "CANCEL_ACCEPTED");
            }
        }
    }
    
