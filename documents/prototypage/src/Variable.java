public class Variable extends Exp
{
	private final String name;

	public Variable(String name)
	{
		super(null, null);
		this.name = name;
	}

	@Override
	public float evaluate() throws VariableEvaluationException
	{
		throw new VariableEvaluationException();
	}

	@Override
	public void simplify() {
		throw new UnsupportedOperationException();
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
