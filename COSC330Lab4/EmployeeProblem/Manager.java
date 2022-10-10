/**
 * Spencer Lefever
 * COSC330 Lab4 Employee Problem
 * 
 * Manager concrete decorator class
 * for the employee problem
 */

 public class Manager extends EmployeeDecorator {

    protected Manager(Employee employee) {
        super(employee);
    }

    public void assignTask() {
        System.out.println(this.employee.getName() + " is assigning tasks.");
    }

    public void profileEmployee() {
        System.out.println(this.employee.getName() + " is profiling employees.");
    }
    
    public void createRequirments() {
        System.out.println(this.employee.getName() + " is creating requirment documents.");
    }

    public String getName() {
        return this.employee.getName();
    }

 }