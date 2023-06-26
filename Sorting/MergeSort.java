package Sorting;

import java.util.*;

public class MergeSort {

    void mergeSort (int[] arr) {
		// add your logic here
		int n=arr.length;
		merge(arr,0,n-1);
	}
	
	void merge(int[] arr, int start, int end){
		
		int mid=(start+end)/2;
		
		if(start >= end){
			return;
		}
		
		merge(arr, start, mid);
		merge(arr,mid+1,end);
		
		mergeHelper(arr,start,end);
		
		
		
		
	}
	
	void mergeHelper(int[] arr, int start, int end){
		int mid=(start+end)/2;
		int n1=mid-start+1;//length of 1st half
		int n2=end-mid;//length of 2nd half
		
		//creating 2 arrays of length n1 and n2,or simply, breaking the array in two parts 
		int[] left=new int[n1];
		int[] right=new int[n2];
		
		//k is the maximum array index
		int k=start;//copy the values
		
		for(int i=0;i<n1;i++){
			left[i]=arr[k++];
		}
		
		k=mid+1;
		
		for(int i=0;i<n2;i++){
			right[i]=arr[k++];
		}
		
		//merge both arrays
		int index1=0;
		int index2=0;
		k=start;
		
		while(index1 < n1 && index2  < n2){
			if(left[index1] < right[index2]){
				arr[k++]=left[index1++];
			}
			else{
				arr[k++]=right[index2++];
			}
		}
		
		while(index1 < n1){
			arr[k++]=left[index1++];
		}
		
		while(index2 < n2){
			arr[k++]=right[index2++];
		}		
		
		
	}
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MergeSort sort = new MergeSort();

        System.out.println("\nNumber of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        

        System.out.println("\nEnter the elements to be stored in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nThe original array is");
        sort.printArray(arr);

        
        sort.mergeSort(arr);
        System.out.println("\nArray after applying merge sort is");
        sort.printArray(arr);
    }

}
