package com.example;

import java.util.Map;

public class AddStockCommand extends PortfolioCommand {

    public AddStockCommand(Portfolio portfolio, Map<String, MutualFund> currentPortfolioFunds) {
        super(portfolio, currentPortfolioFunds);
    }

    public void process(String[] parts) {
        String fundName = parts[1];
        // String stockName = parts[2];
        // int partslen = parts.length;
        StringBuilder stockNameBuilder = new StringBuilder(parts[2]);
        for (int i = 3; i < parts.length; i++) {
            stockNameBuilder.append(" ").append(parts[i]);
        }
        String stockName = stockNameBuilder.toString();

        Stock stock = new Stock(stockName);
        portfolio.addStockToFund(fundName, stock);

        MutualFund updatedFund = portfolio.getFundByName(fundName);
        if (currentPortfolioFunds.containsKey(fundName)) {
            currentPortfolioFunds.put(fundName, updatedFund);
        }

        // System.out.println("Added stock " + stockName + " to fund " + fundName + "
        // Size "
        // + portfolio.getStocksSizeInFund(fundName));
    }
}
