package vis.graph.visgraph.core.impl;

import vis.graph.visgraph.core.ifc.Edge;
import vis.graph.visgraph.core.ifc.Vertex;

public class EdgeImpl<T> implements Edge<T> {
	private Vertex<T> source, destination;

	@Override
	public Vertex<T> getSource() {
		return source;
	}

	@Override
	public void setSource(Vertex<T> source) {
		this.source = source;
	}

	@Override
	public Vertex<T> getDestination() {
		return destination;
	}

	@Override
	public void setDestination(Vertex<T> destination) {
		this.destination = destination;
	}

	public EdgeImpl(Vertex<T> source, Vertex<T> destination) {
		this.source = source;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return String.format("EDGE(%s -> %s)", source, destination);
	}
}
