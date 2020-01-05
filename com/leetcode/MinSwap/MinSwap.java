package com.leetcode.MinSwap;

import com.projects.leetcode.splitarray.Solution12;

public class MinSwap {
	

	 public static void main(String[] args) { 
		 MinSwap sol = new MinSwap();
		int[] A = new int[]{3,3,8,9,10}; 	
		int[] B = new int[]{1,7,4,6,8}; 	
		int result = sol.minSwap(A,B);
		System.out.print(result);
		}
	 
	public int minSwap(int[] A, int[] B) {
		
        int minSwaps =0;
        for(int i=0;i<A.length-1;i++){
                if(A[i]>=A[i+1])
                {
                    int temp =A[i];
                    A[i] = B[i];
                    B[i] = temp;
                    minSwaps++;
                    
                }
         
        }  
        for(int i=0;i<B.length-1;i++){
                if(B[i]>=B[i+1])
                {
                    int temp =B[i];
                    B[i] = A[i];
                    A[i] = temp;
                    minSwaps++;
                    
                }
         
        }  
        return minSwaps;
    }
}
