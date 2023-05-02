package com.example;

import java.util.Map;

public class CourseOfferingAddition {

        public void add(String[] parts, Map<String, CourseOffering> offerings) {
            if (parts.length != 6) {
                System.out.println("INPUT_DATA_ERROR");
                return;
            }
    
            try {
                String courseId = "OFFERING-"+ parts[1] + "-" + parts[2];
                CourseOffering courseOffering = new CourseOffering(courseId, parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                offerings.put(courseId, courseOffering);
                System.out.println(courseId);
            } catch (NumberFormatException e) {
                System.out.println("INPUT_DATA_ERROR");
            }
        }
    }

