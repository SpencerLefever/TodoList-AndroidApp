package com.example.exercise4;

public class LambBurger extends Burger{
    double calories;

    public LambBurger() {
        calories = 300;
    }

    @Override
    public double getCalories() {
        return calories;
    }
}
