package com.projects.leetcode.splitarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.leetcode.dominos.Solution1;

class Solution {
	
    public boolean isPossible(int[] nums) {
 
        //the next element should be i or i+1
        int indexArray[] = new int[nums.length];
        for(int j=0;j<nums.length;j++){
            indexArray[nums[j]]++;
        }
        for(int j=1;j<indexArray.length;j++){
            System.out.print(indexArray[j]);
            
        }
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i : nums) 
        	{
        	   freq.put(i, freq.getOrDefault(i,0) + 1);
        	
        	}
        //Find 3 consecutive 1's in array
        List<Integer> countOne = getMaxLength(nums,nums.length,1);
        int pos= countOne.size();
        if(countOne.get(pos)<3)
        	return false;
        int startIndex =countOne.size()-1;
        int c=0;
        for(int k = startIndex+1; k<nums.length;k++)
        {
        	if(nums[k]-1>=0)
        		c++;
        }
        if(c>=3)
        	return true;
		return false;
    } 
    
    public List<Integer> getMaxLength(int arr[], int n, int countDigit) 
    { 
    	List<Integer> tempList = new ArrayList<Integer>();
    	
          
        int count = 0; //intitialize count 
        int result = 0; //initialize max 
      
        for (int i = 0; i < n; i++) 
        { 
              
            // Reset count when 0 is found 
            if (arr[i] != 1) 
                count = 0; 
      
            // If 1 is found, increment count 
            // and update result if count becomes 
            // more. 
            else
            {
            	tempList.add(i);
                count++;//increase count 
                result = Math.max(result, count); 
            } 
        } 
        tempList.add(result);
        return tempList; 
    }
    
    
	 public static void main(String[] args) { 
		 Solution sol = new Solution();
		int[] A = new int[]{1,2,3,4,4,5}; 	
		boolean result = sol.isPossible(A);
		//System.out.print(result);
		}
}