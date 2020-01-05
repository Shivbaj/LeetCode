package com.project.subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	 public int numDistinct(String A, String B) {
         Map<Character, Integer> freq = new HashMap<>();
         char[] StringAChar = A.toCharArray();
         char[] StringBChar = B.toCharArray();
         for (char i : StringAChar) 
            {
               freq.put(i, freq.getOrDefault(i,0) + 1);
            
            }
            
             for (char j : StringBChar) 
            {
               freq.put(j, freq.getOrDefault(j,0) + 1);
            
            }
			return 0;
    }
	 

	 public static void main(String[] args) { 
		 Solution sol = new Solution();
		String A = "rabbbit" ;	
		String B =  "rabbit";
		int result = sol.numDistinct(A,B);
		//System.out.print(result);
		}
}
