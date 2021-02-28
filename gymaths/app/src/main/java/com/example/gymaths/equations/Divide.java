package com.example.gymaths.equations;

public class Divide extends Operator
{
    public Divide(Exp expLeft, Exp expRight)
	{
		super(expLeft, expRight);
	}

	@Override
	public Exp copy() {
		return new Divide(this.expLeft.copy(), this.expRight.copy());
	}

	@Override
	public double evaluate() throws Exception
	{
		try {

			double el = this.expLeft.evaluate();
			double er = this.expRight.evaluate();

			if(er == 0.0)
				throw new UnsupportedOperationException();

			return el / er;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.simplify();
			throw e;
		}
	}

	@Override
	public Operator opposite() {
		return new Times(this.expLeft, this.expRight);
	}
	
	// TODO This
	@Override
	public Exp simplify() {
		return new Divide(this.expLeft.simplify(), this.expRight.simplify());
	}

	@Override
	public String toString()
	{
		return String.format("(%s / %s)", this.expLeft.toString(), this.expRight.toString());
	}

	@Override
	public String toLatex()
	{
		return String.format("\\frac{%s}{%s}", this.expLeft.toLatex(), this.expRight.toLatex());
	}

	@Override
	public String toLatexTree() {
		return String.format("[./ %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	}
}
