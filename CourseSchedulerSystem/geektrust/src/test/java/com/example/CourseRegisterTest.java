package com.example;

import com.example.CourseOffering;
import com.example.CourseRegister;
import com.example.EmployeeRegistration;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CourseRegisterTest {

    private CourseRegister courseRegister;
    private Map<String, CourseOffering> offerings;
    private Map<String, EmployeeRegistration> registrations;

    @Before
    public void setUp() {
        courseRegister = new CourseRegister();
        offerings = new HashMap<>();
        registrations = new HashMap<>();

        CourseOffering courseOffering = new CourseOffering("OFFERING-PYTHON-JOHN", "PYTHON", "JOHN", "05062022", 1, 3);
        offerings.put("OFFERING-PYTHON-JOHN", courseOffering);
    }

    @Test
    public void testRegister() {
        String[] input = {"REGISTER", "andy@gmail.com", "OFFERING-PYTHON-JOHN"};
        courseRegister.register(input, offerings, registrations);

        EmployeeRegistration registration = registrations.get("REG-COURSE-andy-PYTHON");
        assertNotNull(registration);
        assertEquals("REG-COURSE-andy-PYTHON", registration.getRegistrationId());
        assertEquals("andy@gmail.com", registration.getEmployeeEmail());
        assertEquals("PYTHON", registration.getCourseOffering().getCourseName());
        assertEquals("ACCEPTED", registration.getStatus());
    }

    @Test
    public void testRegisterInputDataError() {
        String[] input = {"REGISTER", "andy@gmail.com"};
        courseRegister.register(input, offerings, registrations);
        assertTrue(registrations.isEmpty());
    }

    @Test
    public void testRegisterCourseNotFoundError() {
        String[] input = {"REGISTER", "andy@gmail.com", "OFFERING-NOT-FOUND"};
        courseRegister.register(input, offerings, registrations);
        assertTrue(registrations.isEmpty());
    }

    @Test
    public void testRegisterCourseFullError() {
        String[] input1 = {"REGISTER", "andy@gmail.com", "OFFERING-PYTHON-JOHN"};
        String[] input2 = {"REGISTER", "woo@gmail.com", "OFFERING-PYTHON-JOHN"};
        String[] input3 = {"REGISTER", "alice@gmail.com", "OFFERING-PYTHON-JOHN"};

        courseRegister.register(input1, offerings, registrations);
        courseRegister.register(input2, offerings, registrations);
        courseRegister.register(input3, offerings, registrations);

        // Your test case does not have any assertions for this test method.
        // You might want to add assertions to check the expected behavior.
    }
}
