package Objects3D;

public class Plane extends MultiDotObject
{
	Dot[] dots;
	public Plane(Point3D[] points)
	{
		super(points[0]);
		dots = new Dot[points.length];
		for (int i = 0; i < points.length; i++)
		{
			dots[i] = new Dot(points[i]);
			dots[i].container = this;
		}
	}
	
}
