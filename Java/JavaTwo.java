
public class JavaTwo {

   static void bubbleSort(int[] arr){
      int n=arr.length;
      for(int i=0;i<n-1;i++){
         for(int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
               swapping(arr, j, j+1);
            }
         }
      }
      printArray(arr);
   }
   
    
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            
        }
    }
    
   static void swapping(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
    }
    
   static void reArrange(int[] arr){
       
      int n=arr.length;
        
    for(int i=0 ;i<n; i++){
      if(arr[i] >= 0 && i % 2 == 1){
         for(int j = i + 1; j <n; j++){
            if(arr[j] < 0 && j % 2 == 0){
               swapping(arr, i, j);
               break ;
            }
         }
      }
      else if(arr[i] < 0 && i % 2 == 0){
         for(int j = i + 1; j <n; j++){
            if(arr[j] >= 0 && j % 2 == 1){
               swapping(arr,i, j);
               break;
            }
         }
      }
   }
   printArray(arr);
        
}
    public static void main(String[] args) {
       int[] arr={22,18,5,12,34,55};
       bubbleSort(arr);
       
       
       
    }
}