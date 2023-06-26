
import java.util.*;


public class Sorting{

    public void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] > arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+ " ");
            
        }
    }

    

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        Sorting bsort=new Sorting();

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