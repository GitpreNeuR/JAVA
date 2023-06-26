public class BinarySearchTree {

    class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data=d;
            left=right=null;
        }
    }

    Node root;

    BinarySearchTree(){
        root=null;
    }


    BinarySearchTree(int value) { root = new Node(value); }

    public Node insertHelper(Node root, int data){
        if (root == null) {
            root = new Node(data);
            return root;
        }
  
        /* Otherwise, recur down the tree */
        else if (data < root.data)
            root.left = insertHelper(root.left, data);
        else if (data > root.data)
            root.right = insertHelper(root.right, data);
  
        /* return the (unchanged) node pointer */
        return root;
    }

    public void insert(int data){
        root=insertHelper(root, data);
    }

    public Node search(Node root, int key)
{
    // Base Cases: root is null or key is present at root
    if (root==null || root.data==key)
        return root;
 
    // Key is greater than root's key
    if (root.data < key)
       return search(root.right, key);
 
    // Key is smaller than root's key
    return search(root.left, key);
}

    public void inorderHelper(Node node){
        if(node!=null){
            inorderHelper(node.left);
            System.out.println(node.data);
            inorderHelper(node.right);
        }
    }

    public int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null) 
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public Node deleteHelper(Node root, int data){

        //CHECK THE BASE CASE
        if(root == null){
            return root;
        }

        //recursion on both sides of the tree
        if(data < root.data){
            root.left=deleteHelper(root.left, data);
        }

        else if(data > root.data){
            root.right=deleteHelper(root.right, data);
        }

        //if data is equal to the root data, then this is the node to be deleted

       else{ if(root.left == null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }

        //get the inorder successor / smallest in the right subtree

        root.data=minValue(root.right);

        //delete the inorder successor
        root.right=deleteHelper(root.right, root.data);

    }
    return root;
    }

    public void deleteKey(int data) {
        root = deleteHelper(root, data);
      }

      

    void inorder(){
        inorderHelper(root);
    }

    Node removeFromBst(Node root, int key) {
	    if (root == null) {
			return null;
		}
		if (root.data > key) {
			root.left = removeFromBst(root.left, key);
			return root;
		} 
		if (root.data < key) {
			root.right = removeFromBst(root.right, key);
			return root;
		}
		if (root.left == null) {
			return root.right;
		} 
		if (root.right == null) {
			return root.left;
		}
		Node currNode = root.right;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		currNode.left = root.left;
		return root.right;
	}

    


    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(60);
        tree.insert(20);
        tree.insert(30);
        tree.insert(90);
        tree.insert(50);
        tree.insert(100);
        tree.insert(70);
        

        tree.inorder();

        tree.deleteKey(50);

        System.out.println("\nAFTER DELETING");
        tree.inorder();

    }
    
}
