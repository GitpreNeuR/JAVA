package Stacks;



//implementations for stack using arrays

public class StackOne {

    int capacity = 1000;// capacity of stackm
    int[] arr = new int[capacity];
    int top;// toppest element in the stack

    StackOne() {

        top = -1;
    }

    public Boolean isEmpty() {
        return (top < 0);
    }

    public int size() {
        return top + 1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("\nStack is full");
            System.exit(1);
        }
        arr[++top] = data;
        System.out.println(+data + " pushed in the stack");

    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("\nStack is empty");
            System.exit(1);
        }

        return arr[top--];
    }

    public int peek() {
        if (top < 0) {
            return 0;
        }

        return arr[top];
    }

    

    public void printStack() {
        for (int i = 0; i <= top; i++) {

            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        StackOne stack = new StackOne();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println("\nThe created stack is");
        stack.printStack();

        System.out.println("\nThe top element in the stack is:" + stack.peek());

        stack.pop();

        System.out.println("\nAfter popping the element,  the stack is");
        stack.printStack();

        if (stack.isFull()) {
            System.out.println("\nThe stack is full");
        } else {
            System.out.println("\nThe stack is empty");
        }

        System.out.println("\nThe size of the stack is : " + stack.size());

    }

}
