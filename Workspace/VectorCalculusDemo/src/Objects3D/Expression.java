package Objects3D;

import java.util.ArrayList;

public class Expression extends Value
{
	public Expression(String value) throws Exception
	{
		String trimmedValue = value.toLowerCase().trim();
		String reducedValue = "";
		int s = 0;
		for (int i = 0; i < trimmedValue.length(); i++)
		{
			if (trimmedValue.charAt(i) == ' ')
			{
				reducedValue = reducedValue.concat(trimmedValue.substring(s, i));
				s = i + 1;
			}
			else if (i == trimmedValue.length() - 1)
			{
				reducedValue = reducedValue.concat(trimmedValue.substring(s, trimmedValue.length()));
			}
		}
		this.value = reducedValue;
		if (this.value.length() == 0)
		{
			throw new Exception();
		}
		parse();
	}
	ArrayList<Value> subValues = new ArrayList<Value>();
	
	private boolean isForwardBracket(char c)
	{
		return (c == '(' || c == '[' || c == '{');
	}
	private boolean isBackwardBracket(char c)
	{
		return (c == ')' || c == ']' || c == '}');
	}
	private void parse() throws Exception
	{
		int s = 0;
		int f = 0;
		int skip = 0;
		int function = 0;
		String subString = null;
		for (int i = 0; i < value.length(); i++)
		{
			char c = value.charAt(i);
			if (skip == 0)
			{
				if (isForwardBracket(c))
				{
					if (function == 1)
					{
						f = i + 1;
					}
					skip++;
					s = i;
				}
				else
				{
					int code = value.codePointAt(i);
					if (code >= 97 && code <= 122)
					{
						String excerpt = "";
						String excerpt2 = "";
						if (i + 3 < value.length() + 1)
						{
							excerpt = value.substring(i, i + 3);
						}
						if (i + 4 < value.length() + 1)
						{
							excerpt2 = value.substring(i, i + 4);
						}
						if (Function.getFunction(excerpt) != Function.functionType.NA)
						{
							if (function == 0)
							{
								f = i + 3;
								subString = excerpt;
							}
							function++;
							i+=2;
						}
						else if (Function.getFunction(excerpt2) != Function.functionType.NA)
						{
							if (function == 0)
							{
								f = i + 4;
								subString = excerpt2;
							}
							function++;
							i+=3;
						}
						else
						{
							if (function == 0)
							{
								subValues.add(new Variable("" + c));
							}
							else
							{
								subValues.add(new Function(value.substring(f, i + 1),subString)); 
								function = 0;
							}
						}
					}
					else if (code >= 49 && code <= 57)
					{
						int k;
						for (k = i; k < value.length() && ((value.charAt(k) >= 49 && value.charAt(k) <= 57)|| value.charAt(k) == '.'); k++);
						if (k == value.length() - 1){k = value.length();}
						double constant = Double.parseDouble(value.substring(i,k));
						i = k - 1;
						if (function == 0)
						{
							subValues.add(new Constant("" + constant));
						}
						else
						{
							subValues.add(new Function(value.substring(f, i + 1),subString));
							function = 0;
						}
					}
					else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%')
					{
						if (i != 0 && i != value.length() - 1)
						{
							if (subValues.get(subValues.size() - 1).getClass() != Operator.class)
							{
								subValues.add(new Operator("" + c));
							}
							else
							{
								throw new Exception();
							}
						}
						else if (i != value.length() - 1 && (c == '+' || c == '-'))
						{
							subValues.add(new Operator("" + c));
						}
						else
						{
							throw new Exception();
						}
					}
					else
					{
						throw new Exception();
					}
				}
			}
			else if (isBackwardBracket(c))
			{
				skip--;
				if (skip == 0)
				{
					if (function == 0) {subValues.add(new Expression(value.substring(s + 1, i)));}
					else {subValues.add(new Function(value.substring(f, i),subString)); function = 0;}
				}
				if (skip < 0)
				{
					throw new Exception();
				}
			}
			else if (isForwardBracket(c))
			{
				skip++;
			}
		}
		for (int i = 0; i < subValues.size() - 1; i++)
		{
			Value a = subValues.get(i);
			Value b = subValues.get(i+1);
			if (a.getClass() != Operator.class && b.getClass() != Operator.class)
			{
				subValues.add(i + 1, new Operator("*"));
			}
		}
		if (skip != 0)
		{
			throw new Exception();
		}
	}
	public double solve()
	{
		ArrayList<Value> subValues = new ArrayList<Value>();
		for(Value v : this.subValues)
		{
			subValues.add(v);
		}
		for (int i = 1; i < subValues.size(); i++)
		{
			Value a = subValues.get(i);
			if (a.getClass() == Operator.class)
			{
				Operator o = (Operator) a;
				if (o.value.equals("^"))
				{
					double d = Math.pow(subValues.get(i - 1).solve(), subValues.get(i + 1).solve());
					subValues.remove(i+1);
					subValues.remove(i);
					subValues.remove(i-1);
					subValues.add(i - 1, new Constant("" + d));
					i--;
				}
			}
		}
		for (int i = 1; i < subValues.size(); i++)
		{
			Value a = subValues.get(i);
			if (a.getClass() == Operator.class)
			{
				Operator o = (Operator) a;
				if (o.value.equals("%"))
				{
					double d = subValues.get(i - 1).solve() % subValues.get(i + 1).solve();
					subValues.remove(i+1);
					subValues.remove(i);
					subValues.remove(i-1);
					subValues.add(i - 1, new Constant("" + d));
					i--;
				}
			}
		}
		for (int i = 1; i < subValues.size(); i++)
		{
			Value a = subValues.get(i);
			if (a.getClass() == Operator.class)
			{
				Operator o = (Operator) a;
				if (o.value.equals("*"))
				{
					double d = subValues.get(i - 1).solve() * subValues.get(i + 1).solve();
					subValues.remove(i+1);
					subValues.remove(i);
					subValues.remove(i-1);
					subValues.add(i - 1, new Constant("" + d));
					i--;
				}
				if (o.value.equals("/"))
				{
					double d = subValues.get(i - 1).solve() / subValues.get(i + 1).solve();
					subValues.remove(i+1);
					subValues.remove(i);
					subValues.remove(i-1);
					subValues.add(i - 1, new Constant("" + d));
					i--;
				}
			}
		}
		if (subValues.get(0).getClass() == Operator.class)
		{
			Operator o = (Operator) subValues.get(0);
			double d;
			if (o.value == "+")
			{
				d = subValues.get(1).solve();	
			}
			else
			{
				d = - subValues.get(1).solve();
			}
			subValues.remove(1);
			subValues.remove(0);
			subValues.add(0, new Constant("" + d));
		}
		for (int i = 1; i < subValues.size(); i++)
		{
			Value a = subValues.get(i);
			if (a.getClass() == Operator.class)
			{
				Operator o = (Operator) a;
				if (o.value.equals("+"))
				{
					double d = subValues.get(i - 1).solve() + subValues.get(i + 1).solve();
					subValues.remove(i+1);
					subValues.remove(i);
					subValues.remove(i-1);
					subValues.add(i - 1, new Constant("" + d));
					i--;
				}
				if (o.value.equals("-"))
				{
					double d = subValues.get(i - 1).solve() - subValues.get(i + 1).solve();
					subValues.remove(i+1);
					subValues.remove(i);
					subValues.remove(i-1);
					subValues.add(i - 1, new Constant("" + d));
					i--;
				}
				else 
				{
					System.out.println("Error 2");
				}
			}
		}
		return subValues.get(0).solve();
	}
}
