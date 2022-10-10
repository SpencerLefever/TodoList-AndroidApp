/**
 * Spencer Lefever
 * COSC330 Lab 3 Course Scheduler
 * 
 * Testing class
 */


public class courseSchedulerTest { 
     public static void main(String[] args) {

        final int STUDENT_ARRAY_SIZE = 10;

        //Initialize student string array
        String[] studentArr = {"Stu3", "Stu7", "Stu8", "Stu9", "Stu6", "Stu5", "Stu4", "Stu0", "Stu1", "Stu2"};

        //Call different sort strategies based on user input in args[0] 
        switch(args[0]) {
            case "BubbleSort":
            
                //Create SortStrategy object and Course object
                SortStrategy bubbleSort = new BubbleSort();
                Course bubbleStrategy = new Course("COSC330", "Dr. Wang", studentArr, bubbleSort);
                bubbleStrategy.sortStudents();
                //Call bubble sort method on array
                
                break;

            case "QuickSort":
                //Create SortStrategy object and Course object
                SortStrategy quickSort = new QuickSort();
                Course quickStrategy = new Course("COSC330", "Dr. Wang", studentArr, quickSort);

                //Call quick sort method on array
                quickStrategy.sortStudents(0, STUDENT_ARRAY_SIZE-1);

                break;

            case "SelectionSort": 

                //Create SortStrategy object and Course object
                SortStrategy selectionSort = new SelectionSort();
                Course selectionStrategy = new Course("COSC330", "Dr. Wang", studentArr, selectionSort);

                //Call selection sort method on array
                selectionStrategy.sortStudents();

                break;

            default:

                System.out.println("Sorting strategy must be passed as argument");
                break;
        }

        //Print Sorted student list
        System.out.println("Printing sorted student list");
        for (int i=0; i<STUDENT_ARRAY_SIZE; i++) {
            System.out.print(studentArr[i]+ " ");
        }
        System.out.println();

 } 
}
