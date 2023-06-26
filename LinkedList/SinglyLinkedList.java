
package LinkedList;

import java.util.*;

public class SinglyLinkedList {

    static Node head; // head of list
    static Node tail;// tail of list

    static Node child; // child of list

    /* Linked list Node */
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the l1. */
    public void push(int new_data) {

        Node new_node = new Node(new_data);

        /* Make next of new Node as head */
        new_node.next = head;

        /* Move the head to point to new Node */
        head = new_node;
    }
    // insert after a node

    public void insertAfter(Node prev_node, int new_data) {

        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node new_node = new Node(new_data);

        /* Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

        /* make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    // Insert at the end of the list
    public void append(int new_data) {

        Node new_node = new Node(new_data);

        /*
         * If the Linked List is empty, then make the
         * new node as head
         */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;

        while (last.next != null)
            last = last.next;

        last.next = new_node;

        

    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public void deleteAtStart() {

        /*
         * To delete the first node (head node), copy the head node in a temporary node.
         * Make the second node as the head node.
         * Now, delete the temporary node.
         */

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        head = head.next;
        temp = null;

    }

    public void deleteNode(int key) {
        Node temp = head;
        Node prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {

            head = temp.next;
            return;

        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }

    public Node deleteNode(Node head, int x) {
        // Your code here
        if (x == 1) {
            return head.next;
        }

        Node temp = head;
        for (int i = 2; i < x; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public Node removekthElement(Node head, int k) {

        int index = 0;
        Node currentNode = head;
        if (k == 1) {
            return head.next;
        }
        while (currentNode != null) {
            index++;
            if (index == k - 1) {
                break;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return head;
    }

    public Node removeNthNodeFromEnd(Node head, int n) {
        // add your logic here

        if (head == null && head.next == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    Node removeDuplicates(Node head) {
        Node temp = head;
        if (head == null) {
            return null;
        }
        while (temp.next != null && temp != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;

    }

    public void removeAllDuplicates() {

        // Create a dummy node that acts like a fake
        // head of list pointing to the original head
        Node dummy = new Node(0);

        // Dummy node points to the original head
        dummy.next = head;
        Node prev = dummy;
        Node current = head;

        while (current != null) {
            // Until the current and previous values
            // are same, keep updating current
            while (current.next != null &&
                    prev.next.data == current.next.data)
                current = current.next;

            // If current has unique value i.e current
            // is not updated, Move the prev pointer
            // to next node
            if (prev.next == current)
                prev = prev.next;

            // When current is updated to the last
            // duplicate value of that segment, make
            // prev the next of current*/
            else
                prev.next = current.next;

            current = current.next;
        }

        // Update original head to the next of dummy
        // node
        head = dummy.next;
    }

    public void deleteNodeTwo(Node node) {

        node.data = node.next.data;
        node.next = node.next.next;

    }

    public void deleteAtEnd() {

        if (head == null) {
            return;

        }

        Node temp = head;
        Node prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;

    }

    public void printMiddle() {
        if (head != null) {
            int length = getLength();
            Node temp = head;
            int middleLength = length / 2;
            while (middleLength != 0) {
                temp = temp.next;
                middleLength--;
            }
            System.out.print("\nThe middle element is [" + temp.data + "]");
            System.out.println();
        }
    }

    public boolean search(int x) {
        Node current = head; // Initialize current
        while (current != null) {
            if (current.data == x)
                return true; // data found
            current = current.next;
        }
        return false;

    }

    public void rotateInRight(int k) {
        if (k == 0) {
            return;
        }

        Node current = head;// last node
        int count = 1;// for length of list

        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return;
        }

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;

        head = kthNode.next;

        kthNode.next = null;

    }

    public boolean isPalindrome(Node head) {
        // Your code here
        if (head == null || head.next == null)
            return true;

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow is the middle element
        slow.next = reverse(slow.next);
        slow = slow.next;

        // compare
        while (slow != null) {
            if (head.data != slow.data)
                return false;

            // move to the next node
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }

    Node reverseTwo(Node head) {
        if (head.next == null)
            return head;
        Node last = reverseTwo(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    void printLinkedListReverse(Node head) {
        // add your logic here
        if (head.next != null) {
            printLinkedListReverse(head.next);
        }
        System.out.print(head.data + " ");
        return;
    }

    public boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;

        }
        return false;
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

    public int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void swapNodes(int n1, int n2) {
        Node prevNode1 = null, prevNode2 = null,
                node1 = head, node2 = head;

        // Checks if list is empty
        if (head == null) {
            return;
        }

        // If n1 and n2 are equal, then
        // list will remain the same
        if (n1 == n2)
            return;

        // Search for node1
        while (node1 != null && node1.data != n1) {
            prevNode1 = node1;
            node1 = node1.next;
        }

        // Search for node2
        while (node2 != null && node2.data != n2) {
            prevNode2 = node2;
            node2 = node2.next;
        }

        if (node1 != null && node2 != null) {

            // If previous node to node1 is not null then,
            // it will point to node2
            if (prevNode1 != null)
                prevNode1.next = node2;
            else
                head = node2;

            // If previous node to node2 is not null then,
            // it will point to node1
            if (prevNode2 != null)
                prevNode2.next = node1;
            else
                head = node1;

            // Swaps the next nodes of node1 and node2
            Node temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
        } else {
            System.out.println("Swapping is not possible");
        }
    }

    public void sortList() {
        // Node current will point to head
        Node current = head, index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // recursive sort to sort both the halves
        left = mergeSort(left);
        right = mergeSort(right);

        // merge both the halves
        Node result = mergeHelper(left, right);

        return result;
    }

    static Node findMid(Node head) {

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;

    }

    static Node mergeHelper(Node left, Node right) {
        Node result = null;
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.data <= right.data) {
            result = left;
            result.next = mergeHelper(left.next, right);
        } else {
            result = right;
            result.next = mergeHelper(left, right.next);
        }

        return result;
    }

    Node mergeTwoSortedList(Node firstList, Node secondList) {
        if (firstList == null) {
            return secondList;
        }

        if (secondList == null) {
            return firstList;
        }

        Node ans = null;

        if (firstList.data < secondList.data) {
            ans = firstList;
            firstList.next = mergeTwoSortedList(firstList.next, secondList);
        }

        else {
            ans = secondList;
            secondList.next = mergeTwoSortedList(secondList.next, firstList);
        }
        return ans;

    }

    public Node intersectionPoint(Node headA, Node headB) {

        Node a = headA;
        Node b = headB;

        while (a != b) {
            if (a == null)
                a = headB;
            else
                a = a.next;

            if (b == null)
                b = headA;
            else
                b = b.next;
        }

        return a;

    }

    public static void removeLoop(Node head) {
        // code here
        // remove the loop without losing any nodes
        if (head == null || head.next == null) {
            return;
        }

        Node temp = null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;

                if (fast == slow) {
                    slow = head;

                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }

                    temp = slow;
                    while (temp.next != slow) {
                        temp = temp.next;
                    }
                    temp.next = null;
                }
            }
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList l1 = new SinglyLinkedList();
        SinglyLinkedList l2 = new SinglyLinkedList();

        l1.append(5);
        l1.push(11);

        l1.push(13);
        l1.append(15);

        l1.insertAfter(l1.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        l1.printList();

        l1.deleteAtStart();
        System.out.println("\nList after deletion at beginning is : ");
        l1.printList();

        l1.deleteNode(8);
        System.out.println("\nList after deletion of the node");
        l1.printList();

        l1.deleteAtEnd();
        System.out.println("\nList after deletion of the node at the end of the list");
        l1.printList();

        System.out.println("\nNumber of nodes in list are : " + l1.countNodes());

        l1.push(21);
        l1.push(22);

        l1.append(26);
        System.out.println("\nAdding some elements to list");
        l1.printList();

        System.out.println("\nNumber of nodes in list are : " + l1.countNodes());

        if (l1.search(29)) {
            System.out.println("Present in the list");
        } else {
            System.out.println("Not in the list");
        }

        System.out.println("\nOriginal list is");
        l1.printList();

        head = l1.reverse(head);
        System.out.println("\nAfter reversing the list");
        l1.printList();

        System.out.println("\nIs there a loop in the list??");
        if (l1.detectLoop(head)) {
            System.out.println("\nLOOP FOUND IN THE LIST");
        } else {
            System.out.println("\nLOOP NOT FOUND IN THE LIST");
        }

        l1.printList();

        l1.rotateInRight(3);
        System.out.println("\nAfter rotating list by 3");
        l1.printList();

        l1.deleteNodeTwo(l1.head.next.next);
        System.out.println("\nAfter deleting node with method two");
        l1.printList();

        l1.swapNodes(21, 5);
        System.out.println("\nAfter swapping nodes");
        l1.printList();

        l1.mergeSort(l1.head);
        System.out.println("\nAfter sorting nodes");
        l1.printList();

    }

}
