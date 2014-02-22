package vis.graph.visgraph;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import vis.graph.visgraph.components.GraphPanel;
import vis.graph.visgraph.core.ifc.Graph;
import vis.graph.visgraph.core.ifc.Vertex;
import vis.graph.visgraph.core.ui.UIVertex;

public class App extends JFrame {
	private static final long serialVersionUID = 949744218770101004L;
	private static final String TITLE = "Graphing in Java";

	private GraphPanel<String> graphPanel;

	public App(String title) {
		graphPanel = new GraphPanel<String>();

		setUpGraph();

		setTitle(title);
		setContentPane(graphPanel);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void setUpGraph() {
		Graph<String> g = graphPanel.getGraph();

		Vertex<String> a = new UIVertex<String>("A", 100, 25, 10);
		Vertex<String> b = new UIVertex<String>("B", 75, 50, 10);
		Vertex<String> c = new UIVertex<String>("C", 60, 75, 10);
		Vertex<String> d = new UIVertex<String>("D", 90, 75, 10);
		Vertex<String> e = new UIVertex<String>("E", 75, 100, 10);
		Vertex<String> f = new UIVertex<String>("F", 125, 50, 10);

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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				App app = new App(TITLE);

				app.setVisible(true);
			}
		});
	}
}
