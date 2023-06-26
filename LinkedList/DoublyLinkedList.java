package LinkedList;

public class DoublyLinkedList {

    static Node head;

    class Node {

        Node next;
        Node prev;
        int data;

        Node(int d) {
            data = d;
        }

    }

    public void push(int data) {
        Node new_node = new Node(data);

        new_node.next = head;
        new_node.prev = null;

        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
    }

    public void insertAfter(Node prev_node, int data) {
        if (prev_node == null) {
            System.out.println("Previous node cannot be empty");
            return;
        }

        Node new_node = new Node(data);

        new_node.next = prev_node.next;
        prev_node.next = new_node;

        if (new_node.next != null) {
            new_node.next.prev = new_node;
        }
    }

    public void append(int data) {
        Node new_node = new Node(data);

        Node last = head;

        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            new_node = head;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
        new_node.prev = last;
    }

    public void printListForward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null) {
            System.out.println(curr.data + " ");
            curr = curr.next;
        }

    }

    public void deleteNode(Node temp) {
        if (head == null || temp == null) {
            System.out.println("List is empty");
            return;
        }

        if (temp == head) {
            head = head.next;
        }

        if (temp.prev != null) {
            temp.next.prev = temp.prev;
        }

        if (temp != null) {
            temp.prev.next = temp.next;
        }

        return;
    }

    public int countNodes() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Node reverseList(Node head){

        Node left=head;
        Node right=head;

        while(right.next != null){
            right=right.next;
        }

        while(left!=right && left.prev!=right){
            int temp=left.data;
            left.data=right.data;
            right.data=temp;

            left=left.next;
            right=right.prev;
        }
        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.push(11);
        list.push(12);
        list.push(13);
        list.push(14);
        list.push(15);
        list.push(16);

        list.append(10);

        list.insertAfter(list.head.next, 9);

        System.out.println("\nThe created list is:");
        list.printListForward();

        list.deleteNode(list.head.next.next.next);

        // Node to be deleted is 14
        System.out.println("\nAfter deleting a node ");
        list.printListForward();

        System.out.println("\nNumber of nodes in list are:  " + list.countNodes());

        list.reverseList(head);
        System.out.println("\nAfter reversing the list");
        list.printListForward();

    }

}
