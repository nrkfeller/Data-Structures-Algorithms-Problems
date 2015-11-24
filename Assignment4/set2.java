/*
Q2. Design & implement a binary tree utilizing program to hold
a string of integers (e.g., 181 728 67 1 3 8 377 18 1) then
output the numbers in ascending order.
*/
import java.util.Scanner;

// binary tree node
class Node
{
    int data;
    // each node has a right and left child these are the "pointers"
    Node rightChild;
    Node leftChild;
    
    // give it passed data
    Node(int data)
    {
        this.data = data;
    }
    
    // make it printable
    public String toString() {
        return " " + data;
    }
}

class BinaryTree
{
    // tree needs first node to start from, call it root
    Node root;
    
    // we need to be able to insert node in a way that respects the data structure
    public void insert(int key) {
        
        // initialize new node
		Node newNode = new Node(key);
		
		// if the tree is empty, new node is the root!
		if (root == null) {
			root = newNode;
		} 
		// Otherwise follow the procedure
		else {
		    
		    // current node is root
			Node current = root;
		    // initialize the parent node
			Node parent;
			while (true) {
			    // so the current is the parent
				parent = current;
				
				// if the key is smaller go left
				if (key < current.data) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} 
				// if key is larger, go right
				else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
    
    // in order traversal, is like a sort for sorting
    public void inOrderTraverseTree(Node current) {
        
        // if we are not at the end, traverse left to the end then traverse right
        if (current != null) {
            // recursively go left
            inOrderTraverseTree(current.leftChild);
            System.out.print(current);
            // recursively go right
            inOrderTraverseTree(current.rightChild);
        }
    }
}

class BinTreeApp{
    public static void main(String[] args) 
    {
        
        BinaryTree myTree = new BinaryTree();
        
        // deal with string input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter elements to sort in the format : < 34 544 65 345 65 564 23 65 76 > ");
        String s = in.nextLine();
        String[] strings = s.split(" ");
        int[] numbers = new int[strings.length];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        
        // insert into the binary tree
        for (int i = 0; i < numbers.length ; i++){
           myTree.insert(numbers[i]);
        }
        
        // perform ordered traversal
        System.out.println("Ordered traversal : ");
        myTree.inOrderTraverseTree(myTree.root);
        
        System.out.println();
        
    }

}


