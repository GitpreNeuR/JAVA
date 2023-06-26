package Queues;
import java.util.*;

//Array implementation of queues
public class QueueThree   
{  
  /* Member variable declaration */  
  int front,rear,cap,size;
	int[] queue;
	QueueThree (int capacity) {
		cap=capacity;
		queue=new int[capacity];
		front=size=0;
		rear=-1;
	}

	
	
	int size() {
	return size;
	}
	
	int frontElement() {
		if(isEmpty())
			return -1;
		
		return queue[front];
	}
	
	int back() {
		if(isEmpty()){
			return -1;
		}
		
		return queue[rear];
	}
	
	boolean isFull()  {
		
    return cap == size;  
  }    
	
	void push(int element) {
		if(isFull()){
			return;
		}
		queue[++rear]=element;
		
		size++;
	}
	
	public void pop() {
		
		if(front ==-1 || rear==-1){
			return;
		}
		
		else if(front == rear){
			front=rear=-1;
		}
		else{
			front++;
		}
		size--;
		

	}   
  public int peek()  
  {  
    return queue[front];  
  }  

  boolean isEmpty() {
		return size==0;
	}
  
  public static void main(String[] args)   
  {  
    QueueThree queue = new QueueThree(10);  
    queue.push(2);  
    queue.push(3);  
   
    queue.push(5);      
    queue.pop();   
  }  
}  