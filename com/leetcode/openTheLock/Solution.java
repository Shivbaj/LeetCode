package com.leetcode.openTheLock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.MinSwap.MinSwap;

public class Solution {

	

	 public static void main(String[] args) { 
		 Solution sol = new Solution();
		String[] deadends = new String[]{"0201","0101","0102","1212","2002"}; 	
		String target = "0202"	;
		int result = sol.openlock(deadends,target);
		System.out.print(result);
		}

	public int openlock(String[] deadends, String target) {
		  HashSet<String> deadEndsSet= new   HashSet(Arrays.asList(deadends));
		  HashSet<String> visited = new HashSet();
		  visited.add("0000");
		  
		  Queue<String> queue = new LinkedList();
		  //can even use queue.add
		  queue.offer("0000");
		  int level =0;
		  while(!queue.isEmpty()) {
			  int size = queue.size();
			  while(size>0) {
				  String lockPosition = queue.poll();
				  if(deadEndsSet.contains(lockPosition)) {
					  size--;
					  continue;
				  }
				  if(target.equals(lockPosition)) {
					  return level;
				  }
				  StringBuilder sb = new StringBuilder(lockPosition);
				  for(int i=0;i<4;i++) {
					  char currentPosition = sb.charAt(i);
					  String s1 = sb.substring(0,i)+ (currentPosition == '9' ? 0 : currentPosition -'0' +1) +  sb.substring(i+1);
					  String s2 = sb.substring(0,i)+ (currentPosition == '0' ? 9 : currentPosition - '0' -1) + sb.substring(i+1);
					  
					  if(!visited.contains(s1) && !deadEndsSet.contains(s1)) {
						  queue.offer(s1);
						  visited.add(s1);
					  }
					  if(!visited.contains(s2) && !deadEndsSet.contains(s2)) {
						  queue.offer(s2);
						  visited.add(s2);
					  }
				  }
				  
				  size--;
				  
			  }
			  level++;
		  }
	        
	     return -1;
	       
	}
}
