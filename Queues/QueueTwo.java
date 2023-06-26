package Queues;

// Java program to implement a queue using an array
public class QueueTwo {

	static int front;
    static int rear;
    static int capacity;
	static int[] queue;

	QueueTwo(int c)
	{
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}

	// function to insert an element
	// at the rear of the queue
	public  void queueEnqueue(int data)
	{
		// check queue is full or not
		if (capacity == rear) {
			System.out.println("\nQueue is full\n");
			
		}

		// insert element at the rear
		else {
			queue[rear] = data;
			rear++;
		}
		
	}

	// function to delete an element
	// from the front of the queue
	public void queueDequeue()
	{
		// if queue is empty
		if (front == rear) {
			System.out.println("\nQueue is empty\n");
			
		}

		// shift all the elements from index 2 till rear
		// to the right by one
		else {
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}

			// store 0 at rear indicating there's no element
		
			if (rear < capacity)
				queue[rear] = 0;

			// decrement rear
			rear--;
		}
		
	}

	// print queue elements
	public void queueDisplay()
	{
		int i;
		if (front == rear) {
			System.out.println("\nQueue is Empty\n");
			return;
		}

		// traverse front to rear and print elements
		for (i = front; i < rear; i++) {
			System.out.println(queue[i] + "");
		} 
		
	}

	// print front of queue
	public void queueFront()
	{
		if (front == rear) {
			System.out.println("\nQueue is Empty\n");
			return;
		}
		System.out.println("\nFront Element is:" +queue[front]);
		
	}



	public static void main(String[] args)
	{
		// Create a queue of capacity 4
		QueueTwo q = new QueueTwo(1000);

		// print Queue elements
		q.queueDisplay();

		// inserting elements in the queue
		q.queueEnqueue(20);
		q.queueEnqueue(30);
		q.queueEnqueue(40);
		q.queueEnqueue(50);

		// print Queue elements
		q.queueDisplay();

		// insert element in the queue
		q.queueEnqueue(60);
        System.out.println("\nAfter inserting the element 60");

		// print Queue elements
		q.queueDisplay();

		q.queueDequeue();
		q.queueDequeue();
		System.out.println("\nafter two node deletion");

		// print Queue elements
		q.queueDisplay();

		// print front of the queue
		q.queueFront();
	}
}
