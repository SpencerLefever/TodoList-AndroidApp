/**
 * Spencer Lefever
 * COSC330 Singleton GUI
 * 
 * MyFrame class that has two buttons
 * calling an instance of the singleton gui
 */

 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;

 public class MyFrame extends JFrame{

    JButton button1 = new JButton();
    JButton button2 = new JButton();

    public MyFrame() {
        init();
    }


    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        button1.setText("Show singleton frame");
        button1.setBounds(new Rectangle(12,12,220,40));
        button1.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SingletonFrame singletonFrame = SingletonFrame.getInstance();
                    singletonFrame.setVisible(true);
                }
            }
        );

        button2.setText("Show same singleton frame");
        button2.setBounds(new Rectangle(12,72,220,40));
        button2.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SingletonFrame singletonFrame = SingletonFrame.getInstance();
                    singletonFrame.setVisible(true);
                }
            }
        );

        this.getContentPane().setLayout(null);
        this.getContentPane().add(button1, null);
        this.getContentPane().add(button2, null);
    }

 }