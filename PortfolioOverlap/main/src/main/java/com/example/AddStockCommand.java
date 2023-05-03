package com.example;

public class AddStockCommand implements Command {
    private Portfolio portfolio;

    public AddStockCommand(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public void process(String[] parts) {
        String fundName = parts[1];
        String stockName = parts[2];
        Stock stock = new Stock(stockName);
        portfolio.addStockToFund(fundName, stock);
        // System.out.println("Added stock " + stockName + " to fund " + fundName);
    }
}
