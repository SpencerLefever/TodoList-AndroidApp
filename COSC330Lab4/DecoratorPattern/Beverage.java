/**
 * Spencer Lefever 
 * COSC330 Lab4 Decorator Pattern
 * 
 * Beverage class implementation for 
 * starbuzz coffee example using
 * the decorator pattern
 */

public abstract class Beverage {
    String description = "Unkown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}