package com.leetcode.networkDelayTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetcode.MinSwap.MinSwap;

public class NetworkDelay {

    static int n=4;
	 public static void main(String[] args) { 
		 MinSwap sol = new MinSwap();
		int[][] times  = new int[][]{{2,1,1},
									 {2,3,1},
									 {3,4,1}}; 	
		
         int k=2;
         List<HashMap<Integer,Integer>> l1 = new ArrayList<HashMap<Integer,Integer>>();
         l1 = searchElements(times,l1,k);
		 int result = networkDelayTime(times,n,k);		
		 System.out.print(result);
		}
	 
	 
	 public static int networkDelayTime(int[][] times, int noOfVertex, int source) {
	       int[] distance = new int[noOfVertex];
	       boolean[] visitedAndIncludedvertex = new boolean[noOfVertex];
	       for(int i=0;i<noOfVertex;i++) {
	    	   distance[i] = Integer.MAX_VALUE;
	    	   visitedAndIncludedvertex[i] = false;
	       }
	       distance[source]=0;
	       for(int i=0;i<noOfVertex-1;i++) {
	    	   int u = minDistance(distance,visitedAndIncludedvertex);
	    	   visitedAndIncludedvertex[u] = true;
	    	   // Update dist value of the adjacent vertices of the 
	            // picked vertex. 
	            for(int vertex=0;vertex<noOfVertex;vertex++) {
	            	 // Update dist[v] only if is not in sptSet, there is an 
	                // edge from u to v, and total weight of path from src to 
	                // v through u is smaller than current value of dist[v] 
	            	if(!visitedAndIncludedvertex[vertex] &&  distance[u]!= Integer.MAX_VALUE && times[u][vertex]!=0 && (distance[u] + times[u][vertex] < distance[vertex])
	            			) {
	            		 distance[vertex] = distance[u] + times[u][vertex]; 
	            	}
	            }
	            int result = finMaxfromDistanceArray(distance);
	            return result;
	       }
		 	
		   return -1;  
	        
	     
	    }

	 
	 
	 
	public static int finMaxfromDistanceArray(int[] distance) {
		int index=-1;
		int maxDistance = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(distance[i]>= maxDistance) {
				maxDistance = distance[i]; 
				index = i; 
			}
		}
		return maxDistance;
	}


	private static int minDistance(int[] distance, boolean[] visitedAndIncludedvertex) {
		int minIndex=-1;
		int minDistance = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(!visitedAndIncludedvertex[i] && distance[i]<= minDistance) {
				minDistance = distance[i]; 
				minIndex = i; 
			}
		}
		return minIndex;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static List<HashMap<Integer,Integer>> searchElements(int[][] times,List<HashMap<Integer,Integer>> l1,int K) {
		 int valToSearch = K;
	    Queue<Integer> queue = new LinkedList<Integer>();
	    HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
     	for(int i=0;i<times.length;i++) {
     		if(times[i][0]==valToSearch){
     			queue.add(times[i][1]);
     			mapper.put(times[i][1], times[i][2]);
     			
     		}
     		else
     			continue;
	       
	          }
     	 l1.add(mapper);
		return l1;
	}
}
