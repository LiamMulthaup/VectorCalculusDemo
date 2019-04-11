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

import math.Expression;
import math.Value;
import math.Variable;
import ui.Page;
import ui.RadioButton;
import ui.TextBox;
import ui.Button;
import ui.Control;
import ui.ControlHandler;
import ui.Label;

public class Test {
	final static int wavelength = 120;
	final static int width = 80;
	public static double xMin = -5, xMax = 5, yMin = -5, yMax = 5, zMin = -5, zMax = 5;
	public static Expression e;
	static public Dot[] dots = new Dot[width * width];
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
		
		worldSetUp(panel);
		
		KeyEventListener listener = new KeyEventListener();
		Screen.addKeyListener(listener);
		
		panel.mouseLocked = true;
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		Screen.getContentPane().setCursor(blankCursor);
		listener.exit = false;
		
		Screen.add(panel);
		Screen.setVisible(true);
		Screen.repaint();
		MenuControlHandler handler = new MenuControlHandler(panel);
		panel.menu = new Page(600, 670, panel, new Point(panel.getWidth() / 2 - 300, panel.getHeight() / 2 - 335));
		panel.menu.backgroundVisibility = 0.8;
		panel.menu.color = new Color(86, 91, 223);
		panel.menuLabel = new Label("Menu", panel, new Point());
		panel.menuLabel.setFont(new Font("Rockwell", Font.BOLD, 80));
		panel.menuLabel.setLocation(new Point(panel.menu.getWidth() / 2 - panel.menuLabel.getWidth() / 2, 40));
		panel.menuLabel.setVisible(true);
		panel.menuLabel.color = new Color(255, 255, 255);
		panel.setCalculationLabel = new Label("Set Calculation", panel, new Point());
		panel.setCalculationLabel.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.setCalculationLabel.setLocation(new Point(panel.menu.getWidth() / 2 - panel.setCalculationLabel.getWidth() / 2, 130));
		panel.setCalculationLabel.color = new Color(200,200,200);
		panel.setCalculationLabel.setVisible(true);
		panel.setCalculationLabel.id = "Open Calculation Window";
		panel.setCalculationLabel.controlHandler = handler;
		panel.specialSettingsLabel = new Label("Special Settings", panel, new Point());
		panel.specialSettingsLabel.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.specialSettingsLabel.setLocation(new Point(panel.menu.getWidth() / 2 - panel.specialSettingsLabel.getWidth() / 2, 170));
		panel.specialSettingsLabel.color = new Color(200,200,200);
		panel.specialSettingsLabel.setVisible(true);
		panel.specialSettingsLabel.id = "Open Special Settings Window";
		panel.specialSettingsLabel.controlHandler = handler;
		panel.menu.add(panel.specialSettingsLabel);
		panel.menu.add(panel.setCalculationLabel);
		panel.menu.add(panel.menuLabel);
		panel.starsRadioButton = new RadioButton("Stars", panel, new Point());
		panel.starsRadioButton.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.starsRadioButton.setLocation(new Point(panel.menu.getWidth() / 2 - panel.starsRadioButton.getWidth() / 2, 130));
		panel.starsRadioButton.color = new Color(0,0,0);
		panel.starsRadioButton.opaqueBubble = false;
		panel.starsRadioButton.setVisible(false);
		panel.starsRadioButton.singleChoice = false;
		panel.starsRadioButton.id = "Stars";
		panel.starsRadioButton.controlHandler = handler;
		panel.menu.add(panel.starsRadioButton);
		panel.sunRadioButton = new RadioButton("Sun", panel, new Point());
		panel.sunRadioButton.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.sunRadioButton.setLocation(new Point(panel.menu.getWidth() / 2 - panel.starsRadioButton.getWidth() / 2, 170));
		panel.sunRadioButton.color = new Color(0,0,0);
		panel.sunRadioButton.opaqueBubble = false;
		panel.sunRadioButton.setVisible(false);
		panel.sunRadioButton.selected = true;
		panel.sunRadioButton.singleChoice = false;
		panel.sunRadioButton.id = "Sun";
		panel.sunRadioButton.controlHandler = handler;
		panel.menu.add(panel.sunRadioButton);
		panel.saturnRadioButton = new RadioButton("Saturn", panel, new Point());
		panel.saturnRadioButton.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.saturnRadioButton.setLocation(new Point(panel.menu.getWidth() / 2 - panel.starsRadioButton.getWidth() / 2, 210));
		panel.saturnRadioButton.color = new Color(0,0,0);
		panel.saturnRadioButton.opaqueBubble = false;
		panel.saturnRadioButton.setVisible(false);
		panel.saturnRadioButton.singleChoice = false;
		panel.saturnRadioButton.id = "Saturn";
		panel.saturnRadioButton.controlHandler = handler;
		panel.menu.add(panel.saturnRadioButton);
		panel.backLabel = new Label("back", panel, new Point());
		panel.backLabel.setFont(new Font("Rockwell", Font.BOLD, 30));
		panel.backLabel.setLocation(new Point(panel.menu.getWidth() - panel.backLabel.getWidth() - 20, panel.menu.getHeight() - panel.backLabel.getHeight() - 20));
		panel.backLabel.color = new Color(255,255,255);
		panel.backLabel.setVisible(false);
		panel.backLabel.id = "back";
		panel.backLabel.controlHandler = handler;
		panel.menu.add(panel.backLabel);
		panel.zLabel = new Label("z =", panel, new Point(120,140));
		panel.zLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		panel.zLabel.color = new Color(255,255,255);
		panel.zLabel.setVisible(false);
		panel.menu.add(panel.zLabel);
		panel.zTextBox = new TextBox(300, 30, panel, new Point(160, 137), Screen);
		panel.zTextBox.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.zTextBox.setText("(cosx)^2 * (cosy)^2");
		panel.zTextBox.setVisible(false);
		panel.menu.add(panel.zTextBox);
		panel.calculateButton = new Button(" Calculate", 93, 30, panel, new Point());
		panel.calculateButton.setLocation(new Point(panel.menu.getWidth() / 2 - panel.calculateButton.getWidth() / 2, 350));
		panel.calculateButton.antialiasing = true;
		panel.calculateButton.backgroundVisibility = 0;
		panel.calculateButton.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.calculateButton.color = new Color(255,255,255);
		panel.calculateButton.borderColor = new Color(255,255,255);
		panel.calculateButton.rounded = true;
		panel.calculateButton.id = "Calculate";
		panel.calculateButton.controlHandler = handler;
		panel.menu.add(panel.calculateButton);
		panel.calculateButton.roundedHeight = 30;
		panel.calculateButton.roundedWidth = 30;
		panel.rangeLabel = new Label("Range:", panel, new Point());
		panel.rangeLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.rangeLabel.setLocation(new Point(panel.menu.getWidth() / 2 - panel.rangeLabel.getWidth() / 2, 200));
		panel.rangeLabel.color = new Color(255, 255, 255);
		panel.rangeLabel.setVisible(false);
		panel.menu.add(panel.rangeLabel);
		panel.xMinLabel = new Label("xMin:", panel, new Point());
		panel.xMinLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.xMinLabel.setLocation(new Point(panel.menu.getWidth() / 2 - 100 - panel.xMinLabel.getWidth(), 250));
		panel.xMinLabel.color = new Color(255, 255, 255);
		panel.xMinLabel.setVisible(false);
		panel.menu.add(panel.xMinLabel);
		panel.xMaxLabel = new Label("xMax:", panel, new Point());
		panel.xMaxLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.xMaxLabel.setLocation(new Point(panel.menu.getWidth() / 2 - 100 - panel.xMaxLabel.getWidth(), 280));
		panel.xMaxLabel.color = new Color(255, 255, 255);
		panel.xMaxLabel.setVisible(false);
		panel.menu.add(panel.xMaxLabel);
		panel.yMinLabel = new Label("yMin:", panel, new Point());
		panel.yMinLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.yMinLabel.setLocation(new Point(panel.menu.getWidth() / 2 - panel.yMinLabel.getWidth(), 250));
		panel.yMinLabel.color = new Color(255, 255, 255);
		panel.yMinLabel.setVisible(false);
		panel.menu.add(panel.yMinLabel);
		panel.yMaxLabel = new Label("yMax:", panel, new Point());
		panel.yMaxLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.yMaxLabel.setLocation(new Point(panel.menu.getWidth() / 2 - panel.yMaxLabel.getWidth(), 280));
		panel.yMaxLabel.color = new Color(255, 255, 255);
		panel.yMaxLabel.setVisible(false);
		panel.menu.add(panel.yMaxLabel);
		panel.xMinTextBox = new TextBox(30, 30, panel, new Point(panel.menu.getWidth() / 2 - 95, 245), Screen);
		panel.xMinTextBox.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.xMinTextBox.setText("-5");
		panel.xMinTextBox.acceptsLetters = false;
		panel.xMinTextBox.setVisible(false);
		panel.menu.add(panel.xMinTextBox);
		panel.xMaxTextBox = new TextBox(30, 30, panel, new Point(panel.menu.getWidth() / 2 - 95, 275), Screen);
		panel.xMaxTextBox.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.xMaxTextBox.setText("5");
		panel.xMaxTextBox.acceptsLetters = false;
		panel.xMaxTextBox.setVisible(false);
		panel.menu.add(panel.xMaxTextBox);
		panel.yMinTextBox = new TextBox(30, 30, panel, new Point(panel.menu.getWidth() / 2 + 5, 245), Screen);
		panel.yMinTextBox.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.yMinTextBox.setText("-5");
		panel.yMinTextBox.acceptsLetters = false;
		panel.yMinTextBox.setVisible(false);
		panel.menu.add(panel.yMinTextBox);
		panel.yMaxTextBox = new TextBox(30, 30, panel, new Point(panel.menu.getWidth() / 2 + 5, 275), Screen);
		panel.yMaxTextBox.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.yMaxTextBox.setText("5");
		panel.yMaxTextBox.acceptsLetters = false;
		panel.yMaxTextBox.setVisible(false);
		panel.menu.add(panel.yMaxTextBox);
		panel.zMinTextBox = new TextBox(30, 30, panel, new Point(panel.menu.getWidth() / 2 + 105, 245), Screen);
		panel.zMinTextBox.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.zMinTextBox.setText("-5");
		panel.zMinTextBox.acceptsLetters = false;
		panel.zMinTextBox.setVisible(false);
		panel.menu.add(panel.zMinTextBox);
		panel.zMaxTextBox = new TextBox(30, 30, panel, new Point(panel.menu.getWidth() / 2 + 105, 275), Screen);
		panel.zMaxTextBox.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.zMaxTextBox.setText("5");
		panel.zMaxTextBox.acceptsLetters = false;
		panel.zMaxTextBox.setVisible(false);
		panel.menu.add(panel.zMaxTextBox);
		panel.zMinLabel = new Label("zMin:", panel, new Point());
		panel.zMinLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.zMinLabel.setLocation(new Point(panel.menu.getWidth() / 2 + 100 - panel.zMinLabel.getWidth(), 250));
		panel.zMinLabel.color = new Color(255, 255, 255);
		panel.zMinLabel.setVisible(false);
		panel.menu.add(panel.zMinLabel);
		panel.zMaxLabel = new Label("zMax:", panel, new Point());
		panel.zMaxLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.zMaxLabel.setLocation(new Point(panel.menu.getWidth() / 2 + 100 - panel.zMaxLabel.getWidth(), 280));
		panel.zMaxLabel.color = new Color(255, 255, 255);
		panel.zMaxLabel.setVisible(false);
		panel.menu.add(panel.zMaxLabel);
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
				Point3D vectorWorking = new Point3D();
				if (panel.mouseLocked)
				{
					if (rocketMode == true)
					{
						vectorWorking = addVector;
						paint = true;
					}
					else
					{
						vectorWorking = panel.perspectiveLocation;
					}
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
				if (listener.upPressed && panel.mouseLocked)
				{
					panel.perspectiveAngle.vertical+=0.01;
					paint = true;
				}
				if (listener.downPressed && panel.mouseLocked)
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
				if (listener.rightPressed && panel.mouseLocked)
				{
					panel.perspectiveAngle.horizontal-=0.01;
					paint = true;
				}
				if (listener.leftPressed && panel.mouseLocked)
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
						panel.menu.setVisible(true);
						paint = true;
					}
					else
					{
						panel.menu.setVisible(false);
						panel.mouseLocked = true;
						BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
						Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
						    cursorImg, new Point(0, 0), "blank cursor");
						Screen.getContentPane().setCursor(blankCursor);
						listener.exit = false;
						paint = true;
					}
				}
				if (!movementVector.equals(new Point3D(0,0,0)))
				{
					paint = true;
				}
				movementVector = movementVector.addPoint(addVector);
				panel.perspectiveLocation = panel.perspectiveLocation.addPoint(movementVector);
				if (panel.mouseLocked == true)
				{
					paint = true;
				}
				if (paint)
				{
					panel.repaint();
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
					instructionalText.setText("Hit [r] For Rocket Mode");
					instructionalText.visibility = Math.sin((ticks - 400) / 400.0 * Math.PI);
				}
				if (ticks > 800 && ticks < 1200)
				{
					instructionalText.setText("Press [esc] For Menu");
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
	public static void graphEquation(Panel3D panel)
	{
		for (double k = 0; k < width * width; k+= 1)
		{
			Dot a = dots[(int)k];
			double x = k % width * wavelength - width * wavelength / 2;
			double y = (int)(k / width) * wavelength - width * wavelength / 2;
			double sineSwitch = Math.cos(k * 12324515131.1564) / Math.abs(Math.cos(k * 12324515131.1564));
			//Dot a = new Dot(new Point3D(x, y, 1000 * Math.pow(Math.cos(x / 1000),2) * Math.pow(Math.cos(y / 1000), 2)));
			Variable.variableValue.x.value = x / width / wavelength * (xMax - xMin) + (xMax + xMin) / 2;
			Variable.variableValue.y.value = y / width / wavelength * (yMax - yMin) + (yMax + yMin) / 2;
			a.location = new Point3D(x, y, (e.solve() - (zMax + zMin) / 2) / (zMax - zMin) * width * wavelength);
			a.radius = 40;
			a.color = new Color((int) (200),(int) (0),(int) (200));
		}
	}
	public static void worldSetUp(Panel3D panel)
	{
		panel.disposeAll();
		try {
			e = new Expression("(cosx)^2 * (cosy)^2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Variable.variableValue.x.value = 2;
			Variable.variableValue.y.value = 2;
			Expression e = new Expression("1/(x^2 + y^2)^0.5");
			for (Value v : e.subValues)
			{
				System.out.println(v.value);
			}
			System.out.println("Value: " + e.solve());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (double k = 0; k < width * width; k+= 1)
		{
			Dot a = new Dot(new Point3D(0,0,0));
			dots[(int)k] = a;
			panel.addControl3D(a);
			dots[(int)k] = a;
		}
		graphEquation(panel);
		if (panel.saturn)
		{
			for (double k = 0; k <= 2500; k+= 1)
			{
				Dot a = new Dot(new Point3D( Math.cos(k / 20) * (int)(k / 40 / Math.PI + 40) * 50, Math.sin(k / 20) * (int)(k / 40 / Math.PI + 40) * 50 + 100000, -5000));
				a.radius = 200;
				a.color = new Color((int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100);
				panel.addControl3D(a);
			}
		}
		if (panel.stars)
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
		if (panel.saturn)
		{
			Dot saturn = new Dot(new Point3D(0, 100000, - 5000));
			saturn.color = new Color(195, 107, 31);
			saturn.radius = 10000;
			panel.addControl3D(saturn);
		}
		Dot cubeLocator = new Dot(new Point3D(1200 + cubeDistance, 0, 0));
		cubeLocator.radius = 300;
		cubeLocator.color = new Color(255, 125, 0);
		cubeLocator.observatorium = true;
		panel.addControl3D(cubeLocator);
		
		if (panel.sun)
		{
			LensFlare sun = new LensFlare(new Point3D(100000, 1000000, 0));
			sun.color = new Color(247, 184, 19);
			sun.radius = 100000;
			panel.addControl3D(sun);
		}
	}
}
