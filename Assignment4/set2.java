/*
Q1. Design & implement a program that constrcuts binary trees capable 
of holding postfix arithmatic expressions, such as 14 23 + 7 - 12 *

Q2. Design & implement a binary tree utilizing program to hold
a string of integers (e.g., 181 728 67 1 3 8 377 18 1) then
output the numbers in ascending order.

Q3. Do Q2, but this time implement the tree using an array.

Q4. Design a program that accepts two binary search trees and 
merges them into one tree. 
*/
import java.util.Scanner;

class Node
{
    int data;
    
    Node rightChild;
    Node leftChild;
    
    Node(int data)
    {
        this.data = data;
    }
    
    public String toString() {
        return " " + data;
    }
}

class BinaryTree
{
    Node root;
    public void insert(int key) {
		Node newNode = new Node(key);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.data) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
    
    public void inOrderTraverseTree(Node focusNode) {
	   if (focusNode != null) {
	       inOrderTraverseTree(focusNode.leftChild);
	       System.out.print(focusNode);
	       inOrderTraverseTree(focusNode.rightChild);
	   }
    }
}

class BinTreeApp{
    public static void main(String[] args) 
    {
        
        BinaryTree myTree = new BinaryTree();
        
        Scanner reader = new Scanner(System.in);
       // prompt user for size of the array
       System.out.print("How many items do you want in the tree? : ");
       int numOfItems = reader.nextInt(); 
       
       for (int i = 0; i < numOfItems ; i++){
           System.out.print("Enter a number, " + (numOfItems - i) + " remaining : ");
           int newData = reader.nextInt(); 
           myTree.insert(newData);
       }
        
        
        System.out.println("Ordered traversal : ");
        myTree.inOrderTraverseTree(myTree.root);
        
    }

}


