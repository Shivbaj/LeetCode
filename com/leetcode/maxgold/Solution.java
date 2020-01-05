package com.leetcode.maxgold;


public class Solution {
	
	public static void main(String args[]) 
    { 
    	
    	int[][] grid = {{0,6,0},
    	                {5,8,7},
    	                {0,9,0}};
 	 
    	int result1 = getMaximumGold(grid);
    	System.out.print(result1);
    	
    }
	
	    public static int getMaximumGold(int[][] grid) {
	        int result = 0;
	        for (int i = 0; i < grid.length; ++i) {
	            for (int j = 0; j < grid[0].length; ++j) {
	            	result = Math.max(result, dfs(grid, i, j, 0));
	            }
	        }
	        return result;
	    }
	    private static int dfs(int[][] g, int i, int j, int sum ) {
	        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0) 
	            return sum;
	        
	        sum += g[i][j];
	        g[i][j] += 1000; // mark visited.
	      
	        int mx = 0;
	        mx = Math.max(mx, dfs(g, i + 0, j + 1, sum));
		    mx = Math.max(mx, dfs(g, i + 1, j + 0, sum));
		    mx = Math.max(mx, dfs(g, i + 0, j -1, sum));
		    mx = Math.max(mx, dfs(g, i -1, j + 0, sum));
		    
	        g[i][j] -= 1000; // change back.
	        return mx;
	    }


	
}
