package Sorting;
import java.util.*;


public class BubbleSort{

    public void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+ "");
            System.out.println();
        }
    }

    

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        BubbleSort bsort=new BubbleSort();

        System.out.println("\nNumber of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("\nEnter the elements to be stored in array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }


        System.out.println("\nThe original array is");
        bsort.printArray(arr);

    bsort.bubbleSort(arr);
    System.out.println("\nAfter sorting the array");
    bsort.printArray(arr);
    
    

    




    }
}