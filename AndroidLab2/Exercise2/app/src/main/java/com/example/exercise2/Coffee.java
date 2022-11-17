package com.example.exercise2;

public class Coffee {
    final double coffeePrice = 4.0;
    final double chocolatePrice = 1.0;
    final double whippedCreamPrice = 0.5;

    public boolean hasChocolate;
    public boolean hasCream;

    //Price of a base coffee
    double price;
    int quantity;

    public Coffee() {
        price = coffeePrice;
        hasChocolate = false;
        hasCream = false;
        quantity = 1;
    }

    public double getPrice() {
        return price * ((double)getQuantity());
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity() {
        quantity++;
    }

    public void subtractQuantity() {
        quantity--;
    }

    public void addChocolate() {
        price += chocolatePrice;
    }

    public void addWhippedCream() {
        price += whippedCreamPrice;
    }

    public void subtractChocolate() {
        price -= chocolatePrice;
    }

    public void subtractWhippedCream() {
        price -= whippedCreamPrice;
    }

    public String createSummary() {
        String summary = "";

        //First line asking about whipped cream
        summary += "Add whipped cream? ";
        if(hasCream) {
            summary += "yes\n";
        }
        else {
            summary += "no\n";
        }

        //Second line asking about chocolate
        summary+= "Add chocolate? ";
        if(hasChocolate) {
            summary += "yes\n";
        }
        else {
            summary += "no\n";
        }

        //Third line asking for quantity
        summary += "Quantity: " + getQuantity() + "\n\n";

        //Fourth line asking for price
        summary += "Price: $" + getPrice() + "\n";

        //Thank you line
        summary += "THANK YOU!\n";

        return summary;
    }



}

