public class Practice {
    
    void run(){
        System.out.println("A class");
    }
}
    class B extends Practice {
        @Override
        void run(){
            System.out.println("B class");
        }
        
        public static void main(String[] args){
            Practice obj=new B();
            Practice obj2=new Practice();
            obj.run();
            obj2.run();
        }
    }

