package vis.graph.visgraph.core.utils;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import vis.graph.visgraph.core.ifc.Vertex;
import vis.graph.visgraph.core.ui.UIVertex;

public class UIUtils {
	public static <T> Point getPoint(Vertex<T> vertex) {
		return new Point((int) vertex.getPoint().getX(),
				(int) vertex.getPoint().getY());
	}

	public static <T> Rectangle getBounds(UIVertex<T> vertex) {
		Point p = getPoint(vertex);

		p.x -= (vertex.getWidth() / 2);
		p.y -= (vertex.getHeight() / 2);

		return new Rectangle(p.x, p.y, vertex.getWidth(), vertex.getHeight());
	}

	public static Rectangle computeBounds(Point2D.Double p1, Point2D.Double p2) {
		double dx = p2.x - p1.x;
		double dy = p2.y - p1.y;

		int x = (int) (dx < 0 ? p2.x : p1.x);
		int y = (int) (dy < 0 ? p2.y : p1.y);
		int w = (int) Math.abs(dx);
		int h = (int) Math.abs(dy);

		return new Rectangle(x, y, w, h);
	}

	public static void main(String[] args) {
		Point2D.Double p1 = null;
		Point2D.Double p2 = null;
		Rectangle bounds = null;
		int s = 40;
		int v[] = {
				+1, +1, -1, +1,
				-1, +1, -1, -1,
				-1, -1, +1, -1,
				+1, -1, +1, +1,
				+1, +1, -1, -1,
				-1, +1, +1, -1 };

		for (int i = 0; i < v.length; i += 4) {
			p1 = new Point2D.Double(v[i+0] * s, v[i+1] * s);
			p2 = new Point2D.Double(v[i+2] * s, v[i+3] * s);
			bounds = computeBounds(p1, p2);

			System.out.println(bounds);

		}
	}
}
