package vis.graph.visgraph.core.impl;

import java.awt.geom.Point2D;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import vis.graph.visgraph.core.ifc.Edge;
import vis.graph.visgraph.core.ifc.Graph;
import vis.graph.visgraph.core.ifc.Vertex;

/**
 * @see <a href="http://www.cs.virginia.edu/cs201j-fall2002/lectures/graph/impl1/Graph.java">Graph.java</a>
 */
public class GraphImpl<T> implements Graph<T>{
	private Vector<Vertex<T>> verticies;
	private Vector<Edge<T>> edges;

	public GraphImpl() {
		verticies = new Vector<Vertex<T>>();
		edges = new Vector<Edge<T>>();
	}

	@Override
	public Vector<Vertex<T>> getVerticies() {
		return this.verticies;
	}

	@Override
	public void setVerticies(Vector<Vertex<T>> verticies) {
		this.verticies = verticies;
	}

	@Override
	public Vector<Edge<T>> getEdges() {
		return edges;
	}

	@Override
	public void setEdges(Vector<Edge<T>> edges) {
		this.edges = edges;
	}

	@Override
	public Vertex<T> addVertex(T data, Point2D.Double point) {
		Vertex<T> vertex = new VertexImpl<T>(data, point);
		return addVertex(vertex);
	}

	@Override
	public Vertex<T> addVertex(Vertex<T> vertex) {
		verticies.addElement(vertex);
		return vertex;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Edge<T> addEdge(Vertex<T> source, Vertex<T> destintion) {
		Edge<T> edge = new EdgeImpl(source, destintion);
		edges.addElement(edge);
		return edge;
	}

	@Override
	public boolean hasVertex(Vertex<T> vertex) {
		for (Enumeration<Vertex<T>> e = verticies.elements(); e.hasMoreElements();) {
			Vertex<T> v = e.nextElement();
			if (v.equals(vertex)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Iterator<Vertex<T>> verticies() {
		return verticies.iterator();
	}

	@Override
	public Set<Vertex<T>> getNeighbors(String vertex) {
		Set<Vertex<T>> res = new HashSet<Vertex<T>>();
		Enumeration<Edge<T>> edgeEnum = edges.elements();

		while (edgeEnum.hasMoreElements()) {
			Edge<T> e = edgeEnum.nextElement();

			if (e.getSource().equals(vertex)) {
				res.add(e.getDestination());
			} else if (e.getDestination().equals(vertex)) {
				res.add(e.getSource());
			}
		}

		return res;
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("\"Graph\" : {\n");
		buff.append("\t\"Verticies\" : [\n");
		for (Enumeration<Vertex<T>> e = verticies.elements(); e.hasMoreElements();) {
			buff.append("\t\t").append(e.nextElement()).append('\n');
		}
		buff.append("\t],\n\t\"Edges\" : [\n");
		for (Enumeration<Edge<T>> e = edges.elements(); e.hasMoreElements();) {
			buff.append("\t\t").append(e.nextElement()).append('\n');
		}
		return buff.append("\t]\n}").toString();
	}

	public static void main(String[] args) {
		Graph<String> g = new GraphImpl<>();

		Vertex<String> a = new VertexImpl<String>("A");
		Vertex<String> b = new VertexImpl<String>("B");
		Vertex<String> c = new VertexImpl<String>("C");
		Vertex<String> d = new VertexImpl<String>("D");
		Vertex<String> e = new VertexImpl<String>("E");
		Vertex<String> f = new VertexImpl<String>("F");

		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addVertex(e);
		g.addVertex(f);

		g.addEdge(a, b);
		g.addEdge(b, c);
		g.addEdge(b, d);
		g.addEdge(c, e);
		g.addEdge(f, a);

		System.out.println(g);
	}
}
