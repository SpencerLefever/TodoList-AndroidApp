package com.example.exercise4;

public class BeefBurger extends Burger{

    int calories;

    public BeefBurger() {
        calories = 350;
    }

    @Override
    public double getCalories() {
        return calories;
    }
}
