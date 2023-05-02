package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CourseCancelTest {

    private CourseCancel courseCancel;
    private Map<String, CourseOffering> offerings;
    private Map<String, EmployeeRegistration> registrations;

    @Before
    public void setUp() {
        courseCancel = new CourseCancel();
        offerings = new HashMap<>();
        registrations = new HashMap<>();

        CourseOffering courseOffering = new CourseOffering("OFFERING-PYTHON-JOHN", "PYTHON", "JOHN", "05062022", 1, 3);
        offerings.put("OFFERING-PYTHON-JOHN", courseOffering);

        
        EmployeeRegistration registration = new EmployeeRegistration("REG-COURSE-WOO-PYTHON", "WOO@GMAIL.COM", courseOffering, "ACCEPTED");
        registrations.put("REG-COURSE-WOO-PYTHON", registration);
    }

    @Test
    public void testCancelAccepted() {
        String[] input = {"CANCEL", "REG-COURSE-WOO-PYTHON"};
        courseCancel.cancel(input, offerings, registrations);

        EmployeeRegistration registration = registrations.get("REG-COURSE-WOO-PYTHON");
        assertEquals("CANCELLED", registration.getStatus());
    }

    @Test
    public void testCancelRejected() {
        String[] input = {"CANCEL", "REG-COURSE-WOO-PYTHON"};
        courseCancel.cancel(input, offerings, registrations);
        courseCancel.cancel(input, offerings, registrations);

        EmployeeRegistration registration = registrations.get("REG-COURSE-WOO-PYTHON");
        assertEquals("CANCELLED", registration.getStatus());
    }

    @Test
    public void testCancelRegistrationNotFound() {
        String[] input = {"CANCEL", "REG-COURSE-NONEXISTENT"};
        courseCancel.cancel(input, offerings, registrations);

        EmployeeRegistration registration = registrations.get("REG-COURSE-NONEXISTENT");
        assertEquals(null, registration);
    }
}
