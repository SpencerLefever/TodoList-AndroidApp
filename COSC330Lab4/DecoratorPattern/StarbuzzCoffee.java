/**
 * Spencer Lefever 
 * COSC330 Lab4
 * 
 * Starbuzz Coffee testing class
 * for decorator pattern
 */

 public class StarbuzzCoffee {
    public static void main(String[] args) {
      
      //Initialize and decorate first beverage
      Beverage beverage = new DarkRoast();
      beverage = new Milk(beverage);

      //Print first beverage
      System.out.println("Beverage 1: " + beverage.getDescription()+" $"+beverage.cost());

      //Initialize and decorate second beverage
      Beverage beverage2 = new HouseBlend();
      beverage2 = new Milk(beverage2);
      beverage2 = new Mocha(beverage2);

      //Print second beverage
      System.out.println("Beverage 2: " + beverage2.getDescription()+" $"+beverage2.cost());

    }
 }