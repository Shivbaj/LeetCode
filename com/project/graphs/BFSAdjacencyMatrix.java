package com.project.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFSAdjacencyMatrix {
	
	public static void main(String args[]) {
		//create a input array
		int numberOfVertex = 5;
		GraphAdjacencyMatrix inputMatrix = new GraphAdjacencyMatrix(numberOfVertex);
		inputMatrix.addEdge(0,1);
		inputMatrix.addEdge(0,2);
		inputMatrix.addEdge(1,2);
		inputMatrix.addEdge(2,3);
		inputMatrix.addEdge(2,0);
		inputMatrix.addEdge(3,3);
		 System.out.println("Following is Breadth First Traversal "+ 
                 "(starting from vertex 2)\n"); 

		bfs(inputMatrix, numberOfVertex, 2);
		 System.out.println("\nFollowing is Depth First Traversal "+ 
                 "(starting from vertex 2)");
		DFS(inputMatrix, numberOfVertex, 2);
	}

	private static void bfs(GraphAdjacencyMatrix inputMatrixGraph, int numberOfVertex, int souceVertex) {
		// find the bfs of input Graph
		boolean visited[] =  new boolean[numberOfVertex]; 
		 LinkedList<Integer> queue = new LinkedList<Integer>(); 
		queue.add(souceVertex);
		visited[souceVertex] =true;
		
		while(queue.size() != 0)
		{
			souceVertex = queue.poll(); 
	        System.out.print(souceVertex+" "); 
	        
	        // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
	    	 for(int j=0; j<numberOfVertex;j++) {
				if(inputMatrixGraph.adjMatrix[souceVertex][j]==true && !visited[j])
				{
		                    visited[j] = true; 
		                    queue.add(j); 
				}
				
			}
		}
		
	}

	private static void DFS(GraphAdjacencyMatrix inputMatrixGraph, int numberOfVertex, int souceVertex) {
		// find the DFS of input Graph
		boolean visited[] =  new boolean[numberOfVertex]; 
		DFSUtil(visited,numberOfVertex,souceVertex,inputMatrixGraph);
	
		
	}

	private static void DFSUtil(boolean[] visited, int numberOfVertex, int souceVertex,GraphAdjacencyMatrix inputMatrixGraph) {
		// TODO Auto-generated method stub
		visited[souceVertex] = true;
		System.out.print(souceVertex + " ");
		// Visit and recur all the vertices adjacent to this vertex selected above
	    for(int j=0; j<numberOfVertex;j++) {
			if(inputMatrixGraph.adjMatrix[souceVertex][j]==true && !visited[j])
				{
		                    visited[j] = true; 
		                  //  queue.add(j); 
		                    DFSUtil(visited,numberOfVertex,j,inputMatrixGraph);
				}
				
			}
		
	}
}
