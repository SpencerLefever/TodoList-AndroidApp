package com.example.exercise4;

public class OstrichBurger extends Burger{

    int calories;

    public OstrichBurger() {
        calories = 250;
    }

    @Override
    public double getCalories() {
        return calories;
    }
}
