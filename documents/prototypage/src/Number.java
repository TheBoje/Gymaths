public class Number extends Exp
{
	int value;

	public Number(int value)
	{
		super(null, null);
		this.value = value;
	}

	@Override
	public float evaluate()
	{
		return this.value;
	}

	@Override
	public String print()
	{
		return Integer.toString(value);
	}

	@Override
	public String toLatex()
	{
		return Integer.toString(value);
	}
}
