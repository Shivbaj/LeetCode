package com.project.leetcode.rainwater;

import java.io.IOException;

class Solution {
    public int trap(int[] height) {
        int countOfRainwater=0;
        
        for(int j=0;j<height.length;j++)
        {
        
        	  // Find the maximum element on its left 
             int left = height[j]; 
             for (int i=0; i<j; i++) 
                left = Math.max(left, height[i]);
          // Find the maximum element on its right    
             int right = height[j]; 
             for (int i=j+1; i<height.length; i++) 
                right = Math.max(right, height[i]);  
              
            // Update the maximum water     
            System.out.println("The left and right values are as"+ left+ "  "+ right);	
             countOfRainwater = countOfRainwater + (Math.min(left, right) - height[j]);  
        	
        }
        
        return countOfRainwater;
    }
    
}
