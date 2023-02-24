package classPacker;

/**
 * @Author: Andrew Roney
 * @Date: 09/27/2022
 * @Description: This class is where the graph of the mapped nodes is created.
 */

import java.util.*;

public class Graph<V> {
	public V startingNode = null;//Starting Node of the Graph.
	
	Map<String, V> vertices = new HashMap<>();//Map all the vertex name to corresponding Vertex.
	Map<V, ArrayList<V>> adjacencyList = new HashMap<>();//Adjacency representation of the graph.
	
	Set<V> visited = new HashSet<>();//Track if a node or Vertex is visited in the search.
	Set<V> discovered = new HashSet<>();//Track if a node or Vertex is discovered in the search.
	
	ParenthesizedList hierarchy = new ParenthesizedList();//Utility
	Hierarchy parenthesizedList = new Hierarchy();//Utility
	boolean cycle;//Keeps track if the graph contains a circle.
	
	
	
	public void depthFirstSearch() {
		cycle = false;
		dfs(startingNode);//Start from the first node of the input data.
	}
	
	
//Method: Search in the adjacency list in Depth-First-Order.
	private void dfs(V node) {
		if(discovered.contains(node)) {//Check if node already is visited.
			cycle = true;
			hierarchy.cycleDetected();//DFSAction
			parenthesizedList.cycleDetected();//DFSAction
			return;
		}
		
		hierarchy.processVertex((Vertex) node);//DFSAction
		parenthesizedList.processVertex((Vertex) node);//DFSAction
		
		hierarchy.descendVertex((Vertex) node);
		parenthesizedList.descendVertex((Vertex) node);
		
		discovered.add(node);//Mark as discovered.
		visited.add(node);//Mark as visited.
		
		ArrayList<V> list = adjacencyList.get(node);//Discover all of it's child.
		
		if(list != null) {
			for(V u : list) {
				dfs(u);
			}
		}
		//Perform DFSActions
		hierarchy.ascendVertex((Vertex) node);
		parenthesizedList.ascendVertex((Vertex) node);
		discovered.remove(node);//Node is completely discovered. 
	}





//Method: Prints all the unvisited nodes/classes.
	public void displayUnreachableClasses() {
		for(Map.Entry<V, ArrayList<V>> entry : adjacencyList.entrySet()) {
			if(entry.getValue().size() > 0) {
				if(!visited.contains(entry.getKey())) {
					System.out.println(entry.getKey() +" is unreachable");
					visited.add(entry.getKey());
				}
				
				for(V vertex : entry.getValue()){//Check all of it's adjacent nodes
					if(!visited.contains(vertex)) {
						System.out.println(vertex +" is unreachable");
						visited.add(vertex);
					}//IF
				}//FOR
			}//IF
		}//FOR
	}//Method
}//Class
