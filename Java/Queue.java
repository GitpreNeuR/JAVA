public class Queue {

    int front;
    int rear;
    int capacity=1000;
    int[] arr=new int[capacity];

    Queue(){
        front=rear=0;
      
        
    }

    public void enqueue(int data){
        if(capacity == rear && front == 1){
            System.out.println("Queue is Full");
        }

        else if(front == 0){
            front=1;
            rear=1;
        }
        else{
            rear++;
        arr[rear]=data;
        
        }

    }

    public void dequeue(){

        // if queue is empty
		if (front == 0) {
			System.out.println("\nQueue is empty\n");
			
		}

        else if(front == rear){
            System.out.println("\nQueue contains one element\n");
            front=0;
            rear=0;
        }
        else{
            front++;
        }



        //

    }
    // print queue elements
	public void queueDisplay()
	{
		int i;
		if (front == 1) {
			System.out.println("\nQueue is Empty\n");
			return;
		}

		// traverse front to rear and print elements
		for (i = front; i <= rear; i++) {
			System.out.println(arr[i] + "");
		} 
		
	}

    // print front of queue
	public void queueFront()
	{
		if (front == rear) {
			System.out.println("\nQueue is Empty\n");
			return;
		}
		System.out.println("\nFront Element is:" +front);
        System.out.println("\nRear element is:"+rear);
		
	}
    
    public static void main(String[] args){
        Queue q1=new Queue();
        q1.enqueue(20);
        q1.queueFront();
        q1.enqueue(30);
        q1.queueFront();
        q1.enqueue(40);
        q1.queueFront();
        q1.enqueue(50);
        q1.queueFront();
        q1.enqueue(60);
        q1.queueFront();
        q1.enqueue(70);
        q1.queueFront();

        System.out.println("After dequeue");
        q1.dequeue();
        q1.queueFront();
        q1.dequeue();
        q1.queueFront();
        q1.dequeue();
        q1.queueFront();

        


        
        
        

    }
    
}

//in final keyword, variable will not change, class will not be inherited and method will not be overrided
//in finally, block will execute in exception handling
//in finalize, means method cleanup
