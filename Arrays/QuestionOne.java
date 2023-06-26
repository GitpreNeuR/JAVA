package Arrays;
import java.util.*;

public class QuestionOne {


    



    

   static int secondLargestSmallestSum(int[] arr){


        Arrays.sort(arr);
        ArrayList<Integer> even=new ArrayList<>();
        ArrayList<Integer> odd=new ArrayList<>();

        int n=arr.length;
        
        int sum=0;
        for(int i=0;i<n;i+=2){
            even.add(arr[i]);

            for(int j=i+1;j<n;j+=2){
                odd.add(arr[j]);

                sum=even.get(arr[n-1]) + odd.get(arr[2]);
            }
        }

        return sum;

    }

    static void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+ "");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);


        System.out.println("\nNumber of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("\nEnter the elements to be stored in array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        printArray(arr);

        System.out.println("\nThe sum of secong largest and smallest element is:" +secondLargestSmallestSum(arr));
    }
}
