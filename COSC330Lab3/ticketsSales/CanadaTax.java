/**
 * Spencer Lefever
 * COSC330 Lab3 CanadaTax.java
 * 
 * Canada tax price class that
 * implements SaleTax interface
 */

class CanadaTax implements SaleTax {

    final double CANADA_TAX = 0.07;

    public double calcTax() {
        return CANADA_TAX;
    }
 }