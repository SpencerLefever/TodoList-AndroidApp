/**
 * Spencer Lefever
 * COSC330 Lab4 Singleton Pattern
 * 
 * Singleton class for the Singleton
 * Pattern problem in lab 4
 */

 public class Singleton {
    private static Singleton instance = null;

    private Singleton() { }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
 }