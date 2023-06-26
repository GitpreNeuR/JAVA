package Arrays;
import java.util.*;

public class MergeTwoArrays {

    static void mergeTwoSortedArraysSpaceOne(int[] arr1, int[] arr2 ){
        int m=arr1.length;
        int n=arr2.length;
        int i = 0, j = 0, k = m - 1;
        while (i <= k && j < n) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    static void mergeTwoSortedArrays(int[] arr1, int[] arr2){
        int m=arr1.length;
        int n=arr2.length;

        for (int i = 0; i < n; i++) {
            arr1[i + m] = arr2[i];
        }
        Arrays.sort(arr1);
    }

    static int removeOccurences(int[] A, int k) {
		// add your logic here
		int n = A.length;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] != k) {
				A[j++] = A[i];
			}
		}
		return j;
	}

    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+ " ");

        }
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0,sum=0;
        map.put(0,1);
        for(int i:nums){
            sum+=i;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    static int maxKSubarraySum (int[] A, int k) {
		int n = A.length;
		int maximum = 0;
		int sum = 0;
		for(int i = 0; i < k; i++) {
			sum += A[i];
		}
		maximum = Math.max(sum, maximum);
		for(int i = k; i < n; i++) {
			sum -= A[i - k];
			sum += A[i];
			maximum = Math.max(sum, maximum);
		}
		return maximum;
	}

    static int removeDuplicates(int[] arr){
        int index=0;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[index]){
                index++;
                arr[index+1]=arr[i];
                
            }
        }
        return index+1;
    }

    public static void main(String[] args){
        int[] arr1={9, 12, 11, 5, 8, 8};
        int[] arr2={13, 10,15, 17, 14};

        int n=arr1.length;

        removeDuplicates(arr1);
        
        



        



    }
    
}
