package classPacker;

/**
 * @Author: Andrew Roney
 * @Date: 	09/27/2022
 * @Description: This class is the main class. It takes a file, reads it,
 * 				 then executes the rest of the task if criteria are met.
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunClassDependencyRelator {
	static DirectedGraph graph = new DirectedGraph();

//MAIN: Create a new task and run the task.
	public static void main(String[] args) {
		new RunClassDependencyRelator().readGraph();
		graph.depthFirstSearch();
		System.out.println(graph.parenthesizedList.toString());//Display Parenthesized list.
		System.out.println(graph.hierarchy.toString());//Display Hierarchy after vertices are processed.
		graph.displayUnreachableClasses();
	}
	
//Method: Takes input from a file and reads the data to build a Directed Graph.
	public void readGraph() {
		JFileChooser choice = new JFileChooser(new File("."));//File Selection Window.
		int option = choice.showOpenDialog(null);
		
		if(option == JFileChooser.APPROVE_OPTION) {//File Validation.
			try {
				Scanner input = new Scanner(choice.getSelectedFile());//Input set as file contents.
				
				while(input.hasNextLine()) {
					String edgeString = input.nextLine();
					String[] edge = edgeString.split(" ");//Find words split by a space.
					
					if(graph.startingNode == null)//Marks the first Node of the graph. DFS will start from this node.
						graph.startingNode = graph.getVertex(edge[0]);
					
					for(int i = 1; i < edge.length; i++) {
						graph.addEdge(edge[0], edge[i]);
					}
				}//End WHile
			}
			catch(FileNotFoundException e) {//File selection error.
				e.printStackTrace();
			}//Catch
		}//If
	}//Method
}//Class
