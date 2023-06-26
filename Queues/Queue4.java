package Queues;
import java.util.*;

//IMPLEMENTING QUEUE USING LINKED LISTS
public class Queue4 {

    class ListNode {
        int data;
        ListNode next;
        
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    
    
    class Queue {
        ListNode front, rear;
        int size=0;
        Queue (int capacity) {
            size=0;
            front=rear=null;
        }
    
        boolean isEmpty() {
            return rear==null;
        }
        
        int size() {
            if(front == null || rear == null){
                return 0;
            }
            return size;
        }
        
        int front() {
            if(front == null){
                return -1;
            }
            
            return front.data;
        }
        
        int back() {
            if(rear == null){
                return -1;
            }
            
            return rear.data;
    
        }
        
        void push(int element) {
                ListNode node=new ListNode(element);
                if(front == null){//if queue is empty
                    front=node;
                    rear=node;
                    size++;
                    return;
                }
            
            rear.next=node;
            rear=node;
            size++;
        }
        
        void pop() {
            if(front == null){
                return;
            }
            ListNode delete=front;
            front=front.next;
            if(front == null){
                rear=null;
            }
            
            size--;
        }
    }
    
}
