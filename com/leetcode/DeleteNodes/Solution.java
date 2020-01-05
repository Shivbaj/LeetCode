package com.leetcode.DeleteNodes;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.FlipEquivalentBT.TreeNode;

public class Solution {

	static List<TreeNode> list1 = new ArrayList<TreeNode>();
	static TreeNode root1 ;
	static TreeNode root2 ;
	
	
	public static void main(String args[]) 
    { 
    	Solution tree = new Solution(); 
    	 tree.root1 = new TreeNode(1); 
         tree.root1.left = new TreeNode(2); 
         tree.root1.right = new TreeNode(3); 

         tree.root1.left.left = new TreeNode(4); 

         tree.root1.left.right = new TreeNode(5); 
         tree.root1.right.left = new TreeNode(6); 

         tree.root1.right.right = new TreeNode(7); 

    	int[] nodesToDelete = new int[]{3,5};

    	list1 = tree.delNodes(root1,nodesToDelete);

        System.out.print("\n\n\n");
        for(int i=0;i<list1.size();i++) {
        	System.out.print(list1.get(i).val);
        }
        
    }


	private List<TreeNode> delNodes(TreeNode root1, int[] nodesToDelete) {
		for(int i=0;i<nodesToDelete.length;i++) {
			delnode(root1, nodesToDelete[i]);
		}
		list1.add(root1);
		return list1;
	}


	private void delnode(TreeNode root1, int nodeTodelete) {
		if(root1!=null) { 
			if(root1.val== nodeTodelete)
			{
				TreeNode tempRight = root1.right;
				TreeNode tempLeft = root1.left;
				list1.add(tempLeft);
				list1.add(tempRight);
				root1.right = null;
				root1.left = null;
				list1.add(root1);
				//addtrailingNodeToList(tempRight);
				//addtrailingNodeToList(tempLeft);
				return ;
			}
			delnode(root1.left,nodeTodelete);
			delnode(root1.right,nodeTodelete);
		}
		return; 
		
	}


	private void addtrailingNodeToList(TreeNode tempNode) {
		if(tempNode!=null) {
			list1.add(tempNode);
			addtrailingNodeToList(tempNode.left);
			addtrailingNodeToList(tempNode.right);
		}
		
	} 
}
