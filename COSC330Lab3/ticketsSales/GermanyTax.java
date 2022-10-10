/**
 * Spencer Lefever
 * COSC330 Lab3 GermanyTax.java
 * 
 * Germany tax price class that
 * implements SaleTax interface
 */

 class GermanyTax implements SaleTax {

    final double GERMANY_TAX = 0.09;

    public double calcTax() {
        return GERMANY_TAX;
    }
 }