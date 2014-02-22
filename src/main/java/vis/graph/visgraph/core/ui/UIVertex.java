package vis.graph.visgraph.core.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

import vis.graph.visgraph.core.ifc.Vertex;
import vis.graph.visgraph.core.impl.VertexImpl;
import vis.graph.visgraph.core.utils.UIUtils;

public class UIVertex<T> extends JComponent implements Vertex<T> {
	private static final long serialVersionUID = 9168220709643204176L;

	private Vertex<T> vertex;

	public UIVertex(T data, double x, double y, int size) {
		super();

		vertex = new VertexImpl<T>(data, x, y);
		setPreferredSize(new Dimension(size, size));
	}

	@Override
	public T getData() {
		return vertex.getData();
	}

	@Override
	public void setData(T data) {
		vertex.setData(data);
	}

	@Override
	public Point2D.Double getPoint() {
		return vertex.getPoint();
	}

	@Override
	public void setPoint(Point2D.Double point) {
		vertex.setPoint(point);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Rectangle b = UIUtils.getBounds(this);


		g.setColor(Color.BLUE);
		g.drawOval(b.x, b.y, b.width, b.height);
	}

	@Override
	public String toString() {
		return vertex.toString();
	}
}
