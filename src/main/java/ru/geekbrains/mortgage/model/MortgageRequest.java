package ru.geekbrains.mortgage.model;

import java.io.Serializable;

public class MortgageRequest implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MortgageRequest{" +
            "name='" + name + '\'' +
            '}';
    }
}
