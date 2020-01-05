package com.leetcode.minimumknight;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//Not Completed
public class Solution {

	
	public static void main(String[] args) {
		
		int x =5;
		int y =5;
		int result = minKnightMoves(x,y);
		System.out.print(result);
	}

	public static int minKnightMoves(int x, int y) {
		
		  HashSet<String> visited = new HashSet();
		  visited.add("00");
		
		Queue<String> queueforX = new LinkedList<String>();
		queueforX.offer(Integer.toString(0)+Integer.toString(0));
		
		int moves=0;
		while(!queueforX.isEmpty()) {
			 int size = queueforX.size();
			 String target = Integer.toString(x)+Integer.toString(y);
			while(size>0) {
				 String lockPosition = queueforX.poll();
				  if(target.equals(lockPosition)) {
					  return moves;
				  }
				  StringBuilder sb = new StringBuilder(lockPosition);
				  for(int i=0;i<1;i++) {
					  char currentPosition = sb.charAt(i);
					  char nextPosition = sb.charAt(i+1);
					  String s1 = sb.substring(0,i)+ (currentPosition -'0' +2)+ (nextPosition -'0' +1);
					  String s2 = sb.substring(0,i)+(currentPosition -'0' +1)+ (nextPosition -'0' +2);
					  
					  if(!visited.contains(s1)) {
						  queueforX.offer(s1);
						  visited.add(s1);
					  }
					  if(!visited.contains(s2)) {
						  queueforX.offer(s2);
						  visited.add(s2);
					  }
				  }
				  
				  size--;
			}
			moves++;
		}
		
		return 0;
	}
}
