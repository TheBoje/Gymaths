public class Minus extends Operator 
{
	private static final Exp minus_0 = new Minus(new Ignored(), new Number(0));

    public Minus(Exp expLeft, Exp expRight)
	{
		super(expLeft, expRight);
	}

	@Override
	public Exp copy() {
		return new Minus(this.expLeft.copy(), this.expRight.copy());
	}

	@Override
	public double evaluate() throws Exception
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
		if (EquationSimplificator.matchWith(this, minus_0))
		{
			if (this.expLeft instanceof Number && ((Number)this.expLeft).getValue() == 0)
			{
				return this.expRight;
			}
			else
			{
				return this.expLeft;
			}
		}
		else
		{
			return new Minus(this.expLeft.simplify(), this.expRight.simplify());
		}
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
