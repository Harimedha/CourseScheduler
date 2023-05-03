package com.example;

import java.util.Objects;

public class Stock {
    private String name;

    public Stock() {
    }

    public Stock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Stock stock = (Stock) obj;
        return Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
