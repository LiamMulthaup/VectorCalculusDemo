package Objects3D;

public class Point3D 
{
	double x, y, z;
	public Point3D()
	{
		
	}
	public Point3D(Point3D point)
	{
		this.x = point.x;
		this.y = point.y;
		this.z = point.z;
	}
	public Point3D(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Angle3D getAngleTo(Point3D point)
	{
		double xDif = point.x - x;
		double yDif = point.y - y;
		double zDif = point.z - z;
		double altDistance = Math.sqrt((xDif * xDif) + (yDif * yDif));
		return new Angle3D(Math.atan2(yDif, xDif), Math.atan2(zDif , altDistance));
	}
	public Point3D getPointAt(Angle3D angle, double distance)
	{
		Point3D newPoint = new Point3D();
		newPoint.z = z + Math.sin(angle.vertical) * distance;
		double altDistance = Math.cos(angle.vertical) * distance;
		newPoint.x = x + Math.cos(angle.horizontal) * altDistance;
		newPoint.y = y + Math.sin(angle.horizontal) * altDistance;
		return newPoint;
	}
	public double getDistanceTo(Point3D point)
	{
		return Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y) + (z - point.z) * (z - point.z));
	}
	public Point3D addPoint(Point3D point)
	{
		return new Point3D(x + point.x, y + point.y, z + point.z);
	}
	public String toString()
	{
		return "X: " + x + ", Y: " + y + ", Z: " + z;
	}
	public double getMagnitude()
	{
		return Math.sqrt(x * x + y * y + z * z);
	}
}
