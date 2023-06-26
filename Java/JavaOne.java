


public class JavaOne{

   int roll;
   int marks;
    

    JavaOne(int roll,int marks){
        this.roll=roll;
        this.marks=marks;
    }

    static void add(int a){

        System.out.println(a);

    }

    void add(int a, int b){
        System.out.println(a+b);
    }

    static int factorial(int n){
        if(n==0 || n==1){
            return 1;

        }
        return n * factorial(n-1); 
    }

    static void checkNumber(int n){
        int i=0;
        int temp=n;

        while(n!=0){
            int j=1;
            int rem=n%10;
            j=factorial(rem);
            i+=j;
            n=n/10;
        }
        if(temp == i){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }



    }
    public static void main(String[] args){
        JavaOne student=new JavaOne(45,55);
        student.add(20,30);
        student.add(20);

        
       //  int rows = sc.nextInt();
         
         
       /*  for (int i = 1; i <= rows; i++) 
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print("* ");
            }
             
            System.out.println();
        }*/

       /*  for(int i=1;i<=rows;i++){
            for(int j=(rows-i);j>=0;j--){
                System.out.print("");

                
            }
            for(int k=1;k<=i;k++){
                System.out.print(k+" ");
            }
            System.out.println();
        }*/
         
        
    
        
    }
}