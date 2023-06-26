package Arrays;
import java.util.*;

public class RotateArray {

    public void rotateArray(int[] nums, int k) {
	
        for(int i=0;i<k;i++){
            int last=nums[nums.length-1];//stores last element of array
                for(int j=nums.length-1;j>0;j--){
                    nums[j]=nums[j-1];//shift element of array one by one
                }
            nums[0]=last;
            }//last element will become first element of array
    }


    static void rotateArr(int arr[], int d, int n)
    {
        
        if(d>n){
            d-=n;
        }
        
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
        // add your code here
    }
    
    static void reverse(int[] arr, int low, int high){
        while(low < high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
    

    
    

    public void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+ " ");

        }
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        int sum=0;
        int i=0,j=0; // Set two pointers i,j to the 1st position
        while(j<n){ 
            sum+=arr[j]; // Increment sum till sum>s to find the pos of j
            while(sum>s){ // Increment i till sum<=s
                sum-=arr[i];
                i++;
            }
            if(sum==s){ // Subarray found
                if(i>j) break;
                list.add(i+1);
                list.add(j+1);
                break;
            }
            j++;
        }
        if(list.isEmpty()) list.add(-1); // No subarray found
        return list;
    }

    public static void main(String[] args){

        RotateArray rotate =new RotateArray();

        int[] arr={3,6,9,12,15};
        

        rotate.printArray(arr);

        rotate.rotateArray(arr, 3);

        System.out.println("\nAfter Rotating");

        rotate.printArray(arr);



        



    }
    
}
