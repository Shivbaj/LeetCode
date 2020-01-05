package com.leetcode.CapacityToShip;

public class Solution {

	public static void main(String[] args) {
		int[] weights = new int[] {1,2,3,1,1};
		int D = 4;
		int result = shipWithinDays(weights,D);
	}
	
	public  static int shipWithinDays(int[] weights, int D) {
		  int sum=0;
		  for(int j=0;j<weights.length;j++) {
			  sum+=weights[j];
		  }
	       int mean = (sum/D);
	       int[] cal = new int[weights.length];
	       double result =0;
	       for(int i=0;i<weights.length;i++) {
	    	   result =result+  Math.pow(Math.abs(weights[i]- (mean)), 2);
	       }
	       int temp = (int) (result/D);
	       int deviation = (int)Math.sqrt(temp);
	       if(weights.length%D==0)
	    	   System.out.print("The deviation value is "+deviation/2);
	       else
	    	   System.out.print("The deviation value is "+deviation);
	       
	       System.out.print("The mean value is "+mean);
	        return 0;
	    }
}
