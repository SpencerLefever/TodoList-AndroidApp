/**
 * Spencer Lefever
 * COSC330 Lab4 Decorator Pattern
 * 
 * DarkRoast Concrete Component
 * Extending the Beverage class
 */

 public class DarkRoast extends Beverage {
    final double COST = 2.50;

    public DarkRoast() {
        description = "Dark Roast";
    }

    public double cost() {
        return COST;
    }
 } 