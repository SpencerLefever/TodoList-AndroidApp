/**
 * Spencer Lefever
 * COSC330 Lab3 SeniorPrice.java
 * 
 * Senior ticket price class that
 * implemensts TicketPrice interface
 */

class SeniorPrice implements TicketPrice {
    
    final double SENIOR_PRICE = 9.5;
    
    public double calcPrice() {
        return SENIOR_PRICE;
    }
 }