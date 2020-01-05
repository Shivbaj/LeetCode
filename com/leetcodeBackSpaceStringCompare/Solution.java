package com.leetcodeBackSpaceStringCompare;

public class Solution {
	public static void main(String args[]) {
		String S = "a#c";
		String T = "b";
		boolean result = backspaceCompare( S,  T);
		System.out.print(result);
		
	}

	private static boolean backspaceCompare(String S, String T) {  StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for(int i=0;i<S.length();i++){
        if(S.charAt(i) != '#'){
            sb1.append(S.charAt(i));
           
        }
       
         if(S.charAt(i) == '#' && sb1.length()>0) {
        	 	sb1.deleteCharAt(sb1.length() - 1);
           //  sb1.substring(sb1.length() - 2);
         }
    }
    for(int j=0;j<T.length();j++) {
    	 if(T.charAt(j) != '#'){
             sb2.append(T.charAt(j));
         }
    	  if(T.charAt(j) == '#' && sb2.length()>0)
        	  sb2.deleteCharAt(sb2.length() - 1);   
             
    }
    if(sb1.toString().equals(sb2.toString()))
        return true;
    
    return false;}

}
