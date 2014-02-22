package vis.graph.visgraph.core.ifc;

import java.awt.geom.Point2D;

public interface Vertex<T> {
	public T getData();
	public void setData(T data);
	
	public Point2D.Double getPoint();
	public void setPoint(Point2D.Double point);
}
