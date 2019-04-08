package Objects3D;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class LensFlare extends Dot
{
	public LensFlare(Point3D location) 
	{
		super(location);
		
	}
	public void draw(Graphics g, Point location, Panel3D panel, double size)
	{
		final int pixelSize = 3;
		final double intensityConstant = (size / 2) * (size / 2);
		for (int x = 0; x < panel.getWidth(); x+= pixelSize)
		{
			for (int y = 0; y < panel.getHeight(); y+= pixelSize)
			{
				double r = location.distance(x + pixelSize / 2, y + pixelSize / 2);
				double brightness = intensityConstant / (r * r);
				g.setColor(new Color(255, 255, 255));
				if (brightness > 0.015 && (brightness < 1.2 || size < 60))
				{
					if (brightness > 1)
					{
						brightness = 1;
					}
					((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
							(float) (brightness)));
					g.fillRect(x, y, pixelSize, pixelSize);
					
				}
			}
		}
		((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				(float) (1)));
		g.fillOval((int) (location.x - size / 2.0), (int) (location.y - size / 2.0), (int)size, (int)size);
	}
}
