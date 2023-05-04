package com.example;

import java.util.Set;
import java.util.stream.Collectors;

public class MutualFund {
    private String name;
    private Set<Stock> stocks;

    public String getFundName() {
        return name;
    }

    public void setFundName(String name) {
        this.name = name;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public MutualFund(String fundName, Set<Stock> stocks) {
        this.name = fundName;
        this.stocks = stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double calculateOverlapPercentage(MutualFund otherFund) {

        Set<Stock> intersection = this.stocks.stream()
                .filter(otherFund.getStocks()::contains)
                .collect(Collectors.toSet());

        int commonStocks = intersection.size();

        int totalStocks = this.stocks.size() + otherFund.getStocks().size();

        if (totalStocks == 0) {
            return 0.0;
        }

        return (double) (2 * commonStocks) / totalStocks * 100;
    }

}
