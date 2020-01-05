package com.leetcode.FlipEquivalentBT;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
	static int totalFlips =0;
	static List<Integer> list1 = new ArrayList<Integer>();
	static TreeNode root1 ;
	static TreeNode root2 ;
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    	if (root1 == root2)
              return true;
      	if(root1==null || root2==null ||  root1.val != root2.val)
      		return false;
      	if(root1.val== root2.val)
      		flipnodes(root1);
      	
      	flipEquiv(root1.left,root2.left);
      	
      	flipEquiv(root1.right,root2.right);
      	
    	
    	return true;
    	
    	
    }
    
    
    
    
    
    
    
    private void flipnodes(TreeNode root1) {
    	list1.add(root1.val);
		// TODO Auto-generated method stub
    	TreeNode temp = root1.left;
    	 root1.left = root1.right;
    	 root1.right = temp;
    	 totalFlips++;
    	
		
	}











	public static void main(String args[]) 
    { 
    	Solution tree = new Solution(); 
    	 tree.root1 = new TreeNode(0); 
         tree.root1.left = new TreeNode(3); 
         tree.root1.right = new TreeNode(1); 
         tree.root1.right.right = new TreeNode(2); 

    	 tree.root2 = new TreeNode(3); 
         tree.root2.left = new TreeNode(3); 
         tree.root2.right = new TreeNode(2); 
         tree.root2.right.left = new TreeNode(4); 
         tree.root2.right.right = new TreeNode(5); 
         
         tree.root2.left.right = new TreeNode(6); 
         
         tree.root2.right.right.right = new TreeNode(7); 

         tree.root2.right.right.left = new TreeNode(8); 
         
         tree.root1 = new TreeNode(1); 

        boolean result = tree.flipEquiv(root1,root2);
        System.out.print(totalFlips);
        System.out.print("\n\n\n");
        for(int i=0;i<list1.size();i++) {
        	System.out.print(list1.get(i));
        }
        
    } 
}