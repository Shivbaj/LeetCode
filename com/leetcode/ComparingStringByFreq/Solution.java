package com.leetcode.ComparingStringByFreq;

import java.awt.List;
import java.util.HashMap;

public class Solution {
	
	 public static void main(String args[]) {
		 String[] queries = new String[] {"cbd"};
		 String[] words = new String[] {"zaaaz"};
		 int[] result = numSmallerByFrequency(queries,words);
		 for(int k=0;k<result.length;k++) {
			 System.out.print(result[k]);
		 }
	 }
	  public static int[] numSmallerByFrequency(String[] queries, String[] words) {
	        int[] freqQueries = new int[queries.length];
	        int[] wordQueries = new int[words.length];
	        int[] results = new int[queries.length];
	        int c=0;
	        for(int i=0;i<queries.length;i++){
	            String query = queries[i];
	            int freq = findMaxFreqOfChar(query, query.length());
	            freqQueries[i] = freq;
	        }
	        
	        for(int j=0;j<words.length;j++){
	            String query = words[j];
	            int freq = findMaxFreqOfChar(query, query.length());
	            wordQueries[j] = freq;
	        }
	        for(int i=0;i<freqQueries.length;i++){
	        	int val = freqQueries[i];
	        	int counter=0;
	        	 for(int j=0;j<wordQueries.length;j++){
	        		 if(val>wordQueries[j]) {
	        			 counter++;
	        	 }
	          }
	        	 results[i] = counter;
	        }   
			return results;
	    }
	// function that return the smallest alphabet 
	   public static int findMaxFreqOfChar(String a, int n) 
	    { 
	        // initializing smallest alphabet to 'z' 
	        char min = 'z'; 
	       
	        // find smallest alphabet 
	        for (int i=0; i<n; i++)     
	            if (a.charAt(i) < min) 
	                min = a.charAt(i);     
	       int count=0;
	        for (int j=0; j<n; j++)  {
	        	  if (a.charAt(j) == min)
	        		  count++;
	        }
	        // returning smallest alphabet 
	        return count; 
	    } 
	  
}
