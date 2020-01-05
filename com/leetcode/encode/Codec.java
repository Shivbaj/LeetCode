package com.leetcode.encode;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.CampusBike.Solution;

public class Codec {

	public static void main(String args[]) 
    { 
		Codec sol = new Codec(); 
		List<String> data = decode("[\"\"]");
    }
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	if(strs.size()==0 && strs.get(0).equals("\"\""))
    		return new String("[\"\"]");
    	if(strs.size()==0)
            return new String("");
        StringBuilder str = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            String data = strs.get(0);
            str.append("|");
            str.append(data);
        }
        String result = str.toString();
        return result;
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
    	if(s.equals("[\"\"]")) {
    		List<String> data = new ArrayList<String>();
    		data.add("\"\"");
    		System.out.print(data.get(0));
    		return data;
    	}
    		
    	 if(s.length()==0)
             return new ArrayList<String>();
         
         List<String> data = new ArrayList<>();
         String[] str = s.split(":");
         for(int i=0;i<str.length;i++){
             data.add(str[i]);
         }
         
         return data;
    }
}
