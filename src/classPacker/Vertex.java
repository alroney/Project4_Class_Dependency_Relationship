package classPacker;

/**
 * 
 * @Author 	Andrew Roney
 * @Date	09/27/2022
 * @Description	This class is the vertex and here it is given a name. 
 *
 */

public class Vertex {
	private String name;
	
//Constructor: Sets the default name.
	public Vertex(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
