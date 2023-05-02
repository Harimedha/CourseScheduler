package com.example;

public class Main {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java App <input_file_path>");
            return;
        }

        CourseScheduler courseScheduler = new CourseScheduler();
        courseScheduler.processInput(args[0]);
    }
}

