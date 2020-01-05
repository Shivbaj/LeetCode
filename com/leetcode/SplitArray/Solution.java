package com.leetcode.SplitArray;

import java.util.List;

public class Solution {

	public static void main(String args[]) 
    { 
    	Solution sol = new Solution(); 
    	int[] nums = {7,2,5,10,8};
    	int m  = 2;
    	int  result = splitArray(nums,m);
    }

	private static int splitArray(int[] nums, int m) {
		int max = 0;
		long sum =0;
		for(int i=0;i<nums.length;i++) {
			max = Math.max(nums[i],max);
			sum += nums[i];
		}
		 if (m == 1) 
			 return (int)sum;
		 
		 //Apply binary search 
		 long low = max;
		 long high = sum;
		 while(low<high) {
			 long mid = low + (high-low)/2;
			 int pieces = split(nums,mid);
			 if(pieces>m) {
				 low = mid+1;
			 }else
				 high = mid;
			 
		 }
		 
		 
		return (int)low;
	}

	private static int split(int[] nums, long largetSum) {
		int pieces =1;
		int tempSum=0;
		for(int i=0;i<nums.length;i++) {
			if(tempSum+nums[i]>largetSum) {
				tempSum = nums[i];
				pieces++;
			}else
				tempSum+=nums[i];
		}
		return pieces;
	}

	
	
}
