package com.example;

import java.util.Map;

public class CurrentPortfolioCommand extends PortfolioCommand {

    public CurrentPortfolioCommand(Portfolio portfolio, Map<String, MutualFund> currentPortfolioFunds) {
        super(portfolio, currentPortfolioFunds);
    }

    @Override
    public void process(String[] parts) {
        currentPortfolioFunds.clear();
        for (int i = 1; i < parts.length; i++) {
            String fundName = parts[i];
            MutualFund fund = portfolio.getFundByName(fundName);
            if (fund != null) {
                // System.out.println("CURRENT PORTFOLIO: " + fund.getFundName());
                currentPortfolioFunds.put(fundName, fund);
            }
        }
    }

}
