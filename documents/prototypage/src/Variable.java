public class Variable extends Leaf
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
	public Exp copy() {
		return new Variable(new String(this.getName()));
	}

	@Override
	public double evaluate() throws VariableEvaluationException
	{
		throw new VariableEvaluationException();
	}

	// TODO This
	@Override
	public Exp simplify() {
		return this;
	}

	@Override
	public String toString()
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