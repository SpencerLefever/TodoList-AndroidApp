/**
 * Spencer Lefever
 * COSC330 Lab4 Employee Problem
 * 
 * TeamLead concrete decorator class
 * for the employee problem
 */

 public class TeamLead extends EmployeeDecorator {

    protected TeamLead(Employee employee) {
        super(employee);
    }

    public void planning() {
        System.out.println(this.employee.getName() + " os planning.");
    }

    public void motivate() {
        System.out.println(this.employee.getName() + " is motivating his members.");
    }

    public String getName() {
        return this.employee.getName();
    }


 }