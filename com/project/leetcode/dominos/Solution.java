package com.project.leetcode.dominos;

import java.util.HashMap;

public class Solution {
	 public void minDominoRotations(int[] A, int[] B) {
	        //The sum of values of each row after rotation can be 6,12,18,24,30,36
	        //that is in range of 6 to 36(before rotation)
	        //Find the sum of the each array A and B
	        int sumOfA = 0;
	        int sumOfB = 0;
	        int swaps =0;
	        for(int i=0;i<A.length;i++)
	        {
	            sumOfA = sumOfA + A[i];
	            sumOfB = sumOfB + B[i];
	        }
	        System.out.printf("The values of sum A "+sumOfA);
	        System.out.printf("The values of sum B "+sumOfB);
	        
	        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	        HashMap<Integer,Integer> hm1=new HashMap<Integer,Integer>();
	       	 
      	     for(int i=0;i<A.length;i++)
	        {
	        		hm.put(A[i],i);
	        		hm1.put(B[i],i);
	        }
	        	//We have 2 option increase sum of A by 5 or decrease sum of A by one,
	        	// for value to be 12 , every value should be 2 in array , for value to be 18 every value should be 3 in array
	        if(hm.size()<hm1.size())
	        {
	        	int val = sumOfA/6;
	        	//all values in array should be equal to val or val+1 
	        	 swaps = findNoOfSwaps(val,A,B);
	         //check whether array A has aal equal values 
	        	 HashMap<Integer,Integer> hm2=new HashMap<Integer,Integer>();
	        	 
	        	  for(int i=0;i<A.length;i++)
	  	        {
		        		hm2.put(A[i],i);
	  	        }
	        	if(hm2.size()!=1) 
	        		 swaps=-1;
	        	
	        	 
	        }
	        else
	        {
	        	int val = sumOfB/6;
	        	//all values in array should be equal to val or val+1 
	        	 swaps = findNoOfSwaps(val,B,A);
	        	 HashMap<Integer,Integer> hm3=new HashMap<Integer,Integer>();
	        	 
	        	  for(int i=0;i<B.length;i++)
	  	        {
		        		hm3.put(B[i],i);
	  	        }
	        	if(hm3.size()!=1) 
	        		 swaps=-1;
	        	
	        }
	        	 
	        	
	       
	        System.out.print(swaps);
	        
	    }
	 private int findNoOfSwaps(int val, int[] a, int[] b) {
		 int counter =0;
		 for(int i=0;i<a.length;i++)
		 {
			 if(a[i]!=val)
			 {
				 swap(a,b,i);
				 counter++;
			 }
		 }
		// TODO Auto-generated method stub
		return counter;
	}
	private void swap(int[] a, int[] b, int i) {
		int temp = a[i];
		a[i] = b[i];
		b[i] = temp;
		
	}
	public static void main(String[] args) { 
		 Solution sol = new Solution();
		int[] A = new int[]{1,2,1,1,1,2,2,2}; 
		int[] B = new int[]{2,1,2,2,2,2,2,2}; 		
		sol.minDominoRotations(A, B);
		} 
}
