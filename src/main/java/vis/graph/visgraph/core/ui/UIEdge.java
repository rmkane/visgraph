package vis.graph.visgraph.core.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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

		setBounds(UIUtils.computeBounds(source.getPoint(), destination.getPoint()));
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

		Point src = UIUtils.getPoint(getSource());
		Point dest = UIUtils.getPoint(getSource());

		g.setColor(Color.RED);
		g.drawLine(src.x, src.y, dest.x, dest.y);
	}

	@Override
	public String toString() {
		return edge.toString();
	}
}