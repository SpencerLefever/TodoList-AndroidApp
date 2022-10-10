/*
 * Spencer Lefever
 * COSC330 Lab2
 * 
 * Class for the technical staff subclass
 * Superclass : Employee
 */

 public class TechnicalStaff extends Employee
 {
    private double profitShare;

    //Constructor
    public TechnicalStaff(String first, String last, String ssn, double salary, String title, double profit)
    {
        super( first, last, ssn, salary, title);
        profitShare = profit;
    }

    //copy constructor
    public TechnicalStaff(TechnicalStaff technicalStaff)
    {
        super(technicalStaff.getFirstName(), technicalStaff.getLastName(), technicalStaff.getSocialSecurityNumber(), technicalStaff.getBaseSalary(), technicalStaff.getJobTitle());
        this.profitShare = technicalStaff.profitShare;
    }

    //get profit share
    public double getProfitShare()
    {
        return profitShare;
    }
    //set profit share
    public void setProfitShare(double profit)
    {
        profitShare = profit;
    }
    //earnings function
    public double earnings()
    {
        return getBaseSalary() + getProfitShare();
    }
    //toString method using super
    public String toString()
    {
        return super.toString() + String.format("profit share: %.2f\n", getProfitShare());
    }

    //display info 
    public void displayInfo()
    {
        System.out.println(this.toString());
    }
 }