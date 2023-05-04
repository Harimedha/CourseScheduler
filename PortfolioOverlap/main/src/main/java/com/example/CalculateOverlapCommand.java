package com.example;

import java.util.Map;

public class CalculateOverlapCommand extends PortfolioCommand {

    public CalculateOverlapCommand(Portfolio portfolio, Map<String, MutualFund> currentPortfolioFunds) {
        super(portfolio, currentPortfolioFunds);
    }

    @Override
    public void process(String[] parts) {
        String targetFundName = parts[1];
        MutualFund targetFund = portfolio.getFundByName(targetFundName);

        if (targetFund != null) {
            for (MutualFund otherFund : currentPortfolioFunds.values()) {

                if (!otherFund.equals(targetFund)) {
                    double overlapPercentage = targetFund.calculateOverlapPercentage(otherFund);
                    if (overlapPercentage != 0.0)
                        System.out.printf("%s %s %.2f%%%n", targetFund.getFundName(), otherFund.getFundName(),
                                overlapPercentage);
                }
            }
        } else {
            System.out.println("FUND_NOT_FOUND");
        }
    }
}
