package com.example.exercise4;

public class AsiagoCheese extends CondimentDecorator {
    final int CALORIES = 100;
    Burger burger;

    public AsiagoCheese(Burger b) {
        this.burger = b;
    }


    @Override
    public double getCalories() {
        return CALORIES + burger.getCalories();
    }
}
