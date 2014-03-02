package vis.graph.visgraph.components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vis.graph.visgraph.core.ifc.Graph;
import vis.graph.visgraph.core.ui.UIGraph;

public class GraphPanel<T> extends JPanel {
	private static final long serialVersionUID = -5487092989303271440L;

	private Graph<T> graph;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private Font titleFont;

	public GraphPanel(int width, int height) {
		super(new BorderLayout());

		titlePanel = new JPanel();
		titleFont = new Font("Arial", Font.BOLD, 24);
		titleLabel = new JLabel("Graph UI Example");

		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.WHITE);

		titlePanel.setBackground(Color.BLACK);
		titlePanel.add(Box.createHorizontalGlue());
		titlePanel.add(titleLabel);
		titlePanel.add(Box.createHorizontalGlue());
		add(titlePanel, BorderLayout.NORTH);

		graph = new UIGraph<T>(width, height);
		add((UIGraph<T>) graph, BorderLayout.SOUTH);
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
	}
}
