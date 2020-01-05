package com.leetcode.binarytreecoloring;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.LongestStringChain.LongestStringChain;

//Incomplete
public class Solution {

	
	 public static boolean btreeGameWinningMove(Tree root, int n, int x) {
	        //find the ancestors of root x
	        List<Tree> node = new LinkedList<Tree>();
	        boolean res = findAncestor(root,x);
			return res;
	    }
	 

	 public static void main(String[] args) { 
		 Solution sol = new Solution(); 
	       Tree root = new Tree(1); 
	        root.left = new Tree(2); 
	        root.right = new Tree(3); 
	        root.right.right = new Tree(7); 

	        root.right.left = new Tree(6);
	        
	       root.left.left = new Tree(4); 
	        root.left.right = new Tree(5); 

	        
	       root.left.right.left = new Tree(10); 
	       root.left.right.right = new Tree(11); 
	        
	      root.left.left.left = new Tree(8); 
	        root.left.left.right = new Tree(9); 

	        boolean result = btreeGameWinningMove(root,11,3);
		}


	 public static boolean findAncestor(Tree root,int valToFind){
         HashSet<Integer> nodeValues =  new HashSet<>();
         Tree temp = root;
         addvalues(temp,valToFind,nodeValues,null);
         boolean r =  check(nodeValues,root);
		return true;
         
   }
   
   public static boolean check(HashSet<Integer> nodeValues, Tree root) {
		if(root==null)
			return false;
		while(root!=null) {
		if(!nodeValues.contains(root.val)) {
			return true;
		}
		root = root.left;
		}
		return false;
	}


   
   public int getNodeHeight(Tree root, Tree x, int height){
		if(root==null) return 0;
		if(root==x) return height;
		
		//check if the node is present in the left sub tree
		int level = getNodeHeight(root.left,x,height+1);
		//System.out.println(level);
		if(level!=0) return level;
		
		//check if the node is present in the right sub tree
		return getNodeHeight(root.right,x,height+1);
	}
public static void addvalues(Tree temp,int valToFind, HashSet<Integer> nodeValues,Tree previous){
       if(temp ==null)
           return;
       Tree prev = previous;
       if(temp.val==valToFind && temp.left!=null && temp.right!=null ){
    	   nodeValues.add(temp.val);
           nodeValues.add(temp.left.val);
           nodeValues.add(temp.right.val);
           nodeValues.add(prev.val);
       }
       prev = temp;
       addvalues(temp.left,valToFind,nodeValues,prev);
       addvalues(temp.right,valToFind,nodeValues,prev);    
   }
}
