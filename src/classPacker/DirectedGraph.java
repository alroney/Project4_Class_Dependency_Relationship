package classPacker;

/**
 * @Author: Andrew Roney
 * @Date: 	09/27/2022
 * @Description: This class will create a directed edge and then graph it.
 */

import java.util.ArrayList;

public class DirectedGraph extends Graph<Vertex> {
	
//Method: Creates a directed edge and adds it to the graph. The 'u' Node has an edge from the source Node. The 'v' Node has an edge to the destination Node.
	public void addEdge(String u, String v) {
		ArrayList<Vertex> list = adjacencyList.get(getVertex(u));//Check if source node already has edges connected.
		
		if(list == null) {//If not in Adjacency list.
			list = new ArrayList<>();//Then map to a new Vertex and initialize.
		}
		
		list.add(getVertex(v));//Add edge to source to destination.
		adjacencyList.put(getVertex(u), list);//Update Adjacency list.
	}

//Method: Check if a node is already mapped to a vertex.
	public Vertex getVertex(String u) {
		if(!vertices.containsKey(u)) {//If not mapped.
			vertices.put(u, new Vertex(u));//Then Map it.
		}
		
		return vertices.get(u);
	}
	
}
