/**
 * Spencer Lefever
 * Main file for testing COSC330 Lab 2
 */

public class test {

    public static void main(String[] args) {

        //Create an array of 3 employee elements called emp
        Employee employeeArray[] = new Employee[3];

        /*
         * Define 3 variables
         * emp0 : Executive
         * emp1 : Software engineer
         * emp2 : Test engineer
        */

        //Create executive
        Executive executive = new Executive("John", "Smith", "123-12-1234", 100000, "BigBoss", 5000, 2500);

        //Create software engineer
        SoftwareEngineer softwareEngineer = new SoftwareEngineer("Jim", "Bob", "321-21-4321", 75000, "Sr. Dev", 2500, 5000);

        //Create test engineer
        TestEngineer testEngineer = new TestEngineer("Spencer", "Lefever", "999-99-9999", 65000, "Test Engineer", 5000);

        //Assign employee variables to corresponding elements in the array
        employeeArray[0] = executive;
        employeeArray[1] = softwareEngineer;
        employeeArray[2] = testEngineer;


        //Call display employees method i.e. emp[0].DisplayInfo()
        System.out.println("Printing employeeArray[0]");
        employeeArray[0].displayInfo();
        
        System.out.println("Printing employeeArray[1]");
        employeeArray[1].displayInfo();
        
        System.out.println("Printing employeeArray[2]");
        employeeArray[2].displayInfo();

        //Call display employees method i.e. emp0.DisplayInfo()
        System.out.println("Printing executive");
        executive.displayInfo();

        System.out.println("Printing softwareEngineer");
        softwareEngineer.displayInfo();

        System.out.println("Printing testEngineer");
        testEngineer.displayInfo();

    }
}
 