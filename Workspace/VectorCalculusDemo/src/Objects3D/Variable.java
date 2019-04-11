package Objects3D;

public class Variable extends Value
{
	static enum variableValue
	{
		a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, y, x, z;
		public double value = 0;
	}
	public Variable(String value)
	{
		this.value = value;
	}
	public double solve()
	{
		return variableValue.valueOf(value).value;
	}
}
