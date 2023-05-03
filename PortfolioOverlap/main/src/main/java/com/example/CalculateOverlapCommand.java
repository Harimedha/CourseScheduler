package com.example;

import java.util.List;

public class CalculateOverlapCommand implements Command {

    private List<MutualFund> currentPortfolioFunds;
    private Portfolio portfolio;

    public CalculateOverlapCommand(List<MutualFund> currentPortfolioFunds, Portfolio portfolio) {
        this.currentPortfolioFunds = currentPortfolioFunds;
        this.portfolio = portfolio;
    }

    @Override
    public void process(String[] parts) {
        String targetFundName = parts[1];
        MutualFund targetFund = portfolio.getFundByName(targetFundName);

        if (targetFund != null) {
            for (MutualFund otherFund : currentPortfolioFunds) {
                if (!otherFund.equals(targetFund)) {
                    double overlapPercentage = targetFund.calculateOverlapPercentage(otherFund);
                    System.out.printf("%s %s %.2f%%%n", targetFund.getFundName(), otherFund.getFundName(),
                            overlapPercentage);
                }
            }
        } else {
            System.out.println("FUND_NOT_FOUND");
        }
    }
}
