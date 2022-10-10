/**
 * Spencer Lefever
 * COSC330 Lab4 Employee Problem
 * 
 * Employee class implementation
 * for employee problem
 * using decorator pattern
 */

 import java.util.Date;

 public abstract class Employee {
    public String name = "Unkown";

    public abstract void join(Date joinDate);
    public abstract void terminate(Date terminateDate);
    public abstract String getName();
 }