package vis.graph.visgraph.core.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

import vis.graph.visgraph.core.ifc.Vertex;
import vis.graph.visgraph.core.impl.VertexImpl;
import vis.graph.visgraph.core.utils.UIUtils;

public class UIVertex<T> extends JComponent implements Vertex<T>, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 9168220709643204176L;

	private Vertex<T> vertex;

	boolean dragging = false;

	private static final Font font = new Font("Arial", Font.BOLD, 30);

	public UIVertex(T data, double x, double y, int size) {
		super();

		vertex = new VertexImpl<T>(data, x, y);
		setPreferredSize(new Dimension(size, size));

		addMouseListener(this);
		addMouseMotionListener(this);
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
		g.fillOval(b.x, b.y, b.width, b.height);

		g.setColor(Color.BLUE);
		g.drawOval(b.x, b.y, b.width, b.height);

		drawStringCentered(g, font, vertex.getData().toString(), b.x, b.y);
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
	public String toString() {
		return vertex.toString();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("MOUSE CLICKED");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		dragging = true;
		System.out.println("MOUSE PRESSED");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragging = false;
		System.out.println("MOUSE RELEASED");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("MOUSE ENTERED");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("MOUSE EXITED");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (dragging) {
			vertex.setPoint(new Point2D.Double(e.getPoint().x, e.getPoint().y));
			repaint();
		}
		System.out.println("MOUSE DRAGGED");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("MOUSE MOVED");
	}
}
