package Objects3D;

import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.Button;
import ui.Control;
import ui.Label;
import ui.Page;
import ui.RadioButton;
import ui.TextBox;

public class Panel3D extends JPanel implements MouseMotionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Angle3D perspectiveAngle = new Angle3D(0, 0);
	double FOV = 2000;
	Point3D perspectiveLocation = new Point3D();
	private ArrayList<Control3D> controls = new ArrayList<Control3D>(); // list will have to be sorted so that controls earlier in the list are closer to the perspective.
	ArrayList<Double> controlDistances = new ArrayList<Double>();
	ArrayList<DotDrawing> drawingDots = new ArrayList<DotDrawing>();
	double planeI;
	double planeJ;
	double planeK;
	double planeTotal;
	Point3D panelTopLeft;
	Point3D panelTopCenter;
	Point3D panelBottomCenter;
	Point3D panelBottomRight;
	
	boolean mouseLocked = false;
	
	boolean paint = false;
	boolean stars = false;
	boolean sun = true;
	boolean saturn = false;
	
	Page menu;
	Label setCalculationLabel;
	Label menuLabel;
	Label specialSettingsLabel;
	Label backLabel;
	Label zLabel, rangeLabel, xMinLabel, xMaxLabel, yMinLabel, yMaxLabel, zMinLabel, zMaxLabel;
	RadioButton starsRadioButton;
	RadioButton sunRadioButton;
	RadioButton saturnRadioButton;
	TextBox zTextBox, xMinTextBox, xMaxTextBox, yMinTextBox, yMaxTextBox, zMinTextBox, zMaxTextBox;
	Button calculateButton;
	
	public Panel3D()
	{
		this.addMouseMotionListener(this);
	}
	public boolean dispose(Control3D control)
	{
		controlDistances.remove(controls.indexOf(control));
		return controls.remove(control);
	}
	public void disposeAll()
	{
		controls.clear();
		controlDistances.clear();
	}
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, getWidth(), getHeight());
		Point3D center = new Point3D(0,0,0).getPointAt(perspectiveAngle, FOV);
		Point3D topCenter = center.getPointAt(new Angle3D(perspectiveAngle.horizontal, perspectiveAngle.vertical + Math.PI / 2.0), getHeight() / 2.0);
		Point3D topLeft = topCenter.getPointAt(new Angle3D(perspectiveAngle.horizontal + Math.PI / 2.0, 0), getWidth() / 2.0);
		panelBottomCenter = center.getPointAt(new Angle3D(perspectiveAngle.horizontal, perspectiveAngle.vertical - Math.PI / 2.0), getHeight() / 2.0);
		panelBottomRight = panelBottomCenter.getPointAt(new Angle3D(perspectiveAngle.horizontal - Math.PI / 2.0, 0), getWidth() / 2.0);
		panelTopLeft = new Point3D(topLeft);
		panelTopCenter = new Point3D(topCenter);
		{
			// Assembling a matrices to find the equation for the plane in which represents the computer screen.
			double a = center.x - topCenter.x;// i j k
			double b = center.y - topCenter.y;// a b c
			double c = center.z - topCenter.z;// d e f
		
			double d = center.x - topLeft.x;
			double e = center.y - topLeft.y;
			double f = center.z - topLeft.z;
		
			double i = b * f - e * c; // Find the derivatives
			double j = - (a * f - c * d);
			double k = a * e - b * d;
		
			double total = i * center.x + j * center.y + k * center.z;
		
			planeI = i;
			planeJ = j;
			planeK = k;
			planeTotal = total;
		}
		
		//System.out.println(getWidth() + " " + getHeight());
		//System.out.println(center + ", " + topCenter + ", " + topLeft);
		//System.out.println(planeI + " " + planeJ + " " + planeK + " " + planeTotal);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawingDots.clear();
		for (int i = controls.size() - 1; i > -1; i--)
		{
			controls.get(i).paint(g);
		}
		for (DotDrawing d : drawingDots)
		{
			int complete = 0;
			ArrayList<MultiDotObject> containers = new ArrayList<MultiDotObject>();
			if (d.container == null)
			{
				d.paint(g, this);
			}
			else
			{
				d.container.tempIndex = containers.size();
			}
		}
		menu.setLocation(new Point(getWidth() / 2 - 300, getHeight() / 2 - 335));
		Control.paintControls(this, g);
	}
	public void sortControls()
	{
		ArrayList<Control3D> newControls = new ArrayList<Control3D>();
		ArrayList<Double> newDistances = new ArrayList<Double>();
		ArrayList<Double> altDistances = new ArrayList<Double>();
		for (int i = 0; i < controls.size(); i++)
		{
			Control3D control = controls.get(i);
			double xDif = perspectiveLocation.x - control.location.x;
			double yDif = perspectiveLocation.y - control.location.y;
			double zDif = perspectiveLocation.z - control.location.z;
			altDistances.add(Math.sqrt((xDif * xDif) + (yDif * yDif) + (zDif * zDif)));
		}
		for (int i = 0; i < controls.size(); i++)
		{
			int x;
			for (x = 0; x < newControls.size(); x++)
			{
				if (altDistances.get(i) < newDistances.get(x))
				{
					break;
				}
			}
			newControls.add(x, controls.get(i));
			newDistances.add(x, altDistances.get(i));
		}
		controls = newControls;
		controlDistances = newDistances;
		System.out.println(controls.size());
	}
	public void addControl3D(Control3D control)
	{
		if (control.getClass() == Plane.class)
		{
			Plane plane = (Plane) control;
			for (int i = 0; i < plane.dots.length; i++)
			{
				addControl3D(plane.dots[i]);
				control.panel = this;
			}
		}
		else
		{
			double xDif = perspectiveLocation.x - control.location.x;
			double yDif = perspectiveLocation.y - control.location.y;
			double zDif = perspectiveLocation.z - control.location.z;
			double radius = Math.sqrt((xDif * xDif) + (yDif * yDif) + (zDif * zDif));
			int i = 0;
			while (i < controlDistances.size())
			{
				if (controlDistances.get(i) > radius)
				{
					break;
				}
				i++;
			}
			controls.add(i, control);
			controlDistances.add(i, radius);
			control.panel = this;
		}
	}
	public void addDotDrawing(DotDrawing control)
	{
		int i = 0;
		while (i < drawingDots.size())
		{
			if (drawingDots.get(i).radius < control.radius)
			{
				break;
			}
			i++;
		}
		drawingDots.add(i, control);
	}
	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
		if (mouseLocked)
		{
			Point p = this.getLocationOnScreen();
			int x = MouseInfo.getPointerInfo().getLocation().x - p.x;
			int y = MouseInfo.getPointerInfo().getLocation().y - p.y;
			perspectiveAngle.horizontal-= (x - (int) (this.getWidth() / 2)) / 1000.0;
			perspectiveAngle.vertical-= (y - (int) (this.getHeight() / 2)) / 1000.0;
			try {
				Robot r = new Robot();
				r.mouseMove((int)(p.x + this.getWidth() / 2), (int) ( p.y + this.getHeight() / 2));
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addMouseListener()
	{
		this.addMouseListener(new PanelListener(this));
	}
	public class PanelListener extends MouseAdapter
	{
		boolean mousePressed = false;
		int mX = 0;
		int mY = 0;
		Panel3D panel = new Panel3D();
		public PanelListener(Panel3D panel)
		{
			this.panel = panel;
		}
		public void mousePressed(MouseEvent e)
		{
			mX = e.getX();
			mY = e.getY();
			Control.controlClickEvents(panel, mX, mY, true);
			mousePressed = true;
		}
		public void mouseReleased(MouseEvent e)
		{
			mousePressed = false;
			if (mX == e.getX() && mY == e.getY() && !mouseLocked)
			{
				//
			}
		}
	}
}
