/*
 * Spencer Lefever
 * COSC330 Lab2
 * 
 * Class for the manager subclass
 * Superclass : Employee
 */

 public class Manager extends Employee
 {
    private double bonusPay;

    //Constructor
    public Manager(String first, String last, String ssn, double salary, String title, double bonus)
    {
        super(first, last, ssn, salary, title);
        bonusPay = bonus;        
    }

    //copy constructor
    public Manager(Manager manager) 
    {
        super(manager.getFirstName(), manager.getLastName(), manager.getSocialSecurityNumber(), manager.getBaseSalary(), manager.getJobTitle());
        this.bonusPay = manager.bonusPay;
    }

    //get bonus pay
    public double getBonusPay()
    {
        return bonusPay;
    }

    //set bonus pay
    public void setBonusPay(double bonus)
    {
        bonusPay = bonus;
    }

    //earnings function
    public double earnings() 
    {
        return getBonusPay() + getBaseSalary();
    }

    //toString method using super
    public String toString()
    {
        return super.toString() + String.format("bonus pay: %.2f\n", getBonusPay());
    }

    //display info method
    public void displayInfo()
    {
        System.out.println(this.toString());
    }

 }