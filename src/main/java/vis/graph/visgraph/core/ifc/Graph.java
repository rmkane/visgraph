package vis.graph.visgraph.core.ifc;

import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public interface Graph<T> {
	public Vector<Vertex<T>> getVerticies();
	public void setVerticies(Vector<Vertex<T>> verticies);
	public Vector<Edge<T>> getEdges();
	public void setEdges(Vector<Edge<T>> edges);

	public Vertex<T> addVertex(T data, Point2D.Double point);
	public Vertex<T> addVertex(Vertex<T> vertex);
	public Edge<T> addEdge(Vertex<T> source, Vertex<T> destination);

	public boolean hasVertex(Vertex<T> vertex);
	public Iterator<Vertex<T>> verticies();
	public Set<Vertex<T>> getNeighbors(String vertex);
}
