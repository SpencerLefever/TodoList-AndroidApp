/**
 * Spencer Lefever
 * COSC330 Lab3 SaleOrder.java
 * 
 * SaleOrder class for ticket
 * sales library for lab 3
 */

 public class SaleOrder {

    TicketPrice ticketPrice;
    SaleTax saleTax;

    public SaleOrder(TicketPrice t, SaleTax s) {
        ticketPrice = t;
        saleTax = s;
    }
    
    public double calcPrice() {
        return ticketPrice.calcPrice() + 
               (ticketPrice.calcPrice() * saleTax.calcTax());
    }

 }