package com.project.graphs;

import java.util.LinkedList;

public class GraphAdjacency {
	int numberOfVertices;
	LinkedList<Integer> adjListArray[];
    
	// constructor
	GraphAdjacency(int numberOfVertices)
	{
		this.numberOfVertices = numberOfVertices;
        // define the size of array as  
        // number of vertices 
        adjListArray = new LinkedList[numberOfVertices]; 
        // Create a new list for each vertex 
        // such that adjacent nodes can be stored 
        for(int i = 0; i < numberOfVertices ; i++){ 
            adjListArray[i] = new LinkedList<>(); 
        } 
	}
	
}
