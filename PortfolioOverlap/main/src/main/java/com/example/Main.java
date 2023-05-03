package com.example;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {

        
        String portfolioJsonFilePath = "src/stock_data.json";

        if (args.length != 1) {
            System.out.println("Usage: java App <input_file_path>");
            return;
        }

        try {
            Portfolio portfolio = DataLoader.loadPortfolioFromJsonFile(portfolioJsonFilePath);
            CommandProcessor commandProcessor = new CommandProcessor(portfolio);
            commandProcessor.processCommandFromFile(args[0]);
        } catch (IOException e) {
            System.err.println("Error loading data from files: " + e.getMessage());
        }
    }
}

