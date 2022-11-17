package com.example.exercise3;

public class ShippingCalculator {

    double weight;
    double baseCost;
    double additionalCost;

    public ShippingCalculator() {

    }

    public void setCost() {

        //Calc cost if weight is between 16 and 30 ozs
        if(weight > 16 && weight < 30) {
            baseCost = 3.0;
            //Calculate additional cost $0.5 for every 4 ozs over 16
            additionalCost = ((int)((weight-16)/4))*0.5;

        } else if (weight >= 30) {   //If weight is greater than 30oz
            baseCost = 4.0;

            //Calculate additional cost $0.5 for every 4 oz over 16
            additionalCost = ((int)((weight-16)/4))*0.5;
        }
        else { //If weight is less than 16 oz
            baseCost = 3.0;
            additionalCost = 0.0;
        }
    }

    public double getTotalCost() {
        return baseCost + additionalCost;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setWeight(double w) {
        weight = w;
    }

    public String createSummary() {
        String summary = "";

        //Base cost line
        summary += "$" + getBaseCost() + "\n";

        //Added cost line
        summary += "$" + getAdditionalCost() + "\n";

        //Total cost line
        summary += "$" + getTotalCost() + "\n";

        return summary;
    }

}
