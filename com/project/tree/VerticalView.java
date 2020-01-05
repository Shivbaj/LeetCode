package com.project.tree;

import java.util.ArrayList;
import java.util.List;

public class VerticalView {


	  
	  List<Integer> finalList = new ArrayList<Integer>();

	  List<Integer> finalList2 = new ArrayList<Integer>();
	  
	  /* function to print level order traversal of tree*/
	  public  void print(Node root) 
	  { 
		Vpleft(root);
		Vpright(root);
	  	printData();
	  	printData1();
	  }
	  
	  public void Vpleft(Node root) {
	        if (root == null) 
	            return ; 
        	finalList.add(root.data);
	        if(root.left!=null)
	        {

	        	Vpleft(root.left);
	        }
	  }
	  
	  public void Vpright(Node root) {
	        if (root == null) 
	            return ; 

	
	        if(root.right!=null)
	        {

	        	Vpright(root.right);
	        }

        	finalList2.add(root.data);
	  }
	  public void printData() {
		  for(int i=finalList.size()-1;i>=0;i--) {
			  System.out.println(finalList.get(i));
		  }
	  }
	  

	  public void printData1() {
		  for(int i=finalList2.size()-1;i>=0;i--) {
			  System.out.println(finalList2.get(i));
		  }
	  }

	 
}
