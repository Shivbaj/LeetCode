package com.project.graphs;

public class AdjacencyList {
	
	 // Adds an edge to an undirected graph 
    static void addEdge(GraphAdjacency graph, int src, int dest) 
    { 
        // Add an edge from src to dest.  
        graph.adjListArray[src].add(dest); 
          
        // Since graph is undirected, add an edge from dest 
        // to src also 
        graph.adjListArray[dest].add(src); 
    } 
    
    static void printGraph(GraphAdjacency graph)
    {
    	for(int v = 0; v < graph.numberOfVertices; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Integer pCrawl: graph.adjListArray[v]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    }
    
	
	 public static void main(String args[]) 
	    { 
	        // create the graph given in above figure 
	        int numberOfVertex = 5; 
	        GraphAdjacency graph = new GraphAdjacency(numberOfVertex); 
	        addEdge(graph, 0, 1); 
	        addEdge(graph, 0, 4); 
	        addEdge(graph, 1, 2); 
	        addEdge(graph, 1, 3); 
	        addEdge(graph, 1, 4); 
	        addEdge(graph, 2, 3); 
	        addEdge(graph, 3, 4); 
	       
	       // print the adjacency list representation of   the above graph 
	        printGraph(graph); 
	    } 
}
