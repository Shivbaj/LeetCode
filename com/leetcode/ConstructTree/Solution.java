package com.leetcode.ConstructTree;


import com.leetcode.FlipEquivalentBT.TreeNode;

public class Solution {
	static TreeNode list1;
	 int preIndex = 0, posIndex = 0; 
	public static void main(String args[]) 
    { 
    	Solution tree = new Solution(); 
    	int[] preOrderArray = new int[]{1,2,4,5,3,6,7};
    	int[] postOrderArray = new int[]{4,5,2,6,7,3,1};
    	list1 = tree.constructFromPrePost(preOrderArray,postOrderArray);
    }
	public TreeNode constructFromPrePost(int[] preOrderArray, int[] postOrderArray) {
		
		 TreeNode root = new TreeNode(preOrderArray[preIndex++]);
		 
	        if (root.val != postOrderArray[posIndex])
	            root.left = constructFromPrePost(preOrderArray, postOrderArray);
	        if (root.val != postOrderArray[posIndex])
	            root.right = constructFromPrePost(preOrderArray, postOrderArray);
	        
	        posIndex++;
	        return root;
        
    }

}
