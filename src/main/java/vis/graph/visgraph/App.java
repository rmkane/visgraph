package vis.graph.visgraph;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import vis.graph.visgraph.components.GraphPanel;
import vis.graph.visgraph.core.ifc.Graph;
import vis.graph.visgraph.core.ifc.Vertex;
import vis.graph.visgraph.core.ui.UIGraph;
import vis.graph.visgraph.core.ui.UIVertex;

public class App extends JFrame {
	private static final long serialVersionUID = 949744218770101004L;
	private static final String TITLE = "Graphing in Java";

	private GraphPanel<String> graphPanel;

	public App(String title) {
		graphPanel = new GraphPanel<String>(600, 400);

		setUpGraph();

		setTitle(title);
		setContentPane(graphPanel);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void setUpGraph() {
		Graph<String> g = graphPanel.getGraph();

		int size = 50;

		Vertex<String> a = new UIVertex<String>("A", 250, 50, size);
		Vertex<String> b = new UIVertex<String>("B", 150, 150, size);
		Vertex<String> c = new UIVertex<String>("C", 350, 250, size);
		Vertex<String> d = new UIVertex<String>("D", 150, 250, size);
		Vertex<String> e = new UIVertex<String>("E", 250, 350, size);
		Vertex<String> f = new UIVertex<String>("F", 350, 150, size);

		((UIGraph<String>) g).addVertex(a);
		((UIGraph<String>) g).addVertex(b);
		((UIGraph<String>) g).addVertex(c);
		((UIGraph<String>) g).addVertex(d);
		((UIGraph<String>) g).addVertex(e);
		((UIGraph<String>) g).addVertex(f);

		((UIGraph<String>) g).addEdge(a, b);
		((UIGraph<String>) g).addEdge(b, c);
		((UIGraph<String>) g).addEdge(b, d);
		((UIGraph<String>) g).addEdge(c, e);
		((UIGraph<String>) g).addEdge(f, a);

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
