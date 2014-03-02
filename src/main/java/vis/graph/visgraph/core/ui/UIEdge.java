package vis.graph.visgraph.core.ui;

import java.awt.BasicStroke;
import java.awt.Color;
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
	private int lineWidth = 5;

	public UIEdge(Vertex<T> source, Vertex<T> destination) {
		super();

		this.edge = new EdgeImpl<T>(source, destination);

		setBounds();
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

	private void setBounds() {
		int lWidth = lineWidth * 2;
		Rectangle2D bounds = UIUtils.computeBounds2D(
				getSource().getPoint(), getDestination().getPoint());
		int width = bounds.getWidth() <= lWidth ? lWidth: (int) bounds.getWidth();
		int height = bounds.getHeight() <= lWidth ? lWidth : (int) bounds.getHeight();

		setBounds((int) bounds.getX(), (int) bounds.getY(), width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Point src = UIUtils.getPoint(getSource());
		Point dest = UIUtils.getPoint(getDestination());

		setBounds();

		Graphics2D g2d = (Graphics2D) g;

		int x1, x2 = 0;
		if (src.x < Math.ceil(dest.x)) {
			x1 = 0;
			x2 = (int) getBounds().getWidth();
		} else {
			x1 = (int) getBounds().getWidth();
			x2 = 0;
		}
		int y1, y2 = 0;
		if (src.y < Math.ceil(dest.y)) {
			y1 = 0;
			y2 = (int) getBounds().getHeight();
		} else {
			y1 = (int) getBounds().getHeight();
			y2 = 0;
		}

		g.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(1));
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

		g.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.drawLine(x1, y1, x2, y2);
		g.dispose();
	}

	@Override
	public String toString() {
		return edge.toString();
	}
}