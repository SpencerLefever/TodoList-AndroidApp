/**
 * Spencer Lefever 
 * COSC330 Lab3 QuickSort.java
 * 
 * Quick sort class
 * implements SortStrategy
 */

class QuickSort implements SortStrategy {

    public void sort(String[] stuArr, int start, int end) {
        //Implementation of quick sort
            int i = start;
            int k = end;
            if (end - start >= 1) {
                String pivot = stuArr[start];
                while (k > i) {
                    while (stuArr[i].compareTo(pivot) <= 0 && i <= end && k > i)
                        i++;
                    while (stuArr[k].compareTo(pivot) > 0 && k >= start && k >= i)
                        k--;
                    if (k > i)
                        swap(stuArr, i, k);
                }
                swap(stuArr, start, k);
                sort(stuArr, start, k - 1);
                sort(stuArr, k + 1, end);
            } else { return; }

    }

    public void swap(String[] swapArr, int index1, int index2) {
        String temp = swapArr[index1];
        swapArr[index1] = swapArr[index2];
        swapArr[index2] = temp;
    }

    //Blank method for other sorts
    public void sort(String [] s) {}
 }