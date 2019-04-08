package Objects3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DotDrawing {
	Point location;
	int size;
	Color color;
	double radius;
	MultiDotObject container;
	Dot dot;
	public DotDrawing(Point location, int size, Color color, double radius, MultiDotObject container, Dot dot)
	{
		this.location = location;
		this.size = size;
		this.color = color;
		this.radius = radius;
		this.container = container;
		this.dot = dot;
	}
	public void paint(Graphics g, Panel3D panel)
	{
		if (dot.getClass() == LensFlare.class)
		{
			((LensFlare) dot).draw(g, location, panel, size);
		}
		else
		{
			g.setColor(color);
			g.fillOval((int) (location.x - size / 2.0), (int) (location.y - size / 2.0), size, size);
		}
	}
}
