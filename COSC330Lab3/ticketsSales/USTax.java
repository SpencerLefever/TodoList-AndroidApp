/**
 * Spencer Lefever
 * COSC330 Lab3 USTax.java
 * 
 * US tax price class that
 * implements SaleTax interface
 */

class USTax implements SaleTax {

    final double US_TAX = 0.05;

    public double calcTax() {
        return US_TAX;
    }
 }