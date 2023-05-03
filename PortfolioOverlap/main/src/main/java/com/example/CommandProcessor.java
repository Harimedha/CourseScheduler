package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {

    private Portfolio portfolio;
    private List<MutualFund> currentPortfolioFunds = new ArrayList<>();

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
                        cmd = new CalculateOverlapCommand(currentPortfolioFunds, portfolio);
                        break;
                    case "ADD_STOCK":
                        cmd = new AddStockCommand(portfolio);
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