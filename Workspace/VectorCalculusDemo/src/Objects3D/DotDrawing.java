package Objects3D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class DotDrawing {
	Point location;
	int size;
	Color color;
	double radius;
	MultiDotObject container;
	Dot dot;
	boolean observatorium = false;
	public DotDrawing(Point location, int size, Color color, double radius, MultiDotObject container, Dot dot, boolean observatorium)
	{
		this.location = location;
		this.size = size;
		this.color = color;
		this.radius = radius;
		this.container = container;
		this.dot = dot;
		this.observatorium = observatorium;
	}
	public void paint(Graphics g, Panel3D panel)
	{
		if (dot.getClass() == LensFlare.class)
		{
			((LensFlare) dot).draw(g, location, panel, size);
		}
		else
		{
			if (!observatorium)
			{
				g.setColor(color);
				g.fillOval((int) (location.x - size / 2.0), (int) (location.y - size / 2.0), size, size);
			}
			else
			{
				size*=1.5;
				g.setColor(color);
				g.setFont(new Font("Times New Roman", Font.BOLD, 10));
				int length = g.getFontMetrics().stringWidth("Observatorium");
				g.setFont(new Font("Times New Roman", Font.BOLD, (int) (10.0 * size / length)));
				length = g.getFontMetrics().stringWidth("Observatorium");
				g.drawString("Observatorium", (int) (location.x - length / 2.0), (int) (location.y - 10 * size / length/ 2.0));
			}
		}
	}
}
