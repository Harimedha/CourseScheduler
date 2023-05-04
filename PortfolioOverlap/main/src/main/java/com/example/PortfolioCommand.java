package com.example;

import java.util.Map;

public abstract class PortfolioCommand implements Command {
    protected Portfolio portfolio;
    protected Map<String, MutualFund> currentPortfolioFunds;

    public PortfolioCommand(Portfolio portfolio, Map<String, MutualFund> currentPortfolioFunds) {
        this.portfolio = portfolio;
        this.currentPortfolioFunds = currentPortfolioFunds;
    }
}
