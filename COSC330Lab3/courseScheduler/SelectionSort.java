/**
 * Spencer Lefever 
 * COSC330 Lab3 SelectionSort.java
 * 
 * Selection sort class
 * implements SortStrategy
 */

 class SelectionSort implements SortStrategy {

    public void sort(String[] array) {

        for ( int j=0; j < array.length-1; j++ )
        {
        
        int min = j;
            for ( int k=j+1; k < array.length; k++ )
                if ( array[k].compareTo( array[min] ) < 0 ) min = k;  

                String temp = array[j];
                array[j] = array[min];
                array[min] = temp;
    }
    }

    //Sort method used for quick sort with empty body
    public void sort(String[] s, int i, int j) {}
 }