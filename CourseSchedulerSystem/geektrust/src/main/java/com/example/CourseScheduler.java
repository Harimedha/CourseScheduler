package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CourseScheduler {
    
        private final Map<String, CourseOffering> offerings = new HashMap<>();
        private final Map<String, EmployeeRegistration> registrations = new HashMap<>();
        private final CourseOfferingAddition courseOfferingAddition = new CourseOfferingAddition();
        private final CourseRegister courseRegister = new CourseRegister();
        private final CourseCancel courseCancel = new CourseCancel();
        private final CourseAllotment courseAllotment = new CourseAllotment();
    
        public void processInput(String inputFilePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    String command = parts[0];
    
                    switch (command) {
                        case "ADD-COURSE-OFFERING":
                            courseOfferingAddition.add(parts,offerings);
                            break;
                        case "REGISTER":
                            courseRegister.register(parts, offerings, registrations);
                            break;
                        case "CANCEL":
                            courseCancel.cancel(parts, offerings,registrations);
                            break;
                        case "ALLOT":
                            courseAllotment.allot(parts, offerings, registrations);
                            break;
                        default:
                            System.out.println("Invalid command");
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading input file: " + e.getMessage());
            }
        }
    }



