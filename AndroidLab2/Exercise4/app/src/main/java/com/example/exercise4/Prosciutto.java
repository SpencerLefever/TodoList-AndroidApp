package com.example.exercise4;

public class Prosciutto extends CondimentDecorator {
    final int CALORIES = 200;
    Burger burger;

    public Prosciutto(Burger b) {
        this.burger = b;
    }


    @Override
    public double getCalories() {
        return CALORIES + burger.getCalories();
    }
}
