package Objects3D;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import ui.Page;
import ui.Control;
import ui.ControlHandler;
import ui.Label;

public class Test {
	static boolean stars = false;
	static boolean sun = false;
	static boolean saturn = false;
	public static void main(String[] args)
	{
		JFrame Screen = new JFrame();
		Screen.setTitle("Conquer");
		Screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel3D panel = new Panel3D();
		Screen.setSize(1600, 800);
		panel.setBackground(new Color(0, 0, 0));
		Screen.setBackground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		final int wavelength = 90;
		final int width = 100;
		Dot[] dots = new Dot[width * width];//100001];
		///*
		for (double k = 0; k < width * width; k+= 1)
		{
			double x = k % width * wavelength - width * wavelength / 2 - 20;
			double y = (int)(k / width) * wavelength - width * wavelength / 2 - 20;
			double sineSwitch = Math.cos(k * 12324515131.1564) / Math.abs(Math.cos(k * 12324515131.1564));
			Dot a = new Dot(new Point3D(x, y, 1000 * Math.pow(Math.cos(x / 1000),2) * Math.pow(Math.cos(y / 1000), 2)));
			a.radius = 40;
			a.color = new Color((int) (200),(int) (0),(int) (200));
			panel.addControl3D(a);
			dots[(int)k] = a;
		}
		/*
		new Timer().scheduleAtFixedRate(new TimerTask()
		{
			double radiusTurn = 0;
			public void run()
			{
				radiusTurn-= Math.PI / 300;
				for (double k = -0; k < width * width; k+= 2)
				{
					//dots[(int)k].location = new Point3D(Math.sin(k / 10 + radiusTurn) * k / 10, k - 10000, Math.sin(k / 10 - Math.PI / 2 + radiusTurn) * k / 10);
					double xOffset = 0;
					double yOffset = 0;
					double distance = Math.sqrt((Math.sin(k / 10) * k - xOffset) * (Math.sin(k / 10) * k - xOffset) + (Math.sin(k / 10 - Math.PI / 2) * k - yOffset) * (Math.sin(k / 10 - Math.PI / 2) * k - yOffset));
					//dots[(int)k].location = new Point3D(Math.sin(k / 10) * k, Math.sin(k / 10 - Math.PI / 2) * k, Math.cos(Math.sqrt((Math.sin(k / 10) * k - xOffset) * (Math.sin(k / 10) * k - xOffset) + (Math.sin(k / 10 - Math.PI / 2) * k - yOffset) * (Math.sin(k / 10 - Math.PI / 2) * k - yOffset)) / 400 + radiusTurn) * 800000 / Math.pow(distance, 1) );
					double sineSwitch = Math.cos(k * 12324515131.1564) / Math.abs(Math.cos(k * 12324515131.1564));
					double x = k % width * wavelength - width * wavelength / 2 - 20;
					double y = (int)(k / width) * wavelength - width * wavelength / 2 - 20;
					dots[(int)k].location = new Point3D(new Point3D(x, y + 5000, sineSwitch * Math.sqrt(-500000 * Math.cos(radiusTurn) + x * x + y * y)));
				}
				Screen.repaint();
			}
		}
		, 10, 10);
		*/
		if (saturn)
		{
			for (double k = 0; k <= 2500; k+= 1)
			{
				Dot a = new Dot(new Point3D( Math.cos(k / 20) * (int)(k / 40 / Math.PI + 40) * 50, Math.sin(k / 20) * (int)(k / 40 / Math.PI + 40) * 50 + 100000, -5000));
				a.radius = 200;
				a.color = new Color((int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100);
				panel.addControl3D(a);
			}
		}
		if (stars)
		{
			for (double k = 0; k <= 25000; k+= 1)
			{
				double angleHorizontal = Math.random() * 2 * Math.PI;
				double angleVertical = Math.random() * 2 * Math.PI;
				Point3D starLocation = new Point3D(0, 0, 0).getPointAt(new Angle3D(angleHorizontal, angleVertical), 20000000);
				Dot a = new Dot(starLocation);
				a.radius = 50000 + Math.random() * 30000;
				a.color = new Color((int) (Math.random() * 56) + 200, 255,(int) (Math.random() * 56) + 200);
				panel.addControl3D(a);
			}
		}
		int cubeDotDistance = 20;
		int cubeDistance = 8000;
		for (int y = -200; y < 200; y+=cubeDotDistance)
		{
			for (int z = -200; z < 200; z+=cubeDotDistance)
			{
				Dot a = new Dot(new Point3D(1000 + cubeDistance, y, z));
				a.color = new Color((int) (255),(int) (0),(int) (0));
				panel.addControl3D(a);
			}
		}
		
		for (int x = 1000; x < 1400; x+=cubeDotDistance)
		{
			for (int z = -200; z < 200; z+=cubeDotDistance)
			{
				Dot a = new Dot(new Point3D(x + cubeDistance, 200, z));
				a.color = new Color((int) (0),(int) (255),(int) (0));
				panel.addControl3D(a);
			}
		}
		
		for (int x = 1000; x < 1400; x+=cubeDotDistance)
		{
			for (int z = -200; z < 200; z+=cubeDotDistance)
			{
				Dot a = new Dot(new Point3D(x + cubeDistance, - 200, z));
				a.color = new Color((int) (0),(int) (0),(int) (255));
				panel.addControl3D(a);
			}
		}
		
		for (int y = -200; y < 200; y+=cubeDotDistance)
		{
			for (int z = -200; z < 200; z+=cubeDotDistance)
			{
				Dot a = new Dot(new Point3D(1400 + cubeDistance, y, z));
				a.color = new Color((int) (255),(int) (255),(int) (0));
				panel.addControl3D(a);
			}
		}
		
		for (int x = 1000; x < 1400; x+=cubeDotDistance)
		{
			for (int y = -200; y < 200; y+=cubeDotDistance)
			{
				Dot a = new Dot(new Point3D(x + cubeDistance, y, 200));
				a.color = new Color((int) (255),(int) (0),(int) (255));
				panel.addControl3D(a);
			}
		}
		
		for (int x = 1000; x < 1400; x+=cubeDotDistance)
		{
			for (int y = -200; y < 200; y+=cubeDotDistance)
			{
				Dot a = new Dot(new Point3D(x + cubeDistance, y, - 200));
				a.color = new Color((int) (255),(int) (118),(int) (0));
				panel.addControl3D(a);
			}
		}
		if (saturn)
		{
			Dot saturn = new Dot(new Point3D(0, 100000, - 5000));
			saturn.color = new Color(195, 107, 31);
			saturn.radius = 10000;
			panel.addControl3D(saturn);
		}
		Dot cubeLocator = new Dot(new Point3D(1200 + cubeDistance, 0, 0));
		cubeLocator.radius = 300;
		cubeLocator.color = new Color(255, 125, 0);
		
		//System.out.println(new Point3D(10, 10, 10).getAngleTo(new Point3D(0, 0, 0)));
		
		if (sun)
		{
			LensFlare sun = new LensFlare(new Point3D(100000, 1000000, 0));
			sun.color = new Color(247, 184, 19);
			sun.radius = 100000;
			panel.addControl3D(sun);
		}
		
		KeyEventListener listener = new KeyEventListener();
		Screen.addKeyListener(listener);
		
		panel.mouseLocked = true;
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		Screen.getContentPane().setCursor(blankCursor);
		listener.exit = false;
		
		panel.addControl3D(cubeLocator);
		Screen.add(panel);
		Screen.setVisible(true);
		Screen.repaint();
		
		Page menu = new Page(600, 600, panel, new Point(panel.getWidth() / 2 - 300, panel.getHeight() / 2 - 300));
		
		Timer tim = new Timer();
		tim.scheduleAtFixedRate(new TimerTask()
		{
			Point3D movementVector = new Point3D();
			boolean rocketMode = false;
			boolean lightSpeed = false;
			public void run()
			{
				final double distance;
				if (rocketMode)
				{
					if (lightSpeed & (listener.wPressed || listener.aPressed || listener.sPressed || listener.dPressed || listener.spacePressed || listener.shiftPressed))
					{
						distance = 10000;
						lightSpeed = false;
					}
					else
					{
						distance = 0.1;
					}
				}
				else
				{
					distance = 2;
				}
				boolean paint = panel.paint;
				Point3D addVector = new Point3D();
				Point3D vectorWorking;
				if (rocketMode == true)
				{
					vectorWorking = addVector;
					paint = true;
				}
				else
				{
					vectorWorking = panel.perspectiveLocation;
				}
				if (listener.wPressed)
				{
					vectorWorking.x+=Math.cos(panel.perspectiveAngle.horizontal) * distance;
					vectorWorking.y+=Math.sin(panel.perspectiveAngle.horizontal) * distance;
					paint = true;
				}
				if (listener.aPressed)
				{
					vectorWorking.x-=Math.cos(panel.perspectiveAngle.horizontal - Math.PI / 2) * distance;
					vectorWorking.y-=Math.sin(panel.perspectiveAngle.horizontal - Math.PI / 2) * distance;
					paint = true;
				}
				if (listener.sPressed)
				{
					vectorWorking.x-=Math.cos(panel.perspectiveAngle.horizontal) * distance;
					vectorWorking.y-=Math.sin(panel.perspectiveAngle.horizontal) * distance;
					paint = true;
				}
				if (listener.dPressed)
				{
					vectorWorking.x-=Math.cos(panel.perspectiveAngle.horizontal + Math.PI / 2) * distance;
					vectorWorking.y-=Math.sin(panel.perspectiveAngle.horizontal + Math.PI / 2) * distance;
					paint = true;
				}
				if (listener.upPressed)
				{
					panel.perspectiveAngle.vertical+=0.01;
					paint = true;
				}
				if (listener.downPressed)
				{
					panel.perspectiveAngle.vertical-=0.01;
					paint = true;
				}
				if (listener.spacePressed)
				{
					paint = true;
					vectorWorking.z+=distance;
				}
				if (listener.shiftPressed)
				{
					paint = true;
					vectorWorking.z-=distance;
				}
				if (listener.rightPressed)
				{
					panel.perspectiveAngle.horizontal-=0.01;
					paint = true;
				}
				if (listener.leftPressed)
				{
					panel.perspectiveAngle.horizontal+=0.01;
					paint = true;
				}
				/*
				if (listener.gPressed)
				{
					panel.FOV-=5;
					paint = true;
				}
				*/
				if (listener.hPressed)
				{
					movementVector = new Point3D();
				}
				if (listener.rPressed)
				{
					listener.rPressed = false;
					if (rocketMode)
					{
						rocketMode = false;
						lightSpeed = false;
						movementVector = new Point3D();
					}
					else
					{
						rocketMode = true;
						movementVector = new Point3D();
					}
				}
				if (listener.lPressed)
				{
					listener.lPressed = false;
					if (rocketMode)
					{
						lightSpeed = true;
					}
				}
				if (listener.exit)
				{
					if (panel.mouseLocked)
					{
						panel.mouseLocked = false;
						Screen.getContentPane().setCursor(Cursor.getDefaultCursor());
						listener.exit = false;
						
					}
					else
					{
						panel.mouseLocked = true;
						BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
						Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
						    cursorImg, new Point(0, 0), "blank cursor");
						Screen.getContentPane().setCursor(blankCursor);
						listener.exit = false;
					}
				}
				movementVector = movementVector.addPoint(addVector);
				panel.perspectiveLocation = panel.perspectiveLocation.addPoint(movementVector);
				if (panel.mouseLocked == true)
				{
					paint = true;
				}
				if (paint)
				{
					Screen.repaint();
					panel.paint = false;
				}
			}
		}, 10, 10);
		panel.addMouseListener();
		Label instructionalText = new Label("[w][a][s][d][space][shift] To Move", panel, new Point());
		instructionalText.setFont(new Font("Times New Roman", Font.BOLD, 40));
		instructionalText.setLocation(new Point(panel.getWidth() / 2 - instructionalText.getWidth() / 2, panel.getHeight() / 2 - instructionalText.getHeight() / 2));
		instructionalText.visibility = 0;
		instructionalText.setVisible(true);
		instructionalText.color = new Color(255,255,255);
		Timer tim2 = new Timer();
		
		tim2.scheduleAtFixedRate(new TimerTask()
		{
			int ticks = 0;
			public void run()
			{
				ticks++;
				if (ticks < 400)
				{
					instructionalText.visibility = Math.sin(ticks / 400.0 * Math.PI);
				}
				if (ticks > 400 && ticks < 800)
				{
					instructionalText.setText("Press [esc] For Menu");
					instructionalText.visibility = Math.sin((ticks - 400) / 400.0 * Math.PI);
				}
				if (ticks > 800 && ticks < 1200)
				{
					instructionalText.setText("Hit [r] For Rocket Mode");
					instructionalText.visibility = Math.sin((ticks - 800) / 400.0 * Math.PI);
				}
				if (ticks > 1200)
				{
					tim2.purge();
					tim2.cancel();
				}
				instructionalText.setLocation(new Point(panel.getWidth() / 2 - instructionalText.getWidth() / 2, panel.getHeight() / 2 - instructionalText.getHeight() / 2));
				panel.paint = true;
			}
		}, 10, 10);
	}

}
