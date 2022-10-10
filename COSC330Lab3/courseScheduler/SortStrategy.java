/**
 * Spencer Lefever
 * COSC330 Lab3 SortStrategy.java
 * 
 * Interface for sorting strategy
 * in course library for lab 3
 */

 interface SortStrategy {

    //Normal sort method
    public void sort(String [] strings);

    //Sort method for quick sort using start and end indexes
    public void sort(String [] strings, int start, int end);

 }