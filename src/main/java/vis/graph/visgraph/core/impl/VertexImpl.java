package vis.graph.visgraph.core.impl;

import java.awt.geom.Point2D;

import vis.graph.visgraph.core.ifc.Vertex;

public class VertexImpl<T> implements Vertex<T> {
	private T data;
	private Point2D.Double point;

	public VertexImpl(T data) {
		this(data, 0, 0);
	}

	public VertexImpl(T data, double x, double y) {
		this(data, new Point2D.Double(x, y));
	}

	public VertexImpl(T data, Point2D.Double point) {
		this.data = data;
		this.point = point;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public Point2D.Double getPoint() {
		return point;
	}

	@Override
	public void setPoint(Point2D.Double point) {
		this.point = point;
	}

	@Override
	public Vertex<T> clone() {
		return new VertexImpl<T>(data, point.x, point.y);
	}

	@Override
	public boolean equals(Object vertex) {
		if (vertex instanceof Vertex<?>) {
			@SuppressWarnings("unchecked")
			Vertex<T> v = (Vertex<T>) vertex;

			return data == v.getData() && point.equals(v.getPoint());
		}

		return false;
	}

	@Override
	public String toString() {
		return String.format("VERTEX(%s, POINT(%.2f, %.2f))", data, point.x, point.y);
	}
}
