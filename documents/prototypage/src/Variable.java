public class Variable extends Exp
{
	private final String name;

	public Variable(String name)
	{
		super(null, null);
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	@Override
	public float evaluate() throws VariableEvaluationException
	{
		throw new VariableEvaluationException();
	}

	// TODO This
	@Override
	public Exp simplify() {
		return this;
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

	@Override
	public String toLatexTree() {
		return String.format("%s", this.name);
	} 
}