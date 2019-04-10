package ui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Button extends Label
{
	public Color borderColor = new Color(0, 0, 0);
	public Color backgroundColor = new Color(255, 255, 255);
	protected BufferedImage textPlane;
	public boolean rounded = false;
	public int roundedHeight = 5, roundedWidth = 5;
	public int borderStroke = 3;
	public int backgroundVisibility = 1;
	public Button(String text, int width, int height, JPanel panel, Point location) 
	{
		super(text, panel, location);
		this.width = width;
		this.height = height;
		clickBox = new Polygon();
		clickBox.addPoint(location.x, location.y);
		clickBox.addPoint(location.x + width, location.y);
		clickBox.addPoint(location.x + width, location.y + height);
		clickBox.addPoint(location.x, location.y + height);
	}
	public void paint(Graphics g)
	{
		if (visible)
		{
			((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					(float) (visibility)));
			if (antialiasing)
			{
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			}
			else
			{
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			}
			g.setColor(backgroundColor);
			((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					(float) (visibility * backgroundVisibility)));
			if (rounded)
			{

				g.fillRoundRect(location.x, location.y, width, height, roundedWidth, roundedHeight);
			}
			else
			{

				g.fillRect(location.x, location.y, width, height);
			}
			((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					(float) (visibility)));
			((Graphics2D) g).setStroke(new BasicStroke(borderStroke));
			g.setColor(borderColor);
			if (rounded)
			{
				g.drawRoundRect(location.x, location.y, width, height, roundedWidth, roundedHeight);
			}
			else
			{
				g.drawRect(location.x, location.y, width, height);
			}
			((Graphics2D) g).setStroke(new BasicStroke(1));
			super.paint(g);
			g = null;
		}
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public void setFont(Font font)
	{
		this.font = font;
	}
}

