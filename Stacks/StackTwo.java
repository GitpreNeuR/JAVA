package Stacks;

//IMPLEMENTATION OF STACK USING LINKED LISTS


public class StackTwo {

    class Node{
        Node next;
        int data;

        Node(int d){

            data=d;

        }
    }

    Node head;
    int size;

    StackTwo(){

        head=null;
        size=0;

    }

    public void push(int data){
        Node new_node=new Node(data);

        new_node.next=head;
        size++;
        head=new_node;
    }

    public Boolean isEmpty(){
        return head==null;
    }

    public int peek(){
        if(head==null){
            return 0;
        }

        return head.data;
    }

    public int pop(){
        if(head==null){
            return 0;
        }
        head=head.next;
        size--;
        return head.data;
    }

    public int size(){
        return size;
    }

    public void display(){

        Node curr=head;
        while(curr!=null){
        System.out.println(curr.data + "");
        curr=curr.next;
        }

    }

    public static void main(String[] args){
        StackTwo stack=new StackTwo();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println("\nThe stack created using linked list is");
        stack.display();

        System.out.println("\nThe size of the stack is :" +stack.size());
        System.out.println("\nThe peek element of stack is :" +stack.peek());
        
    }
    
}
