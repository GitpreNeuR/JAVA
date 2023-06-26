package Sorting;

import java.util.*;

public class QuickSort {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                swap(arr, i, j);
            }

        }

        swap(arr, i + 1, high);

        return (i + 1);
    }

    public void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }

    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + "");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QuickSort sort = new QuickSort();

        System.out.println("\nNumber of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("\nEnter the elements to be stored in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nThe original array is");
        sort.printArray(arr);

        sort.quickSort(arr, 0, n - 1);
        System.out.println("\nThe new array after quick sort is");
        sort.printArray(arr);

    }

}
