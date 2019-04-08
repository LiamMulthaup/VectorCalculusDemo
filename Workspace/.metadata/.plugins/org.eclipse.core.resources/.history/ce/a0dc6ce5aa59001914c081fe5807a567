package Objects3D;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Test {

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
			//Dot a = new Dot(new Point3D(Math.abs((Math.abs(k) / k * k) % 30 - 15), k, 0));
			//dot a = new Dot(new Point3D(k, (Math.abs((Math.abs(k) / k * k) % 30 - 15) + (Math.abs((Math.abs(k) / k * k) % 30 - 15) / 3)), 0));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * 10 * Math.sin(k / 100), k, Math.sin(k / 10 - Math.PI / 2) * 10 * Math.sin(k / 100)));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * 10, k, Math.sin(k / 10 - Math.PI / 2) * 10));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k / 10, k, Math.sin(k / 10 - Math.PI / 2) * k / 10));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * 100, 0, Math.sin(k / 10 - Math.PI / 2) * 100));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k, 0, Math.sin(k / 10 - Math.PI / 2) * k));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k / 10, k - 10000, Math.sin(k / 10 - Math.PI / 2) * k / 10));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k, Math.sin(k / 10 - Math.PI / 2) * k, 0));
			//Dot a = new Dot(new Point3D(Math.sin(k * 10) * 100, k, Math.sin(k / 100) * 50));
			//Dot a = new Dot(new Point3D(Math.sin(k * 10) * 100, k, Math.sin(k / 100) * 50 * Math.cos((Math.sin(k * 10) * 100) * Math.PI / 200 )));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k, Math.sin(k / 10 - Math.PI / 2) * k, Math.cos(Math.sqrt((Math.sin(k / 10) * k) * (Math.sin(k / 10) * k) + (Math.sin(k / 10 - Math.PI / 2) * k) * (Math.sin(k / 10 - Math.PI / 2) * k)) / 100) * 2000 / Math.pow(k, 1 / 3.0) ));
			//Dot a = new Dot(new Point3D((int)(k / 4) * 20, k % 4 * 5, 0));
			//Dot a = new Dot(new Point3D(k % width * wavelength - width * wavelength / 2 - 20, (int)(k / width) * wavelength - width * wavelength / 2 - 20, - 10000000 / ( (k % width * wavelength - width * wavelength / 2 - 20) * (k % width * wavelength - width * wavelength / 2 - 20) + ((int)(k / width) * wavelength - width * wavelength / 2 - 20) * ((int)(k / width) * wavelength - width * wavelength / 2 - 20) ) ) );
			//Dot a = new Dot(new Point3D(Math.sin(k / 7.125739679485947843859367 - 1) * Math.pow(k, 0.5) * 20, k, Math.sin(k / 10) * Math.pow(k, 0.5) * 20));
			double x = k % width * wavelength - width * wavelength / 2 - 20;
			double y = (int)(k / width) * wavelength - width * wavelength / 2 - 20;
			//X component 
			//Dot a = new Dot(new Point3D(x, y, 10000000 / (x * x + y * y) * x / Math.sqrt(x * x + y * y) ));
			//Y component 
			//Dot a = new Dot(new Point3D(x, y, 10000000 / (x * x + y * y) * y / Math.sqrt(x * x + y * y)));
			//Dot a = new Dot(new Point3D(x, y, Math.sqrt(5 + 100 * Math.sqrt(x) + y * y)));
			//Dot a = new Dot(new Point3D(x, y, Math.sqrt(1000000 * ( 1.0 / Math.sqrt(x * x + y * y) - 1.0 / 400) )    ));
			//Dot a = new Dot(new Point3D( Math.cos(k / 20) * (int)(k / 40 / Math.PI + 40) * 50, Math.sin(k / 20) * (int)(k / 40 / Math.PI + 40) * 50 + 100000, -5000));
			double sineSwitch = Math.cos(k * 12324515131.1564) / Math.abs(Math.cos(k * 12324515131.1564));
			//Dot a = new Dot(new Point3D(x, y, sineSwitch * Math.sqrt(1000000 - (x * x + y * y))));
			//Dot a = new Dot(new Point3D(x, y, (x * x * x / 3 + y * y * x) / width / width / wavelength / wavelength));
			//Dot a = new Dot(new Point3D(x, y, (Math.pow(x / wavelength, 2) + Math.pow(y / wavelength, 2) + Math.pow(width, 2) / 6)));
			//Dot a = new Dot(new Point3D(x, y, sineSwitch * Math.sqrt(-500000 + x * x + y * y)));
			//Dot a = new Dot(new Point3D(x, y, (x * x - y * y) / 5000));
			Dot a = new Dot(new Point3D(x, y, 1000 * Math.pow(Math.cos(x / 1000),2) * Math.pow(Math.cos(y / 1000), 2)));
			//System.out.println(k);
			a.radius = 60;
			a.color = new Color((int) (200),(int) (0),(int) (200));
			//a.color = new Color((int) (Math.random() * 150) + (int)(Math.random() * 107),(int) (Math.random() * 256),(int) (Math.random() * 150 + (int)(Math.random() * 107)));
			//a.color = new Color((int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100);
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
		/*
		for (double k = 0; k <= 2500; k+= 1)
		{
			double x = k % 50 * 20 - 50 * 20 / 2 - 20;
			double y = (int)(k / 50) * 20 - 50 * 20 / 2 - 20;
			Dot a = new Dot(new Point3D( Math.cos(k / 20) * (int)(k / 40 / Math.PI + 40) * 50, Math.sin(k / 20) * (int)(k / 40 / Math.PI + 40) * 50 + 100000, -5000));
			//System.out.println(k);
			a.radius = 200;
			a.color = new Color((int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100,(int) (Math.random() * 60) + 100);
			panel.addControl3D(a);
		}
		*/
		///*
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
		//*/
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
		
		Dot cubeLocator = new Dot(new Point3D(1200 + cubeDistance, 0, 0));
		Dot saturn = new Dot(new Point3D(0, 100000, - 5000));
		saturn.color = new Color(195, 107, 31);
		saturn.radius = 10000;
		cubeLocator.radius = 300;
		cubeLocator.color = new Color(255, 125, 0);
		
		//System.out.println(new Point3D(10, 10, 10).getAngleTo(new Point3D(0, 0, 0)));
		
		Dot a = new Dot(new Point3D(100, 10, 10));
		a.radius = 50;
		Dot b = new Dot(new Point3D(200, - 10, - 10));
		b.radius = 30;
		Dot c = new Dot(new Point3D(400, 10, 10));
		Dot d = new Dot(new Point3D(- 200, 80, - 200));
		d.radius = 80;
		Dot e = new Dot(new Point3D(-1000, - 400, 30));
		e.radius = 30;
		Dot f = new Dot(new Point3D(200, 200, - 400));
		Dot g = new Dot(new Point3D(-1000, 400, 90));
		Dot h = new Dot(new Point3D(1000, - 10, - 10));
		Dot i = new Dot(new Point3D(2000, 80, 10));
		Dot j = new Dot(new Point3D(-3000, 60, - 10));
		///*
		LensFlare sun = new LensFlare(new Point3D(100000, 1000000, 0));
		sun.color = new Color(247, 184, 19);
		sun.radius = 100000;
		panel.addControl3D(sun);
		//*/
		CelestialObject earth = new CelestialObject(new Point3D(0, 0, 0));
		earth.mass = 50000;
		earth.color = Color.green;
		panel.addControl3D(earth);
		panel.addControl3D(saturn);
		earth.radius = 300;
		KeyEventListener listener = new KeyEventListener();
		Screen.addKeyListener(listener);
		b.color = new Color(255, 0, 0);
		
		panel.addControl3D(a);
		panel.addControl3D(b);
		panel.addControl3D(c);
		panel.addControl3D(d);
		panel.addControl3D(e);
		panel.addControl3D(f);
		panel.addControl3D(g);
		panel.addControl3D(h);
		panel.addControl3D(i);
		panel.addControl3D(j);
		panel.addControl3D(cubeLocator);
		Screen.add(panel);
		Screen.setVisible(true);
		Screen.repaint();
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
				boolean paint = false;
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
				}
			}
		}, 10, 10);
		ArrayList<CelestialObject> celestialObjects = new ArrayList<CelestialObject>();
		celestialObjects.add(earth);
		Timer tim2 = new Timer();
		tim2.scheduleAtFixedRate(new TimerTask()
		{
				public void run()
				{
					if (listener.gPressed)
					{
						CelestialObject newCelestialObject = new CelestialObject(panel.perspectiveLocation);
						newCelestialObject.movementVector = new Point3D(0, 0, 0).getPointAt(panel.perspectiveAngle, 3);
						newCelestialObject.mass = 1;
						newCelestialObject.radius = 40;
						panel.addControl3D(newCelestialObject);
						celestialObjects.add(newCelestialObject);
						listener.gPressed = false;
					}
					final double gravitationalConstant = 0.5;
					for (CelestialObject o : celestialObjects)
					{
						Point3D estimatedMovementVector = new Point3D(o.movementVector);
						double[] radiuses = new double[celestialObjects.size() - 1];
						int radiusesIndex = 0;
						for (CelestialObject i : celestialObjects)
						{
							if (o != i)
							{
								double r = o.location.getDistanceTo(i.location);
								radiuses[radiusesIndex] = r;
								radiusesIndex++;
								double force = (o.mass * i.mass) / (r * r) * gravitationalConstant;
								estimatedMovementVector = o.movementVector.addPoint(new Point3D().getPointAt(o.location.getAngleTo(i.location), force / o.mass));
							}
						}
						Point3D newLocation = o.location.addPoint(estimatedMovementVector);
						double changeInEnergy = 0;
						radiusesIndex = 0;
						for (CelestialObject i : celestialObjects)
						{
							if (o != i)
							{
								double rI = radiuses[radiusesIndex];
								double rF = newLocation.getDistanceTo(i.location);
								changeInEnergy += (o.mass * i.mass) / rF * gravitationalConstant - (o.mass * i.mass) / rI * gravitationalConstant;
								radiusesIndex++;
							}
						}
						o.location = newLocation;
						Angle3D velocityAngle = new Point3D(0,0,0).getAngleTo(estimatedMovementVector);
						double newKineticEnergy = o.mass / 2 * o.movementVector.getMagnitude() * o.movementVector.getMagnitude() + changeInEnergy;
						/*
						if (o == earth)
						{
							System.out.println("Movement: " + o.movementVector.getMagnitude());
							System.out.println("Change In Energy: " + changeInEnergy);
							System.out.println("New Kinetic Energy: " + newKineticEnergy);
						}
						*/
						if (newKineticEnergy > 0)
						{
							double newVelocityMagnitude;
							newVelocityMagnitude = Math.sqrt(newKineticEnergy * 2 / o.mass);
							o.movementVector = new Point3D(0, 0, 0).getPointAt(velocityAngle, newVelocityMagnitude);
						}
						else
						{
							o.movementVector = new Point3D(0,0,0);
						}
					}
					//Screen.repaint();
				}
		}
				, 20, 20);
	}

}
