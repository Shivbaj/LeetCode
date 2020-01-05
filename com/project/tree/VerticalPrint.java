package com.project.tree;

public class VerticalPrint {
	 // Root of the Binary Tree 
    static Node root; 
  
    public VerticalPrint() 
    { 
        root = null; 
    } 
  
	
	   // Driver program to test the above functions 
    public static void main(String args[])  
    { 
    	VerticalPrint tree = new VerticalPrint(); 
   
        /* Let us construct the tree shown in above diagram */
    	tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.right = new Node(4); 
        tree.root.left.right.right = new Node(5); 
        tree.root.left.right.right.right = new Node(6); 
   
        VerticalView tree1 = new VerticalView(); 
        System.out.println("Top view binary tree is "); 
        tree1.print(root);
        
    } 
}
