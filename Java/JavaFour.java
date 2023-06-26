// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class JavaFour {
    
    static void function(int a){
         if(a<=0){
             return;
         }
         function(--a);
         System.out.print(a+" ");
         System.out.println();
         function(--a);
     }
     public static void main(String[] args) {
         function(4);
     }
 }