/*
 * Spencer Lefever
 * COSC330 Lab2
 * 
 * Class for the TestEngineer subclass
 * Superclass : TechnicalStaff
 */

 public class TestEngineer extends TechnicalStaff
 {

    //constructor
    public TestEngineer(String first, String last, String ssn, double salary, String title, double profit)
    {
        super(first, last, ssn, salary, title, profit);
    }

    //copy constructor
    public TestEngineer(TestEngineer testEngineer)
    {
        super(testEngineer.getFirstName(), testEngineer.getLastName(), testEngineer.getSocialSecurityNumber(), testEngineer.getBaseSalary(), testEngineer.getJobTitle(), testEngineer.getProfitShare());
    }

    //earnings function
    public double earnings()
    {
        return super.earnings();
    }

    //toString method using super
    public String toString()
    {
        return super.toString();
    }

    //display info 
    public void displayInfo()
    {
        System.out.println(this.toString());
    }

 }