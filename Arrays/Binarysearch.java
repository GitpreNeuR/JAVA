package Arrays;
import java.util.*;
public class Binarysearch {

    static int binarySearch(int[] arr,int key){

        int start=0;
        int end=arr.length-1;
        int mid=(start+end)/2;

        while(start<=end){
            if(arr[mid] == key){
                return mid;
            }

            else if(arr[mid]> key){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

            mid=(start+end)/2;
        }

        return -1;

    }
    public int[] searchRange(int[] nums, int target) {
        int[] temp = {-1,-1};
        int start = 0;
        int end = nums.length-1;
        
        
       
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){ 
               temp[0] = mid;
               end = mid-1;
            }
            else if(target<nums[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
      
        start = 0;
        end = nums.length-1;
        
        
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){ 
               temp[1] = mid;
               start = mid+1;
            }
            else if(target<nums[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
        return temp;
            
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


        System.out.println("\nThe original array is");
        printArray(arr);

        System.out.println("\nEnter th key:");
        int key=sc.nextInt();

        System.out.println("\n Binary search is :" +binarySearch(arr, key));

    }
    
}
