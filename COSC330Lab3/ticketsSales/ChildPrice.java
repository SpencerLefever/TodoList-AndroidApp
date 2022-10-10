/**
 * Spencer Lefever
 * COSC330 Lab3 ChilePrice.java
 * 
 * Child ticket price class that
 * implemensts TicketPrice interface
 */

class ChildPrice implements TicketPrice {
    
    final double CHILD_PRICE = 7.5;
    
    public double calcPrice() {
        return CHILD_PRICE;
    }
 }