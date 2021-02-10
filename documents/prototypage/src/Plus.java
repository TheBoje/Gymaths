public class Plus extends Operator
{

	private static final Exp add_0 = new Plus(new Ignored(), new Number(0));

	public Plus(Exp expLeft, Exp expRight)
	{
		super(expLeft, expRight);
	}

	@Override
	public Exp copy() {
		return new Plus(this.expLeft.copy(), this.expRight.copy());
	}

	@Override
	public float evaluate() throws Exception
	{
		try {
			return this.expLeft.evaluate() + this.expRight.evaluate();
		} catch (VariableEvaluationException e) {
			e.print();
			//this.simplify(); // TODO Check this out
			throw e;
		}
	}

	@Override
	public Operator opposite() {
		return new Minus(this.expLeft, this.expRight);
	}

	// TODO This
	@Override
	public Exp simplify() {
		if (EquationSimplificator.matchWith(this, add_0))
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
		return new Plus(this.expLeft.simplify(), this.expRight.simplify());
	}

	@Override
	public String toString()
	{
		return String.format("%s + %s", this.expLeft.toString(), this.expRight.toString());
	}

	@Override
	public String toLatex()
	{
		return String.format("%s+%s", this.expLeft.toLatex(), this.expRight.toLatex());
	}

	@Override
	public String toLatexTree() {
		return String.format("[.+ %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	}   
}
