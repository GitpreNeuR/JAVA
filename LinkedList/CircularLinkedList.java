package LinkedList;

public class CircularLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }

    static Node head = null;
    static Node tail = null;

    static Node addToEmpty(Node last, int data) {
        if (last == null) {
            return last;
        }

        Node newNode = new Node(data);
        newNode.data = data;
        last = newNode;
        newNode.next = last;
        return last;

    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void insertAtLast(int data) {
        // Create new node
        Node newNode = new Node(data);
        // Checks if the list is empty.
        if (head == null) {
            // If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // tail will point to new node.
            tail.next = newNode;
            // New node will become new tail.
            tail = newNode;
            // Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        } else {
            if (head != tail) {
                head = head.next;
                tail.next = head;
            }
            // If the list contains only one element
            // then it will remove it and both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }

    public void deleteLast(){
        if(head == null){
            return;
        }
        else{
            if(head!=tail){
                Node curr=head;
                //Loop will iterate till the second last element as current.next is pointing to tail
                while(curr.next!=tail){
                    curr=curr.next;
                }

                //second last element will be new tail
                tail=curr;
                //tail will point to head 
                tail.next=head;
            }

            else{
                //If the list contains only one element   
      //Then it will remove it and both head and tail will point to null
                head=tail=null;
            }
        }
    }

    public int size() {
        int size = 0;
        if (head != null) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
                size++;
            }
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes of the circular linked list: ");
            do {
                // Prints each node by incrementing pointer.
                System.out.print(" " + current.data);
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.insert(10);
        cl.insert(20);
        
        cl.insert(30);
        cl.insert(40);
        cl.insert(50);
        

        cl.display();

        System.out.println("The size of the list is " + cl.size());

        cl.deleteFirst();
        cl.deleteLast();

        System.out.println("After deleting first and last");
        cl.display();

        System.out.println("The size of the list is " + cl.size());


    }

}
