package com.example;

import java.util.List;

public class CurrentPortfolioCommand implements Command {

    private Portfolio portfolio;
    private List<MutualFund> currentPortfolioFunds;

    public CurrentPortfolioCommand(Portfolio portfolio, List<MutualFund> currentPortfolioFunds) {
        this.portfolio = portfolio;
        this.currentPortfolioFunds = currentPortfolioFunds;
    }

    @Override
    public void process(String[] parts) {
        currentPortfolioFunds.clear(); // Clear the current portfolio funds before updating
        for (int i = 1; i < parts.length; i++) {
            String fundName = parts[i];
            MutualFund fund = portfolio.getFundByName(fundName);
            if (fund != null) {
                // System.out.println("CURRENT PORTFOLIO: " + fund.getFundName());
                currentPortfolioFunds.add(fund); // Add the fund to the current portfolio funds list
            }
        }
    }

}
