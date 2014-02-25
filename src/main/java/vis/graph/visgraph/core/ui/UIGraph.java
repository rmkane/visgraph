package vis.graph.visgraph.core.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JPanel;

import vis.graph.visgraph.core.ifc.Edge;
import vis.graph.visgraph.core.ifc.Graph;
import vis.graph.visgraph.core.ifc.Vertex;
import vis.graph.visgraph.core.impl.GraphImpl;

public class UIGraph<T> extends JPanel implements Graph<T> {
	private static final long serialVersionUID = 3953155966661463983L;

	private Graph<T> graph;

	public UIGraph(int width, int height) {
		graph = new GraphImpl<T>();

		setPreferredSize(new Dimension(width, height));
	}

	@Override
	public Vector<Vertex<T>> getVerticies() {
		return graph.getVerticies();
	}

	@Override
	public void setVerticies(Vector<Vertex<T>> verticies) {
		graph.setVerticies(verticies);
	}

	@Override
	public Vector<Edge<T>> getEdges() {
		return graph.getEdges();
	}

	@Override
	public void setEdges(Vector<Edge<T>> edges) {
		graph.setEdges(edges);
	}

	@Override
	public Vertex<T> addVertex(T data, Point2D.Double point) {
		return addVertex(new UIVertex<T>(data, point.x, point.y, 10));
	}

	@Override
	public Vertex<T> addVertex(Vertex<T> vertex) {
		Vertex<T> v = graph.addVertex(vertex);
		add((UIVertex<T>) v);
		return v;
	}

	@Override
	public Edge<T> addEdge(Vertex<T> source, Vertex<T> destination) {
		Edge<T> edge = new UIEdge<T>(source, destination);
		graph.getEdges().addElement(edge);
		add((UIEdge<T>) edge);
		return edge;
	}

	@Override
	public boolean hasVertex(Vertex<T> vertex) {
		return graph.hasVertex(vertex);
	}

	@Override
	public Iterator<Vertex<T>> verticies() {
		return graph.verticies();
	}

	@Override
	public Set<Vertex<T>> getNeighbors(String vertex) {
		return graph.getNeighbors(vertex);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (Enumeration<Edge<T>> e = graph.getEdges().elements(); e.hasMoreElements();) {
			((UIEdge<T>) e.nextElement()).paint(g);
		}

		for (Enumeration<Vertex<T>> e = graph.getVerticies().elements(); e.hasMoreElements();) {
			((UIVertex<T>) e.nextElement()).paint(g);
		}
	}

	@Override
	public String toString() {
		return graph.toString();
	}
}
