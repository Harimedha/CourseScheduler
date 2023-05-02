package com.example;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CourseOfferingAdditionTest {

    @Test
    public void testAdd() {
        CourseOfferingAddition courseOfferingAddition = new CourseOfferingAddition();
        Map<String, CourseOffering> offerings = new HashMap<>();

        String[] input = {"ADD-COURSE-OFFERING", "PYTHON", "JOHN", "05062022", "1", "3"};
        courseOfferingAddition.add(input, offerings);

        String courseId = "OFFERING-PYTHON-JOHN";
        CourseOffering courseOffering = offerings.get(courseId);

        assertNotNull(courseOffering);
        assertEquals(courseId, courseOffering.getCourseId());
        assertEquals("PYTHON", courseOffering.getCourseName());
        assertEquals("JOHN", courseOffering.getInstructor());
        assertEquals("05062022", courseOffering.getDate());
        assertEquals(1, courseOffering.getMinEmployees());
        assertEquals(3, courseOffering.getMaxEmployees());
    }
}
