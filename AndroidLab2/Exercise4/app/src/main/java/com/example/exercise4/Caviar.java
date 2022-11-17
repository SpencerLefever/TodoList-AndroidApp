package com.example.exercise4;

public class Caviar extends CondimentDecorator{
    int calories;
    Burger burger;

    //Amount value is based on the value of the seekbar
    public Caviar(Burger b, int amount) {
        this.burger = b;
        calories = amount*2;
    }


    @Override
    public double getCalories() {
        return calories + burger.getCalories();
    }

}
