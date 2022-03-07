public class Equals extends Operator {
	private static final Exp equals_cl = new Equals(new Operator(new Ignored(), new Ignored()), new Ignored());

	public Equals(Exp expLeft, Exp expRight) {
		super(expLeft, expRight);
	}

	@Override
	public Exp copy() {
		return new Equals(this.expLeft.copy(), this.expRight.copy());
	}

	@Override
	public double evaluate() throws Exception {
		if (this.expLeft instanceof Variable)
		{
			return this.expRight.evaluate();
		} 
		else if (this.expRight instanceof Variable)
		{
			return this.expLeft.evaluate();
		}
		else
		{
			throw new UnbalancedEqualException();
		}
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", this.expLeft.toString(), this.expRight.toString());
	}

	@Override
	public String toLatex()
	{
		return String.format("%s=%s", this.expLeft.toLatex(), this.expRight.toLatex());
	}

	

	// TODO This
	@Override
	public Exp simplify() {
		if (EquationSimplificator.matchWith(this, equals_cl))
		{
			this.clRotateRight();
			return new Equals(this.expLeft.simplify(), this.expRight.simplify());
		}
		else
		{
			return new Equals(this.expLeft.simplify(), this.expRight.simplify());
		}

	}

	@Override
	public String toLatexTree() {
		return String.format("[.= %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	}

}
