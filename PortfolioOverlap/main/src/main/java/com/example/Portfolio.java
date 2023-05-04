package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {

    private Map<String, MutualFund> funds;

    public Portfolio() {
        funds = new HashMap<>();
    }

    public void addFund(MutualFund fund) {
        funds.put(fund.getFundName(), fund);
    }

    public MutualFund getFundByName(String fundName) {
        return funds.get(fundName);
    }

    public void addStockToFund(String fundName, Stock stock) {
        MutualFund fund = getFundByName(fundName);
        if (fund != null) {
            fund.addStock(stock);
        }
    }

    public List<Double> findOverlapPercentages(MutualFund targetFund) {
        System.out.println("Overlap fund calculation called");
        List<Double> overlapPercentages = new ArrayList<>();
        for (MutualFund fund : funds.values()) { // Iterate through the map values
            if (!fund.equals(targetFund)) {
                double overlapPercentage = targetFund.calculateOverlapPercentage(fund);
                overlapPercentages.add(overlapPercentage);
            }
        }
        return overlapPercentages;
    }

    public int getStocksSizeInFund(String fundName) {
        MutualFund fund = getFundByName(fundName);
        if (fund != null) {
            return fund.getStocks().size();
        }
        return -1;
    }

}
