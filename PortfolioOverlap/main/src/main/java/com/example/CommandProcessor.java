package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandProcessor {

    private Portfolio portfolio;
    private Map<String, MutualFund> currentPortfolioFunds = new LinkedHashMap<>();

    public CommandProcessor(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void processCommandFromFile(String inputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String commandType = parts[0];

                Command cmd;
                switch (commandType) {
                    case "CURRENT_PORTFOLIO":
                        cmd = new CurrentPortfolioCommand(portfolio, currentPortfolioFunds);
                        break;
                    case "CALCULATE_OVERLAP":
                        cmd = new CalculateOverlapCommand(portfolio, currentPortfolioFunds);
                        break;
                    case "ADD_STOCK":
                        cmd = new AddStockCommand(portfolio, currentPortfolioFunds);
                        break;
                    default:
                        System.out.println("Unknown command: " + commandType);
                        return;
                }
                cmd.process(parts);
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }
}