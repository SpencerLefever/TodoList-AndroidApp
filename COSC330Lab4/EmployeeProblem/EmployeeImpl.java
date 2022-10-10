/**
 * Spencer Lefever
 * COSC330 Lab4 Employee Problem
 * 
 * Employee Implementation class
 * for the employee problem example
 * extends abstract class Employee
 */

 import java.util.Date; 

 public class EmployeeImpl extends Employee {

    public EmployeeImpl(String n) {
        name = n;
    }
        
    public void join(Date joinDate) {
        System.out.println(this.getName() + " joined on " + joinDate);
    }

    public void terminate(Date terminateDate) {
        System.out.println(this.getName() + " termianted on " + terminateDate);
    }

    public String getName() {
        return this.name;
    }

 }