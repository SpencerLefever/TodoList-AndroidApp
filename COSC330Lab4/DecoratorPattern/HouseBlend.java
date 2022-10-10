/**
 * Spencer Lefever
 * COSC330 Lab4 Decorator Pattern
 * 
 * HouseBlend Concrete Component
 * Extending the Beverage class
 */

 public class HouseBlend extends Beverage {
    final double COST = 3.00;

    public HouseBlend() {
        description = "Dark Roast";
    }

    public double cost() {
        return COST;
    }
 } 