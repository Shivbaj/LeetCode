package com.projects.leetcode.splitarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution12 {

	 public static void main(String[] args) { 
		 Solution12 sol = new Solution12();
		int[] A = new int[]{1,2,3,4,4,5}; 	
		boolean result = sol.isPossibles(A);
		System.out.print(result);
		}
	 
	 public boolean isPossibles(int[] nums) {
		    Map<Integer, Integer> freq = new HashMap<>();
		    Map<Integer, Integer> appendfreq = new HashMap<>();
		    for(int i=0;i<nums.length;i++) 
		    	freq.put(nums[i], freq.getOrDefault(nums[i],0) + 1);
		    
			for(int i=0;i<nums.length;i++)  {
		        if (freq.get(nums[i]) == 0) continue;
		        else if (appendfreq.getOrDefault(nums[i],0) > 0) {
		            appendfreq.put(nums[i], appendfreq.get(nums[i]) - 1);
		            appendfreq.put(nums[i]+1, appendfreq.getOrDefault(nums[i]+1,0) + 1);
		        }   
		        else if (freq.getOrDefault(nums[i]+1,0) > 0 && freq.getOrDefault(nums[i]+2,0) > 0) {
		            freq.put(nums[i]+1, freq.get(nums[i]+1) - 1);
		            freq.put(nums[i]+2, freq.get(nums[i]+2) - 1);
		            appendfreq.put(nums[i]+3, appendfreq.getOrDefault(nums[i]+3,0) + 1);
		        }
		        else 
		        	return false;
		        freq.put(nums[i], freq.get(nums[i]) - 1);
		    }
		    return true;
		}

	public boolean isPossible(int[] a) {
		// TODO Auto-generated method stub
		List<Integer> mainSequence =  new ArrayList<Integer>();
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> UniqueValueMap = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++) {
			hashMap.put(a[i], hashMap.getOrDefault(a[i], 0)+1);
			UniqueValueMap.put(i, a[i]);
		}
		//create a main sequence 
		for(int i=0;i<hashMap.size();i++) {
			int val = hashMap.get(i);
			hashMap.put(a[i], hashMap.getOrDefault(a[i], 0)-1);
		}
		return false;
	}
}
