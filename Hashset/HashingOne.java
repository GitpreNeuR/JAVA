package Hashset;

import java.util.*;

public class HashingOne {

    static boolean findSubarray(int arr[], int target) {
        int sum;
        int N=arr.length;
        for (int i = 0; i < N; i++) {
          sum = arr[i];
          for (int j = i + 1; j <= N; j++) {
            if (sum == target) {
              // subarray found from i to j-1;
              return true;
            }
            if (sum > target || j == N)
              break;
            sum = sum + arr[j];
          }
        }
        return false;
      }



      static int subArraySum(int arr[], int sum)
    {
        int currSum;
        int i;
        int j;
        int N=arr.length;
        //i is start point and j - 1 is end point
        for (i = 0; i < N; i++)
        {
            currSum = arr[i];
            for (j = i+1; j <=N; j++)
            {
                if (currSum == sum)
                {
                    System.out.println("Subarray with given sum is between indexes " + i + " and " + (j-1)); 
                    return 1;
                }
                else if (currSum > sum)
                {
                    break;
                }
               currSum = currSum + arr[j];
            }
        }
        System.out.println("No subarray found with given sum");
        return 0;
    }


    static void subArrayUsingHash(int[] arr, int target){

        

    }

    static void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+ "");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("\nNumber of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("\nEnter the elements to be stored in array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }


        System.out.println("\n The array is");
        printArray(arr);


        System.out.println("\nEnter the target to be found");
        
        int target=sc.nextInt();

        System.out.println("\nAfter finding the subarray sum");
        subArraySum(arr, target);
    }
    
}
