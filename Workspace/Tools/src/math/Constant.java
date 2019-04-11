package math;

public class Constant extends Value
{
	public Constant(String value)
	{
		this.value = value;
	}
	public double solve()
	{
		return Double.parseDouble(value);
	}
}
