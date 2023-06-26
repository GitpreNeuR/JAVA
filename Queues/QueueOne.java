package Queues;
import java.util.*;

//IMPLEMENTING QUEUES USING 2 STACKS
public class QueueOne {

    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();


    public void enqueue(int x){
        //moving all elements from s1 to s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
            //s1.pop();
        }

       //push item to s1
       s1.push(x);

       //push everything back to s2
       while(!s2.isEmpty()){
        s1.push(s2.pop());
       }
    }

    public int dequeue(){
        //if the first stack is empty
        if(s1.isEmpty()){
            System.out.println("Queue is empty");
            System.exit(0);
        }

        //return top of s1 
        int x=s1.peek();
        s1.pop();
        return x;
    }

    public static void main(String[] args){
        QueueOne q=new QueueOne();
        q.enqueue(3);
        q.enqueue(6);
        q.enqueue(9);
        q.enqueue(12);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
    
}
