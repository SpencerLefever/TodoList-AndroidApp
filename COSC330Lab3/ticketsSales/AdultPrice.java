/**
 * Spencer Lefever
 * COSC330 Lab3 AdultPrice.java
 * 
 * Adult ticket price class that
 * implemensts TicketPrice interface
 */

 class AdultPrice implements TicketPrice {
    
    final double ADULT_PRICE = 11.5;
    
    public double calcPrice() {
        return ADULT_PRICE;
    }
 }