package com.project.leetcode.maxArea;

import java.util.Deque;
import java.util.LinkedList;

public class MaxRecSubmatrixof1sWithChar {


	 
	private int maximum(char[][] input) {
		int temp[] = new int[input[0].length];
	     int maxArea = 0;
	     int area = 0;
	     for(int i=0;i<input.length;i++) {
	    	for(int j=0;j<temp.length;j++) {
	    		if(input[i][j]==0)
	    			temp[j]=0;
	    		else
	    			temp[j]+=Character.getNumericValue(input[i][j])	;
	    	}
	    	 area = maxHistogram(temp);
	            if(area > maxArea){
	                maxArea = area;
	            }
	    	 
	    	 
	     }
		
		return maxArea;
	}
	
	 public static void main(String args[]){
	        char input[][] = {{'1','1','1','0'},
	                         {'1','1','1','1'},
	                         {'0','1','1','0'},
	                         {'0','1','1','1'},
	                         {'1','0','0','1'},
	                         {'1','1','1','1'}};
	        MaxRecSubmatrixof1sWithChar mrs = new MaxRecSubmatrixof1sWithChar();
	        int maxRectangle = mrs.maximum(input);
	        System.out.println("Max rectangle is of size " + maxRectangle);
	        assert maxRectangle == 8;
	    }
	 
		public int maxHistogram(int[] input) {
	        Deque<Integer> stack = new LinkedList<Integer>();
	        int maxArea = 0;
	        int area = 0;
	        int i;
	        for(i=0; i < input.length;){
	            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
	                stack.offerFirst(i++);
	            }else{
	                int top = stack.pollFirst();
	                //if stack is empty means everything till i has to be
	                //greater or equal to input[top] so get area by
	                //input[top] * i;
	                if(stack.isEmpty()){
	                    area = input[top] * i;
	                }
	                //if stack is not empty then everythin from i-1 to input.peek() + 1
	                //has to be greater or equal to input[top]
	                //so area = input[top]*(i - stack.peek() - 1);
	                else{
	                    area = input[top] * (i - stack.peekFirst() - 1);
	                }
	                if(area > maxArea){
	                    maxArea = area;
	                }
	            }
	        }
	        while(!stack.isEmpty()){
	            int top = stack.pollFirst();
	            //if stack is empty means everything till i has to be
	            //greater or equal to input[top] so get area by
	            //input[top] * i;
	            if(stack.isEmpty()){
	                area = input[top] * i;
	            }
	            //if stack is not empty then everything from i-1 to input.peek() + 1
	            //has to be greater or equal to input[top]
	            //so area = input[top]*(i - stack.peek() - 1);
	            else{
	                area = input[top] * (i - stack.peekFirst() - 1);
	            }
	        if(area > maxArea){
	                maxArea = area;
	            }
	        }
	        return maxArea;
	    }
		


}
