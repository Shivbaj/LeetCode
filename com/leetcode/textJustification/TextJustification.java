package com.leetcode.textJustification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TextJustification {
	
	public static void main(String[] args) {
		String array[] = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;
		fullJustify(array,maxWidth);
	}
	public static void fullJustify(String[] words, int maxWidth) {
	    int totalLengthRequired =0;
	    List<String> list = new ArrayList<String>();

	    List<List<String>> list2 = new  ArrayList<List<String>> ();
        for(int i=0;i<words.length;i++){
            totalLengthRequired+=words[i].length();
        }
        totalLengthRequired = totalLengthRequired+ (words.length-1);
        int noOfLines = totalLengthRequired%maxWidth!=0?(totalLengthRequired/maxWidth)+1:(totalLengthRequired/maxWidth);
        //FInd the number of words to fit in each line
        int start = 0;
        for(int j=0;j<noOfLines;j++){
        	StringBuilder str = new StringBuilder(); 

        	List<String> list1 = new ArrayList<String>();
            int end = maxWidth;
            int lengthRequired =0;
            int i;
            for(i=start;i<words.length;i++){ 
                if(lengthRequired+words[i].length()<maxWidth){
                	str.append(words[i]);
                	list1.add(words[i]);
                	list1.add("");
                	str.append(" ");
                	lengthRequired+=words[i].length();
                }
                else
                	break;
            }
            start = i;
            list.add(str.toString());
            list2.add(list1);
        }
        for(int k=0;k<list2.size();k++) {
        	System.out.print(list2.get(k).get(1));
        }
        
	}

}
