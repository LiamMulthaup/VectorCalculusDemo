package math;

public class Function extends Expression
{
	enum functionType
	{
		cos, sin, tan, sec, csc, cot, acos, asin, atan, abs, NA;
		public double solve(double solution)
		{
			if (this.equals(cos))
			{
				return Math.cos(solution);
			}
			else if (this.equals(sin))
			{
				return Math.sin(solution);
			}
			else if (this.equals(tan))
			{
				return Math.tan(solution);
			}
			else if (this.equals(sec))
			{
				return 1 / Math.cos(solution);
			}
			else if (this.equals(csc))
			{
				return 1 / Math.sin(solution);
			}
			else if (this.equals(cot))
			{
				return 1 / Math.tan(solution);
			}
			else if (this.equals(acos))
			{
				return Math.acos(solution);
			}
			else if (this.equals(asin))
			{
				return Math.asin(solution);
			}
			else if (this.equals(atan))
			{
				return Math.atan(solution);
			}
			else if (this.equals(abs))
			{
				return Math.abs(solution);
			}
			else
			{
				return solution;
			}
		}
	}
	functionType function;
	public Function(String value, String function) throws Exception 
	{
		super(value);
		this.function = getFunction(function);
	}
	public static functionType getFunction(String function)
	{
		functionType type;
		if (function.equals("cos"))
		{
			type = functionType.cos;
		}
		else if (function.equals("sin"))
		{
			type = functionType.sin;
		}
		else if (function.equals("tan"))
		{
			type = functionType.tan;
		}
		else if (function.equals("sec"))
		{
			type = functionType.sec;
		}
		else if (function.equals("csc"))
		{
			type = functionType.csc;
		}
		else if (function.equals("cot"))
		{
			type = functionType.cot;
		}
		else if (function.equals("acos"))
		{
			type = functionType.acos;
		}
		else if (function.equals("asin"))
		{
			type = functionType.asin;
		}
		else if (function.equals("atan"))
		{
			type = functionType.atan;
		}
		else if (function.equals("abs"))
		{
			type = functionType.abs;
		}
		else
		{
			type = functionType.NA;
		}
		return type;
	}
	public double solve()
	{
		return function.solve(super.solve());
	}

}
