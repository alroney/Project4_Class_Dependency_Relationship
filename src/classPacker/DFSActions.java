package classPacker;

/**
 * 
 * @Author: Andrew Roney
 * @Date: 09/27/2022
 * @Description: This redirects a call to action.
 * 
 */

public interface DFSActions<V> {
	public void processVertex(V vertex);
	public void descendVertex(V vertex);
	public void ascendVertex(V vertex);
	public void cycleDetected();
}