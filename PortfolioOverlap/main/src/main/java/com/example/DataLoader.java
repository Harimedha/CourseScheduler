package com.example;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataLoader {

         
    public static Portfolio loadPortfolioFromJsonFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(reader);
            JsonNode fundsJsonArray = rootNode.get("funds");
    
            Portfolio portfolio = new Portfolio();
            for (JsonNode fundNode : fundsJsonArray) {
                String fundName = fundNode.get("name").asText();
                JsonNode stocksJsonArray = fundNode.get("stocks");
    
                Set<Stock> stocks = new HashSet<>();
                for (JsonNode stockNode : stocksJsonArray) {
                    String stockName = stockNode.asText();
                    stocks.add(new Stock(stockName));
                }
    
                MutualFund fund = new MutualFund(fundName, stocks);
                portfolio.addFund(fund);
            }
    
            return portfolio;
        }
    }
}

