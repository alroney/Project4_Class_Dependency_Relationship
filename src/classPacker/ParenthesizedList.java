package classPacker;
/**
 * @Author: Andrew Roney
 * @Date: 09/27/2022
 * @Description: This class is meant to maintain a Queue(a linked list) to trace
 * 				the order of the Nodes and their dependent Nodes with use of 
 * 				proper formating.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ParenthesizedList implements DFSActions<Vertex> {
	Queue<String> res = new LinkedList<>();
	
	@Override
	public void processVertex(Vertex vertex) {
		res.add(vertex.toString());
	}
	
	@Override
	public void descendVertex(Vertex vertex) {
		res.add("(");
	}
	
	@Override
	public void ascendVertex(Vertex vertex) {
		res.add(")");
	}
	
	@Override
	public void cycleDetected() {
		res.add("*");
	}
	
	
	@Override
	public String toString() {
		String ans = "";
		ans += "( ";
		
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
			ans += c + " ";
		}
		ans += ")\n";
		return ans;
	}
}
