package Heap;

public class BinaryHeap {
    static int[] Heap;
    static int size;
    static final int MAX_SIZE = 20;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity
    public BinaryHeap() {

        size = 0;
        Heap = new int[MAX_SIZE];
    }

    private static final int FRONT = 1;


    // Initializing front as static with unity
    // Method 1
    // Returning position of parent
    public int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Method 2
    // Returning left children
    public int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    // Method 3
    // Returning right children
    public int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    // Method 4
    // Returning true of given node is leaf
    public boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Method 5
    // Swapping nodes
    public void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Method 6
    // Recursive function to max maxHeap given subtree
    public void maxHeap(int pos) {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)]
                || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeap(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeap(rightChild(pos));
            }
        }
    }

    public void minHeap(int pos) {
        if (!isLeaf(pos)) {

            // swap with the minimum of the two children
            int swapPos = Heap[leftChild(pos)] < Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);

            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                swap(pos, swapPos);
                minHeap(swapPos);
            }

        }
    }

    // Method 7
    // Inserts a new element to max heap
    public void insertMax(int element) {
        Heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public void insertMin(int element) {

        if (size >= MAX_SIZE) {
            return;
        }
        Heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int deleteInHeap(int n){

        //get the last element of the heap
        int last=Heap[n-1];

        //replace with first element
        Heap[0]=last;

        //decrease size of heap by 1
        n=n-1;

        //heapify root node
        maxHeap(0);

        return n;


    }

    // Method 8
    // To display heap
    public void print() {

        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + Heap[i]);

            if (leftChild(i) < size) // if the child is out of the bound of the array
                System.out.print("\nLeft Child Node: " + Heap[leftChild(i)]);

            if (rightChild(i) < size) // if the right child index must not be out of the index of the array
                System.out.print("\nRight Child Node: " + Heap[rightChild(i)]);

            System.out.println();
            System.out.println("---------------"); // for new line

        }

    }

    // Method 9
    // Remove an element from max heap
    public int extractMax() {
        int popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeap(0);
        return popped;
    }

    public int extractMin(){

        int popped=Heap[FRONT];
        Heap[FRONT]=Heap[size--];

        minHeap(FRONT);

        return popped;

    }

    // Method 10
    // main dri er method
    public static void main(String[] arg) {
        // Display message for better readability
        

        BinaryHeap maxHeap = new BinaryHeap();

        // Inserting nodes
        // Custom inputs
        maxHeap.insertMax(5);
        maxHeap.insertMax(3);
        maxHeap.insertMax(17);
        maxHeap.insertMax(10);
        maxHeap.insertMax(55);
        maxHeap.insertMax(19);
        maxHeap.insertMax(6);
        maxHeap.insertMax(22);
        maxHeap.insertMax(9);

        // Calling maxHeap() as defined above
        System.out.println("\nMAX HEAP IS");
        maxHeap.print();

        // Print and display the maximum value in maxHeap
        System.out.println("The max val is "
                + maxHeap.extractMax());

        System.out.println("------------------");

                
        BinaryHeap minHeap=new BinaryHeap();
        minHeap.insertMin(5);
        minHeap.insertMin(3);
        minHeap.insertMin(17);
        minHeap.insertMin(10);
        minHeap.insertMin(55);
        minHeap.insertMin(19);
        minHeap.insertMin(6);
        minHeap.insertMin(22);
        minHeap.insertMin(9);


        System.out.println("\nMIN HEAP IS");
        minHeap.print();

        System.out.println("\nMinimum value is: " +minHeap.extractMin());

        
    }
}
