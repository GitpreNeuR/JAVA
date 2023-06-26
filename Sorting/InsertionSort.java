package Sorting;
import java.util.*;

public class InsertionSort {

    public void insertionSort(int[] arr){

        int n=arr.length;

        for(int i=1; i<n; i++){
            int key=arr[i];
            int j=i-1;

            // Compare key with each element on the left of it until an element smaller than
      // it is found.
      // For descending order, change key<arr[j] to key>arr[j].
      while (j >= 0 && key < arr[j]) {
        arr[j + 1] = arr[j];
        --j;
      }

      // Place key at after the element just smaller than it.
      arr[j + 1] = key;
    }
    }

    public void insertionSortTwo (int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; i++) {
                int currentElement = arr[i];
                int position = i - 1;
                while (position >= 0 && arr[position] > currentElement){
                    arr[position + 1] = arr[position];
                    position--;
                }
                arr[position + 1] = currentElement;
            }
        

        
        
    }
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + "");
            System.out.println();
        }
    }


    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        InsertionSort sort=new InsertionSort();

        System.out.println("\nNumber of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("\nEnter the elements to be stored in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nThe original array is");
        sort.printArray(arr);


        sort.insertionSort(arr);
        System.out.println("\nAfter sorting the list");
        sort.printArray(arr);

        

    }
    
}
