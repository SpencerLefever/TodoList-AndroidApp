// Fig. 10.4: Employee.java
// Employee abstract superclass.

public abstract class Employee 
{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private double baseSalary;
   private String jobTitle;

   // three-argument constructor
   public Employee( String first, String last, String ssn, double salary, String title)
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
      baseSalary = salary;
      jobTitle = title;
   } // end three-argument Employee constructor

   //copy constructor
   public Employee(Employee employee) 
   {
      this.firstName = employee.firstName;
      this.lastName = employee.lastName;
      this.socialSecurityNumber = employee.socialSecurityNumber;
      this.baseSalary = employee.baseSalary;
      this.jobTitle = employee.jobTitle;
   }

   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn; // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } // end method getSocialSecurityNumber

   // set base salary
   public void setBaseSalary( double salary ) 
   {
      baseSalary = salary;
   }

   // return base salary
   public double getBaseSalary()
   {
      return baseSalary;
   }

   //set job title
   public void setJobTitle( String title )
   {
      jobTitle = title;
   }
   //get job title
   public String getJobTitle()
   {
      return jobTitle;
   }

   // return String representation of Employee object
   public String toString()
   {
      return String.format( "%s %s\nsocial security number: %s\njob title: %s\nbase salary: %.2f\n", 
         getFirstName(), getLastName(), getSocialSecurityNumber(), getJobTitle(), getBaseSalary() );
   } // end method toString

   //display info method
   public void displayInfo()
   {
      System.out.println(this.toString());
   }

   // abstract method overridden by subclasses
   public abstract double earnings(); // no implementation here
} // end abstract class Employee


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
