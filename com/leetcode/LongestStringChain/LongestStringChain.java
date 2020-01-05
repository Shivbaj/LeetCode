package com.leetcode.LongestStringChain;

import java.util.Arrays;
import java.util.HashSet;

import com.leetcode.handOfStraight.HandOfStraight;

public class LongestStringChain {

	

	 public static void main(String[] args) { 
		 LongestStringChain sol = new LongestStringChain();
		String[] words = new String[] {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}; 	

		int result = sol.longestStrChain(words);
		System.out.print(result);
		}

	private int longestStrChain(String[] words) {
		HashSet<String> hm = new HashSet<>(Arrays.asList(words));
		for (int i=1 ;i<words.length; i++) 
	        { 
	            String temp = words[i]; 
	  
	            // Insert s[j] at its correct position 
	            int j = i - 1; 
	            while (j >= 0 && temp.length() < words[j].length()) 
	            { 
	                words[j+1] = words[j]; 
	                j--; 
	             } 
	             words[j+1] = temp; 
	        } 
	     
	        int counter=0;
	        for(int i=words.length;i>1;i--){
	            for(int j=i-2;j>0;j--) {
	            String val = words[j];
	            if(hm.contains(val)) {
	            	hm.remove(val);
	                counter++;
	            }
	            }
	        }
	        return counter;
	}
}
