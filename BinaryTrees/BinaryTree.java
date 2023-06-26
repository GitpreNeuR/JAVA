import java.util.*;
import java.util.LinkedList;

// Node constructors

public class BinaryTree {
    static int max_level = 0;
    Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    /*
     * First, visit all the nodes in the left subtree
     * Then the root node
     * Visit all the nodes in the right subtree
     */

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(" " + node.data);
            inorder(node.right);
        }

    }

    /*
     * Visit root node
     * Visit all the nodes in the left subtree
     * Visit all the nodes in the right subtree
     */
    public void preorder(Node node) {
        if (node != null) {
            System.out.println(" " + node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    /*
     * Visit all the nodes in the left subtree
     * Visit all the nodes in the right subtree
     * Visit the root node
     */
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(" " + node.data);
        }
    }

    public void levelOrderTwo(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        // to store the current node
        Node current;

        while (!q.isEmpty()) {

            // removes first element of the queue
            current = q.poll();
            System.out.println(current.data + " ");

            if (root.left != null) {
                q.add(root.left);
            }

            if (root.right != null) {
                q.add(root.right);
            }
        }
    }

    // check if tree is full or empty:PERFECT BINARY TREE
    boolean isFullTree(Node node) {
        if (node == null)
            return true;

        if (node.right == null && node.left == null)
            return true;

        if (node.right != null && node.left != null)
            return (isFullTree(node.left) && isFullTree(node.right));

        return false;
    }

    // Complete BINARY TREE
    // 1. COUNT NODES.
    public int count(Node node) {
        if (node == null) {
            return 0;
        }
        return (1 + count(node.left) + count(node.right));
    }

    public boolean completeTree(Node node, int index, int num) {
        if (node == null)
            return true;
        if (index >= num) {
            return false;
        }
        return (completeTree(node.left, 2 * index + 1, num) && completeTree(node.right, 2 * index + 2, num));

    }

    // LEVEL ORDER TRAVERSAL
    public static boolean printLevel(Node node, int level) {
        if (node == null) {
            return false;
        }
        if (level == 1) {
            System.out.println(node.data + " ");
            return true;
        }
        boolean left = printLevel(node.left, level - 1);
        boolean right = printLevel(node.right, level - 1);

        return left || right;

        // CHECK IF TREE IS BALANCED
    }

    // LEVEL ORDER TAKES THE METHOD PRINTLEVEL()
    public void levelorder(Node node) {
        int level = 1;

        while (printLevel(node, level)) {
            level++;
        }
    }

    public List<Integer> getLevelOrderTraversal(Node root) {
    	Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<Integer> traversal = new ArrayList<>();
		while(!queue.isEmpty()) {
			Node currentElement = queue.poll();
			traversal.add(currentElement.data);
			if(currentElement.left != null) {
				queue.add(currentElement.left);
			}
			if(currentElement.right != null) {
				queue.add(currentElement.right);
			}
		}	
		return traversal;
	}

    public boolean isBalanced(Node node) {
        //A binary tree is considered balanced if the difference between the heights of the left and the right subtree is not more than 1 for any given node.
        int l;
        int r;
        if (node == null) {
            return true;
        }
        l = height(node.left);
        r = height(node.right);
        /*
         * Math. abs() function returns the absolute dataue of a number.
         * That is, it returns x if x is positive or zero, and the negation of x if x is
         * negative
         */
        if (Math.abs(l - r) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        return false;

    }

    // HEIGHT OF THE TREE
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // MINIMUM DEPTH OF THE TREE
    public int minDepth(Node root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minDepth(root.right) + 1;

        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left),
                minDepth(root.right)) + 1;

    }

    

    public int depth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth > rightDepth) {
            return (leftDepth + 1);
        } else {
            return (rightDepth + 1);
        }

    }

    public void deleteTree(Node root) {

        root = null;
        System.out.println("Tree successfully deleted");

    }

    //sum of nodes from longest path to leaf node
    public int sumOfLongRootToLeafPath(Node root){

        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int length=0;
        int maxLength=0;

        sumOfLongRootToLeafPathHelper(root,sum,maxSum,length,maxLength);

        return maxSum;



    }

    public void sumOfLongRootToLeafPathHelper(Node root, int sum, int maxSum, int length, int maxLength){

        //base case
         if(root == null){
            
            if(length > maxLength){
                maxLength = length;
                maxSum = sum;
            }

            else if(length == maxLength){
                maxSum=Math.max(sum, maxSum);
            }

            return;

         }
         sum+=root.data;

         sumOfLongRootToLeafPathHelper(root.left, sum, maxSum, length+1, maxLength);
         sumOfLongRootToLeafPathHelper(root.right, sum, maxSum, length+1, maxLength);


    }

    


    // LEFT VIEW OF THE TREE
    public void printLeftViewHelper(Node root, int level) {
        if (root == null) {
            return;
        }
        // If this is the first node of its level
        if (max_level < level) {
            System.out.println(" " + root.data);
            max_level = level;
        }
        // recursion for left and right subtrees
        printLeftViewHelper(root.left, level + 1);
        printLeftViewHelper(root.right, level + 1);

    }

    public void printLeftView() {
        max_level = 0;
        printLeftViewHelper(root, 1);
    }

    // RIGHT VIEW OF THE TREE

    public void printRightViewHelper(Node root, int level) {
        if (root == null) {
            return;
        }
        // If this is the first node of its level
        if (max_level < level) {
            System.out.println(" " + root.data);
            max_level = level;
        }
        // recursion for left and right subtrees
        printLeftViewHelper(root.right, level + 1);
        printLeftViewHelper(root.left, level + 1);

    }

    public void printRightView() {
        max_level = 0;
        printRightViewHelper(root, 1);
    }

    // PRINT LEFT VIEW USING QUEUE
    public void leftViewUsingQueue(Node root) {

        // BASE CASE
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            // LEVEL ORDER TRAVERSAL
            // Number of nodes at current level
            int n = q.size();

            // traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = q.poll();

                // print the leftmost element at the level
                if (i == 1) {
                    System.out.println(temp.data + " ");
                }

                // adding left node
                if (temp.left != null) {
                    q.add(temp.left);
                }

                // adding right node
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

    }

    // to check if the roots of both trees are identical or not
    public boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        /*
         * Check if the data of both roots is same and data of left and right
         * subtrees are also same
         */
        return (root1.data == root2.data &&
                isIdentical(root1.left, root2.left) &&
                isIdentical(root1.right, root2.right));
    }


    public int getLeafCount() 
    {
        return getLeafCount(root);
    }
   
    public int getLeafCount(Node node) 
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    // to check if node2 is a subtree of node1
    public boolean isSubtree(Node node1, Node node2) {
        // base cases

        if (node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }

        if (isIdentical(node1, node2)) {
            return true;
        }

        return isSubtree(node1.left, node2) || isSubtree(node1.right, node2);
    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getWidth(Node node, int level) {
        if (node == null) {
            return 0;
        }

        if (level == 1)
            return 1;

        else if (level > 1) {
            return getWidth(node.left, level - 1)
                    + getWidth(node.right, level - 1);
        }
        return 0;
    }

    public int getMaxWidth(Node root)
{
    int maxWidth = 0;
    int width;
    int h = height(root);
    int i;
  
    /* Get width of each level and compare
        the width with maximum width so far */
    for (i = 1; i <= h; i++) {
        width = getWidth(root, i);
        if (width > maxWidth)
            maxWidth = width;
    }
  
    return maxWidth;
}

public int maxWidthOfBinaryTreeTwo(Node root) {
        
        
        
    if (root == null)
           return 0;
       
       int maxWidth = 0;
       Deque<Node> queue = new ArrayDeque<>();
       root.data = 1; // Changing root's index to 1
       queue.offer(root);
       
       while (!queue.isEmpty()) {
           int levelSize = queue.size();
           
           int start = queue.peekFirst().data; // Getting first and last index in deque
           int end = queue.peekLast().data;
           // Calculating maximum width as we check for each level
           maxWidth = Math.max(maxWidth, end - start + 1);
           
           for (int i = 0; i < levelSize; i++) {
               Node node = queue.poll(); // Removing first element
               Integer index = node.data;
               
               if (node.left != null) {
                   node.left.data = index * 2; // Changing left's data
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   node.right.data = index * 2 + 1; // Changing right's data
                   queue.offer(node.right);
               }
               
           }
       }
       
       return maxWidth;
}


    public int getDiameter(Node root){


        if(root == null){
            return 0;
        
        }

        int dLeft=getDiameter(root.left);
        int dRight=getDiameter(root.right);
        int curr=1+ height(root.left) + height(root.right);

        return Math.max(curr, Math.max(dLeft, dRight));
    }

    public static void main(String[] args) {
        BinaryTree tr = new BinaryTree();
        tr.root = new Node(1);
        tr.root.left = new Node(2);
        tr.root.right = new Node(3);
        tr.root.left.left = new Node(4);
        tr.root.left.right = new Node(5);
        tr.root.right.right = new Node(6);
        tr.root.right.left = new Node(7);
        tr.root.right.right.left = new Node(8);

        System.out.println("The Tree in Inorder");
        tr.inorder(tr.root);
        System.out.println("The tree in PreOrder");
        tr.preorder(tr.root);
        System.out.println("The tree in Postorder");
        tr.postorder(tr.root);
        System.out.println("The tree in level order");
        tr.levelorder(tr.root);

        // USING QUEUE

        if (tr.isFullTree(tr.root)) {
            System.out.println("Full");
        } else {
            System.out.println("Empty");
        }

        int nd = tr.count(tr.root);
        int i = 0;

        if (tr.completeTree(tr.root, i, nd)) {
            System.out.println("complete Tree");

        } else {
            System.out.println("Not complete Tree");
        }

        System.out.println("The depth of binary tree is : " + tr.depth(tr.root));

        System.out.println("\nLeft view of the binary tree is");
        tr.leftViewUsingQueue(tr.root);

        System.out.println("\nRight view of the binary tree is");
        tr.printRightView();

        System.out.println("\nNumber of nodes in the binary tree is : " + tr.countNodes(tr.root));

        System.out.println("\nThe maximum width of the binary tree is : " +tr.getDiameter(tr.root));

        System.out.println("\nThe number of leaf nodes in the tree is:" +tr.getLeafCount());

    }
}
