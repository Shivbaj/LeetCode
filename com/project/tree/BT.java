package com.project.tree;

import java.util.ArrayList;
import java.util.List;

public class BT {

  
  List<Integer> finalList = new ArrayList<Integer>();
  
  /* function to print level order traversal of tree*/
  public  void printLevelOrder(Node root) 
  { 
	Node updatedRoot = createMirrorImage(root);
  	postOrder(updatedRoot);
  	printData();
  }
	
  public Node  createMirrorImage(Node root) {
	        if (root == null) 
	            return root; 
	  
	        /* do the subtrees */
	        Node left = createMirrorImage(root.left); 
	        Node right = createMirrorImage(root.right); 
	  
	        /* swap the left and right pointers */
	        root.left = right; 
	        root.right = left; 
	  
	        return root; 
	   
	
}

public void postOrder(Node root)
  {
	if(root!=null) {
  	postOrder(root.left);
  //	System.out.println(root.data);

  	postOrder(root.right);

  	finalList.add(root.data);
  	}
  }
  
  public void printData() {
	  for(int i=finalList.size()-1;i>=0;i--) {
		  System.out.println(finalList.get(i));
	  }
  }

}
