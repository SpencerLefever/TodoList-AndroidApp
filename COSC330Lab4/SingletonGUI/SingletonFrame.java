/**
 * Spencer Lefever
 * COSC330 Lab4 Java GUI
 * 
 * SingletonFrame class for the Singleton
 * Pattern GUI problem in lab 4
 */

import javax.swing.*;

public class SingletonFrame extends JFrame{
   private static SingletonFrame instance = null;

   private SingletonFrame() { 
       this.setSize(400,100);
       this.setTitle("Singleton Frame Timestamp: " + System.currentTimeMillis());
       this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   }

   public static SingletonFrame getInstance() {
       if(instance == null) {
           instance = new SingletonFrame();
       }
       return instance;
   }
}