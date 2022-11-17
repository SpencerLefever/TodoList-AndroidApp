package com.example.exercise4;

public class CremeFraiche extends CondimentDecorator {
    final int CALORIES = 150;
    Burger burger;

    public CremeFraiche(Burger b) {
        this.burger = b;
    }


    @Override
    public double getCalories() {
        return CALORIES + burger.getCalories();
    }
}
