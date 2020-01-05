package com.project.graphs;

public class Dij {
	  /* Let us create the example graph discussed above */
	 public static void main(String[] args) 
	    { 
	        /* Let us create the example graph discussed above */
	        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
	                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
	                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
	                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
	                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
	                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
	                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
	                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
	                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
	        Dij t = new Dij(); 
	        t.dijkstra(graph, 0); 
	    }

	private void dijkstra(int[][] graph, int source) {
		// TODO Auto-generated method stub
		int distanceMatrix[] = new int[9];
		Boolean visitedVertex[] = new Boolean[9];
		for(int i=0;i<9;i++) {
			visitedVertex[i] = false;
			distanceMatrix[i] = Integer.MAX_VALUE; 
		}
		distanceMatrix[source] =0;
		
		for(int count =0; count<9;count++)
		{
			// find the vertex that is not visited and has the minimum distance value from the set of vertices not included
			int u = minDistance(distanceMatrix,visitedVertex);
			// Update the visited verted
			visitedVertex[u] = true;
			
			// Update the distance value of the adjacent vertex of the above picked vertex
			for(int i=0;i<9;i++)
			{
				
				//update the distance matrix corresponding to vertex i only if
				// i is not in visited , there is edge from u to v 
				// Total weight of the path from source to i through u should be smaller than current distance value of vertex i
				if(!visitedVertex[i] && graph[u][i]!=0   && distanceMatrix[u]!= Integer.MAX_VALUE &&  distanceMatrix[u] + graph[u][i] < distanceMatrix[i] )
					distanceMatrix[i] = distanceMatrix[u] + graph[u][i];
				
				
				
			}
		}
		
		System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < 9; i++) 
            System.out.println(i + " \t\t " + distanceMatrix[i]); 
	}

	private int minDistance(int[] distanceMatrix, Boolean[] visitedVertex) {
		// TODO Auto-generated method stub
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		 for(int i=0;i<9;i++)
		 {
			 if(visitedVertex[i] == false && distanceMatrix[i]<=minValue)
			 {
				 minValue =distanceMatrix[i];
				 minIndex = i;
		 }
	   }
		return minIndex; 
	}
}
