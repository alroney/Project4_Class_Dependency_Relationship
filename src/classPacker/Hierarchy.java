package classPacker;

/**
 * @Author: Andrew Roney
 * @Date: 09/27/2022
 * @Description: This class will set the hierarchy of the LinkedList.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Hierarchy implements DFSActions<Vertex> {
	Queue<String> res = new LinkedList<>();
	
	@Override
	public void processVertex(Vertex vertex) {
		res.add(vertex.toString());
	}
	
	@Override
	public void ascendVertex(Vertex vertex) {
		res.add(")");
	}
	
	@Override
	public void descendVertex(Vertex vertex) {
		res.add("(");
	}
	
	@Override
	public void cycleDetected() {
		res.add("*");
	}
	
	
	@Override
	public String toString() {
		String ans = "";
		int size = 0;
		
		while(res.size() > 0) {
			String c = res.peek();
			res.remove();
			
			if(c == "(") {
				if(res.peek() == ")") {
					res.remove();
					continue;
				}
				else if(res.peek() == "*") {
					ans += res.peek() + " ";
					res.remove();
					res.remove();
					continue;
				}
			}
			
			if(c == "(") 
				size++;
			
			else if(c == ")")
				--size;
			
			if(c == "(" || c == ")")
				continue;
			
			if(c != "*")
				ans += "\n";
			
			for(int i = 0; i < size; i++) {
				ans += "\t";
			}
			
			ans += c + " ";
		}//End While loop
		
		ans += "\n";
		
		return ans;
	}
	
}
