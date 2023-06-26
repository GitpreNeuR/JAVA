import java.util.*;
import java.io.*;
public class JavaFive{

    static void rearrangeArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr[j] = -1; // mark the element as visited
                }
            }
            if (arr[i] != -1) {
                int freq = count;
                int value = arr[i];
                int k = i - 1;
                while (k >= 0 && freq > getCount(arr,arr[k])) {
                    arr[k + 1] = arr[k];
                    k--;
                }
                arr[k + 1] = value;
            }
        }
        //Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
   

    static int getCount(int[] arr,int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
       // System.out.println(count);
        return count;
    }
    
    
    
    public static void main(String[] args){

        int[] arr={-1,-1,-1,-2,-2,-3};
        
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            int temp=getCount(arr,i);
            System.out.println(temp+" ");
            
        }

    }
}