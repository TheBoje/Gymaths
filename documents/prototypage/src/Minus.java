public class Minus extends Operator 
{
    public Minus(Exp expLeft, Exp expRight)
	{
		super(expLeft, expRight);
	}

	@Override
	public Exp copy() {
		return new Minus(this.expLeft.copy(), this.expRight.copy());
	}

	@Override
	public float evaluate() throws Exception
	{
		try {
			return this.expLeft.evaluate() - this.expRight.evaluate();
		} catch (VariableEvaluationException e) {
			e.print();
			this.simplify();
			throw e;
		}
	}

	@Override
	public Operator opposite() {
		return new Plus(this.expLeft, this.expRight);
	}

	// TODO This
	@Override
	public Exp simplify() {
		return new Minus(this.expLeft.simplify(), this.expRight.simplify());
	}

	@Override
	public String toString()
	{
		return String.format("(%s - %s)", this.expLeft.toString(), this.expRight.toString());
	}

	@Override
	public String toLatex()
	{
		return String.format("%s-%s", this.expLeft.toLatex(), this.expRight.toLatex());
	}   

	@Override
	public String toLatexTree() {
		return String.format("[.- %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	}
    
}
