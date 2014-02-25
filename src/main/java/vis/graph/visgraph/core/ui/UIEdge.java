package vis.graph.visgraph.core.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import vis.graph.visgraph.core.ifc.Edge;
import vis.graph.visgraph.core.ifc.Vertex;
import vis.graph.visgraph.core.impl.EdgeImpl;
import vis.graph.visgraph.core.utils.UIUtils;

public class UIEdge<T> extends JComponent implements Edge<T> {
	private static final long serialVersionUID = -394305098662180100L;

	private Edge<T> edge;

	public UIEdge(Vertex<T> source, Vertex<T> destination) {
		super();

		this.edge = new EdgeImpl<T>(source, destination);

		Rectangle2D bounds = UIUtils.computeBounds2D(
				source.getPoint(), destination.getPoint());

		setPreferredSize(new Dimension((int) bounds.getX(), (int) bounds.getY()));
	}

	@Override
	public Vertex<T> getSource() {
		return edge.getSource();
	}

	@Override
	public void setSource(Vertex<T> source) {
		edge.setSource(source);
	}

	@Override
	public Vertex<T> getDestination() {
		return edge.getDestination();
	}

	@Override
	public void setDestination(Vertex<T> destination) {
		edge.setDestination(destination);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		Point src = UIUtils.getPoint(getSource());
		Point dest = UIUtils.getPoint(getDestination());

		g2d.setStroke(new BasicStroke(5));

		g.setColor(Color.RED);
		g2d.drawLine(src.x, src.y, dest.x, dest.y);
	}

	@Override
	public String toString() {
		return edge.toString();
	}
}