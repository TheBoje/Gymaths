public class Variable extends Exp
{
	private final String name;

	public Variable(String name)
	{
		super(null, null);
		this.name = name;
	}

	@Override
	public float evaluate()
	{
		return 0; // TODO Figure out how to work with this
	}

	@Override
	public String print()
	{
		return this.name;
	}

	@Override
	public String toLatex()
	{
		return this.name;
	}
}
