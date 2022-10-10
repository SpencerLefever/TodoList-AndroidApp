/* *
 * Spencer Lefever
 * COSC330 Lab3 Course.java
 * 
 * Course sorting library
 * for lab 3
 */

 public class Course {

    private String title;
    private String instructor;
    private String[] studentArr;
    private SortStrategy sortStrategy;
    
    public Course(String t, String i, String[] sArr, SortStrategy s) {
        title = t;
        instructor = i;
        studentArr = sArr;
        sortStrategy = s;
    }

    public void sortStudents() {
        sortStrategy.sort(this.studentArr);
    }

    //Because quick sort requires additional paramenters
    //another method needs to be made to handle quick sort
    //In the future this can also handle other sorting algorithms
    //That require 2 integers for indexes as arguments
    public void sortStudents(int i, int k) {
        sortStrategy.sort(this.studentArr, i, k);
    } 

 }