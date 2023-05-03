package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Portfolio {
    
    private List<MutualFund> funds;

    public Portfolio() {
        this.funds = new ArrayList<>();
    }

    public void addFund(MutualFund fund) {
        funds.add(fund);
    }

    public MutualFund getFundByName(String fundName) {
        Optional<MutualFund> fund = funds.stream()
                .filter(f -> f.getFundName().equalsIgnoreCase(fundName))
                .findFirst();

        return fund.orElse(null);
    }

    public void addStockToFund(String fundName, Stock stock) {
        MutualFund fund = getFundByName(fundName);
        if (fund != null) {
            fund.addStock(stock);
        }
    }

    public List<MutualFund> getFunds() {
        return funds;
    }

    public List<Double> findOverlapPercentages(MutualFund targetFund) {
        List<Double> overlapPercentages = new ArrayList<>();
        for (MutualFund fund : funds) {
            if (!fund.equals(targetFund)) {
                double overlapPercentage = targetFund.calculateOverlapPercentage(fund);
                overlapPercentages.add(overlapPercentage);
            }
        }
        return overlapPercentages;
    }
    
}
