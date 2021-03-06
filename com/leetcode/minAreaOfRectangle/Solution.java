package com.leetcode.minAreaOfRectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

	public static void main(String args[]) {
		Solution sol = new Solution();
		int[][] points = new int[][] {{1,1},{1,3},{3,1},{3,3},{2,2}};
		int minArea = minAreaRect(points);
	}

	public static int minAreaRect(int[][] points) {
		  Map<Integer, HashSet<Integer>> map = new HashMap<>();
	        for (int[] p : points) {
	            if (!map.containsKey(p[0])) {
	                map.put(p[0], new HashSet<>());
	            }
	            map.get(p[0]).add(p[1]);
	        }
	        int min = Integer.MAX_VALUE;
	        for (int[] p1 : points) {
	            for (int[] p2 : points) {
	                if (p1[0] == p2[0] || p1[1] == p2[1]) { // if have the same x or y
	                    continue;
	                }
	                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) { // find other two points
	                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
	                }
	            }
	        }
	        return min == Integer.MAX_VALUE ? 0 : min;
	}
}
