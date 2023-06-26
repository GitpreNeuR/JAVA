


public class JavaThree{

    


        
    static void occurence(int[] arr){

        //keep track of the unique elements that have been printed.
        int[] printed = new int[arr.length];

        //length of count
        //keep track of the number of elements that have been printed
        int countPrinted = 0;

        // loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            // count the number of occurrences of the current element
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // if the element occurs less than three times and has not been printed before, print it and its count
            if (count < 3 && !contains(printed, arr[i])) {
                System.out.println(arr[i] + " occurs " + count + " times");
                printed[countPrinted] = arr[i];
                countPrinted++;
            }
        }
    }

    //method to check if element has been printed before
    static boolean contains(int[] arr,  int element) {
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] main){

        int[] arr={20,20,30,30,30,11,11,11,22,33,44,33,44,33,44};
        occurence(arr);


    }
}