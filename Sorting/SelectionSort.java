package Sorting;

import java.util.*;

public class SelectionSort {

    public void swap(int[] arr,int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    

    public void selectionSort(int[] arr, int n){
        for(int i=0;i<n-1;i++){
            int min=i;

            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[min]){
                    min=j;
                }
            }

            if(min != i){
                swap(arr,min,i);
            }
        }
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
            System.out.println();
        }
    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        SelectionSort sort=new SelectionSort();

        System.out.println("\nNumber of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("\nEnter the elements to be stored in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nThe original array is");
        sort.printArray(arr);

        sort.selectionSort(arr, n);
        System.out.println("\nThe new array after sorting is");
        sort.printArray(arr);
    }
    
}
