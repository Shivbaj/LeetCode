package com.leetcode.CampusBike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public static void main(String args[]) 
    { 
    	Solution sol = new Solution(); 
    	int[][] workers = {{0,0},
    					   {2,1}};
    	int[][] bikes = {{1,2},
    					 {3,3}};
    	int [] resultsArray = assignBikes(workers,bikes);
    }
	
	public static int[]  assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int[] res = new int[n];
        boolean[] assigned = new boolean[n];
        boolean[] occupied = new boolean[m];
        List<int[]>[] list = new List[2001];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dist = dist(workers[i], bikes[j]);
         
                if (list[dist] == null) {
                    list[dist] = new ArrayList<>();
                }
                
                list[dist].add(new int[]{i, j});
            }
        }
        
        for (int i = 0; i < 2001; i++) {
            if (list[i] == null) 
            	continue;
            int size = list[i].size();
            for (int j = 0; j < size; j++) {
                int w = list[i].get(j)[0];
                int b = list[i].get(j)[1];
                
                if (!assigned[w] && !occupied[b]) {
                    res[w] = b;
                    assigned[w] = true;
                    occupied[b] = true;
                }
            }
        }
        
        return res;
    }
    
    public static int dist(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }
	
	
		
		
	
}
