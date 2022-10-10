/**
 * Spencer Lefever
 * COSC330 Lab4 Decorator Class
 * 
 * Milk Condiment decorator class
 */

public class Mocha extends CondimentDecorator {
    final double COST = 0.75;
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }
    public double cost() {
        return COST + beverage.cost();
    }
 }