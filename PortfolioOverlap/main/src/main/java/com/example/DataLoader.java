package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataLoader {

    public static Portfolio loadPortfolioFromJsonFile() throws IOException {

        // Path jsonpath =
        // FileSystems.getDefault().getPath("src/main/resources/stock_data.json");

        // try (FileReader reader = new FileReader(jsonpath.toString())) {
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(reader);
        // JsonNode fundsJsonArray = rootNode.get("funds");

        java.net.URL url = new java.net.URL(
                "https://geektrust.s3.ap-southeast-1.amazonaws.com/portfolio-overlap/stock_data.json");
        java.net.URLConnection connection = url.openConnection();
        connection.connect();

        try (InputStream inputStream = connection.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(inputStream);
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
                // System.out.println(portfolio.getStocksSizeInFund(fundName) + "============="
                // + fundName);
            }

            return portfolio;
        }
    }
}
