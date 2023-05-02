package com.example;

import com.example.CourseScheduler;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CourseSchedulerTest {

    @Test
    public void testProcessInput() throws IOException {
        // Create a temporary input file with commands
        Path tempFile = Files.createTempFile("course-scheduler-test", ".txt");
        List<String> commands = Arrays.asList(
                "ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3",
                "REGISTER WOO@GMAIL.COM OFFERING-PYTHON-JOHN",
                "REGISTER ANDY@GMAIL.COM OFFERING-PYTHON-JOHN",
                "REGISTER BOBY@GMAIL.COM OFFERING-PYTHON-JOHN",
                "CANCEL REG-COURSE-BOBY-PYTHON",
                "ALLOT OFFERING-PYTHON-JOHN"
        );
        Files.write(tempFile, commands);

        // Prepare to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Process the input file
        CourseScheduler courseScheduler = new CourseScheduler();
        courseScheduler.processInput(tempFile.toString());

        // Restore the original System.out
        System.setOut(originalOut);

        // Check if the output matches the expected output
        String expectedOutput =
                "OFFERING-PYTHON-JOHN" + System.lineSeparator() +
                "REG-COURSE-WOO-PYTHON ACCEPTED" + System.lineSeparator() +
                "REG-COURSE-ANDY-PYTHON ACCEPTED" + System.lineSeparator() +
                "REG-COURSE-BOBY-PYTHON ACCEPTED" + System.lineSeparator() +
                "REG-COURSE-BOBY-PYTHON CANCEL_ACCEPTED" + System.lineSeparator() +
                "REG-COURSE-ANDY-PYTHON ANDY@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED" + System.lineSeparator() +
                "REG-COURSE-WOO-PYTHON WOO@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED" + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());

        // Clean up the temporary file
        Files.delete(tempFile);
    }
}
