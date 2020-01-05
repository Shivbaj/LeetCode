package com.project.graphs;

public class GraphAdjacencyMatrix {
	 public int numberOfVertex;
	 public boolean adjMatrix[][];
	//constructor to create matrix
	GraphAdjacencyMatrix(int numberOfVertex)
	{

         this.numberOfVertex = numberOfVertex;
         adjMatrix = new boolean[numberOfVertex][numberOfVertex];
	}
	
	public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
      //  adjMatrix[j][i] = true;
}

public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
}

}
