package com.example;

import com.example.CourseAllotment;
import com.example.CourseOffering;
import com.example.EmployeeRegistration;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CourseAllotmentTest {
    private CourseAllotment courseAllotment;
    private Map<String, CourseOffering> offerings;
    private Map<String, EmployeeRegistration> registrations;

    @Before
    public void setUp() {
        courseAllotment = new CourseAllotment();
        offerings = new HashMap<>();
        registrations = new HashMap<>();
    }

    @Test
    public void testAllotCourse() {
        // Add a course offering
        String[] addCourseOfferingInput = {"ADD-COURSE-OFFERING", "PYTHON", "JOHN", "05062022", "1", "3"};
        CourseOfferingAddition courseOfferingAddition = new CourseOfferingAddition();
        courseOfferingAddition.add(addCourseOfferingInput, offerings);

        // Register employees
        String[] registerEmployee1 = {"REGISTER", "WOO@GMAIL.COM", "OFFERING-PYTHON-JOHN"};
        String[] registerEmployee2 = {"REGISTER", "ANDY@GMAIL.COM", "OFFERING-PYTHON-JOHN"};
        String[] registerEmployee3 = {"REGISTER", "BOBY@GMAIL.COM", "OFFERING-PYTHON-JOHN"};
        CourseRegister courseRegister = new CourseRegister();
        courseRegister.register(registerEmployee1, offerings, registrations);
        courseRegister.register(registerEmployee2, offerings, registrations);
        courseRegister.register(registerEmployee3, offerings, registrations);

        // Cancel a registration
        String[] cancelRegistration = {"CANCEL", "REG-COURSE-BOBY-PYTHON"};
        CourseCancel courseCancel = new CourseCancel();
        courseCancel.cancel(cancelRegistration, offerings, registrations);

        // Allot the course
        String[] allotInput = {"ALLOT", "OFFERING-PYTHON-JOHN"};
        courseAllotment.allot(allotInput, offerings, registrations);

        // Check if the employee registration statuses are correct
        assertEquals("CONFIRMED", registrations.get("REG-COURSE-WOO-PYTHON").getStatus());
        assertEquals("CONFIRMED", registrations.get("REG-COURSE-ANDY-PYTHON").getStatus());
        assertEquals("CANCELLED", registrations.get("REG-COURSE-BOBY-PYTHON").getStatus());
    }
}
