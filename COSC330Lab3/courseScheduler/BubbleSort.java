/**
 * Spencer Lefever 
 * COSC330 Lab3 BubbleSort.java
 * 
 * Bubble sort class
 * implements SortStrategy
 */

class BubbleSort implements SortStrategy {

    public void sort(String[] strings) {
        //Implementation of bubble sort
        String tmp;
        for (int i=0; i<strings.length; i++) {
            for (int j= i+1; j<strings.length; j++) {

                if (strings[j].compareTo(strings[i]) < 0) {
                   tmp = strings[i];
                   strings[i] = strings[j];
                   strings[j] = tmp; 
                }
            }
        }
    }

    //Sort method used for quick sort with empty body
    public void sort(String[] s, int i, int j) {}
 }