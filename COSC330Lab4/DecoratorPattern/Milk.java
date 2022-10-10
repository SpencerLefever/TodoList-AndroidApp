/**
 * Spencer Lefever
 * COSC330 Lab4 Decorator Class
 * 
 * Milk Condiment decorator class
 */

 public class Milk extends CondimentDecorator {
    final double COST = 0.50;
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ",Milk";
    }
    public double cost() {
        return COST + beverage.cost();
    }
 }