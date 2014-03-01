package vis.graph.visgraph.core.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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

	boolean dragging = false;

	private static final Font font = new Font("Arial", Font.BOLD, 30);

	public UIVertex(T data, double x, double y, int size) {
		super();

		vertex = new VertexImpl<T>(data, x, y);

		setBounds((int) x - size / 2, (int) y - size / 2, size, size);
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

		g.setColor(Color.WHITE);
		g.fillOval(0, 0, b.width - 1, b.height - 1);

		g.setColor(Color.BLUE);
		g.drawOval(0, 0, b.width - 1, b.height - 1);

		drawStringCentered(g, font, vertex.getData().toString(), 0, 0);

		g.dispose();
	}

	public void drawStringCentered(Graphics g, Font font, String text, int x, int y) {
		g.setFont(font);

		FontMetrics metrics = g.getFontMetrics();
		int width = getWidth() / 2;
		int height = getHeight() / 2;
		int width2 = metrics.stringWidth(text) / 2;
		int height2 = metrics.getMaxAscent() / 2;

		g.drawString(text, x + width - width2, y + height + height2);
	}

	@Override
	public void setLocation(int x, int y) {
		super.setLocation(x, y);

		vertex.getPoint().setLocation(x + getWidth() / 2, y + getHeight() / 2);
	}

	@Override
	public String toString() {
		return vertex.toString();
	}
}
