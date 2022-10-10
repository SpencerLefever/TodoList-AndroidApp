/**
 * Spencer Lefever 
 * COSC330 Lab4 
 * 
 * TeamMember concrete decorator
 * for the employee problem
 */

 public class TeamMember extends EmployeeDecorator {

    protected TeamMember(Employee e) {
        super(e);
    }

    public void performTask() {
        System.out.println(employee.getName() + " is performing their assigned tasks.");
    }

    public void coordinateWithOthers() {
        System.out.println(employee.getName()+ " is coordinating with members of his team.");
    }

    public String getName() {
        return this.employee.getName();
    }


 }