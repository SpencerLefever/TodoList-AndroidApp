/*
 * Spencer Lefever
 * COSC330 Lab2
 * 
 * Class for the executive subclass
 * Superclass : Manager
 */

 public class Executive extends Manager
 {
    private double stockOption;

    public Executive(String first, String last, String ssn, double salary, String title, double bonus, double stock)
    {
        super(first, last, ssn, salary, title, bonus);
        stockOption = stock;
    }

    //copy constructor
    public Executive(Executive executive) 
    {
        super(executive.getFirstName(), executive.getLastName(), executive.getSocialSecurityNumber(), executive.getBaseSalary(), executive.getJobTitle(), executive.getBonusPay());
        this.stockOption = executive.stockOption;
    }

    //set stock option
    public void setStockOption(double stock)
    {
        stockOption = stock;
    }
    //get stock option
    public double getStockOption()
    {
        return stockOption;
    }
    //earnings function
    public double earnings()
    {
        return super.earnings() + getStockOption();
    }

    //toString method using super
    public String toString()
    {
        return super.toString() + String.format("stock option: %.2f\n", getStockOption());
    }

    //display info 
    public void displayInfo()
    {
        System.out.println(this.toString());
    }

 }