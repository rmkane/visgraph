package vis.graph.visgraph.core.utils;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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
		int x, y, w, h;
		if (p1.x <= p2.x) {
			x = (int) p1.x;
			w = (int) (Math.ceil(p2.x) - p1.x);
		} else {
			x = (int) p2.x;
			w = (int) (Math.ceil(p1.x) - p2.x);
		}
		if (p1.y <= p2.y) {
			y = (int) p1.y;
			h = (int) (Math.ceil(p2.y) - p1.y);
		} else {
			y = (int) p2.y;
			h = (int) (Math.ceil(p1.y) - p2.y);
		}
		return new Rectangle(x, y, w, h);
	}



	public static Rectangle2D computeBounds2D(Point2D.Double p1, Point2D.Double p2) {
		return new Line2D.Double(p1, p2).getBounds2D();
	}

	public static void main(String[] args) {
		Point2D.Double p1 = null;
		Point2D.Double p2 = null;
		Rectangle2D bounds = null;
		double scale = 10.0d;
		int v[] = {
				+1, +1, -1, +1,
				-1, +1, -1, -1,
				-1, -1, +1, -1,
				+1, -1, +1, +1,
				+1, +1, -1, -1,
				-1, +1, +1, -1 };

		for (int i = 0; i < v.length; i += 4) {
			p1 = new Point2D.Double(v[i+0] * scale, v[i+1] * scale);
			p2 = new Point2D.Double(v[i+2] * scale, v[i+3] * scale);
			bounds = computeBounds2D(p1, p2);

			System.out.println(bounds);

		}
	}
}
