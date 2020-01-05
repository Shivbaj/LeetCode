package com.project.tree;

public class BinaryTree {
	 // Root of the Binary Tree 
    static Node root; 
  

    public BinaryTree() 
    { 
        root = null; 
    } 
  
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
  	  
       BinaryTree tree = new BinaryTree(); 
       tree.root= new Node(1); 
       tree.root.left= new Node(2); 
       tree.root.right= new Node(3); 
       tree.root.left.left= new Node(4); 
       tree.root.left.right= new Node(5); 
       BT tree1 = new BT(); 
       System.out.println("Level order traversal of binary tree is "); 
       tree1.printLevelOrder(root); 
      // tree1.printData();
    }
}
