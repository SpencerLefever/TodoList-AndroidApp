/*
 * Spencer Lefever
 * COSC330 Lab2
 * 
 * Class for the SoftwareEngineer subclass
 * Superclass : TechnicalStaff
 */

 public class SoftwareEngineer extends TechnicalStaff
 {
    private double overtimePay;

    //constructor
    public SoftwareEngineer(String first, String last, String ssn, double salary, String title, double profit, double ot)
    {
        super(first, last, ssn, salary, title, profit);
        overtimePay = ot;
    }

    //copy constructor
    public SoftwareEngineer(SoftwareEngineer softwareEngineer)
    {
        super(softwareEngineer.getFirstName(), softwareEngineer.getLastName(), softwareEngineer.getSocialSecurityNumber(), softwareEngineer.getBaseSalary(), softwareEngineer.getJobTitle(), softwareEngineer.getProfitShare());
        this.overtimePay = softwareEngineer.overtimePay;
    }

    //get overtimePay
    public double getOvertimePay()
    {
        return overtimePay;
    }

    //set overtimePay
    public void setOvertimePay(double ot)
    {
        overtimePay = ot;
    }

    //earnings function
    public double earnings()
    {
        return super.earnings() + getOvertimePay();
    }

    //toString method using super
    public String toString()
    {
        return super.toString() + String.format("overtime pay: %.2f\n", getOvertimePay());
    }

    //display info 
    public void displayInfo()
    {
        System.out.println(this.toString());
    }
    
 }