package vis.graph.visgraph.components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import vis.graph.visgraph.core.ifc.Graph;
import vis.graph.visgraph.core.ui.UIGraph;

public class GraphPanel<T> extends JPanel {
	private static final long serialVersionUID = -5487092989303271440L;

	private Graph<T> graph;

	public GraphPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));

		graph = new UIGraph<T>(width, height);
		add((UIGraph<T>) graph);
	}

	public Graph<T> getGraph() {
		return graph;
	}

	public void setGraph(Graph<T> graph) {
		this.graph = graph;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		//((UIGraph<T>) graph).paint(g);
	}
}
