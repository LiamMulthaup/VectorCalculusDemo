package Objects3D;

public class Angle3D 
{
	double vertical;
	double horizontal;
	public Angle3D(double hor, double vert)
	{
		vertical = vert;
		horizontal = hor;
	}
	public String toString()
	{
		return "Vertical: " + vertical + ", Horizontal: " + horizontal;
	}
}
