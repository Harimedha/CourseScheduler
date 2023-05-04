package com.example;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java App <input_file_path>");
            return;
        }

        Portfolio portfolio = DataLoader.loadPortfolioFromJsonFile();
        CommandProcessor commandProcessor = new CommandProcessor(portfolio);
        commandProcessor.processCommandFromFile(args[0]);
    }
}
