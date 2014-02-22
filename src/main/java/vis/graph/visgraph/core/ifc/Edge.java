package vis.graph.visgraph.core.ifc;

public interface Edge<T> {
	public Vertex<T> getSource();
	public void setSource(Vertex<T> source);
	public Vertex<T> getDestination();
	public void setDestination(Vertex<T> destination);
}