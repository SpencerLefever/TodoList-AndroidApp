/**
 * Spencer Lefever
 * COSC330 Lab4 Employee Problem
 * 
 * EmployeeDecorator class for the 
 * employee problem
 */

 import java.util.Date;

 public abstract class EmployeeDecorator extends Employee {
    protected Employee employee;

    protected EmployeeDecorator(Employee e) {
        this.employee = e;
    }

    public void join(Date joinDate) {
        employee.join(joinDate);
    }

    public void terminate(Date terminateDate) {
        employee.terminate(terminateDate);
    }

 }