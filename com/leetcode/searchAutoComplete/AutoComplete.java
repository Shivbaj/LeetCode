package com.leetcode.searchAutoComplete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutoComplete {

    static HashMap<String,Integer> dictionary = new HashMap<>();

	public static void main(String[] args) {
		List<String> recommendedSentences = input('c');
		for(int i=0;i<recommendedSentences.size();i++) {
					System.out.print(recommendedSentences.get(i));
		}
	}
	    
	   public static List<String> input(char c) {
		   
		   List<String> recommendedSentences = new LinkedList<String>();

	       StringBuilder str = new StringBuilder(); 
	        while(c!='#'){   
	            str.append(c);
	            recommendedSentences = isSomethingAvailable(c);
	            return recommendedSentences;
	        }
	       dictionary.put(str.toString(),dictionary.getOrDefault(str.toString(),0));
		   return recommendedSentences;
	    }
	private static List<String> isSomethingAvailable(char c) {
		 HashMap<String,Integer> frequencyMap = new HashMap<>();

		//ArrayList<String>freqArray = new int[3];
		 List<String> freqList = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	        if(entry.getKey().startsWith(String.valueOf(c)))
	        	frequencyMap.put(entry.getKey(), entry.getValue());
	        
	        	
	    }
		final Map<String, Integer> sortedByCount = frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		for (Map.Entry<String, Integer> entry : sortedByCount.entrySet()) {
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	        freqList.add(entry.getKey());
	        	
	    }
		
		return freqList;
	}
}
