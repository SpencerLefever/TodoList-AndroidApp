/**
 * Spencer Lefever
 * COSC330 Lab4 Employee problem
 * 
 * Testing class for the employee
 * problem solution using decorator patter
 */

 public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new EmployeeImpl("Bob");
        employee = new TeamLead(employee);
        employee = new Manager(employee);

        Employee employee2 = new EmployeeImpl("John");
        employee2 = new TeamMember(employee2);

        System.out.println(employee.getName());
        System.out.println(employee2.getName());
    }
 }