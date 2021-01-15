public class Plus extends Exp
{
	public Plus(Exp expLeft, Exp expRight)
	{
		super(expLeft, expRight);
	}

	@Override
	public float evaluate()
	{
		return this.expLeft.evaluate() + this.expRight.evaluate();
	}

	@Override
	public String print()
	{
		return String.format("%s + %s", this.expLeft.print(), this.expRight.print());
	}

	@Override
	public String toLatex()
	{
		return String.format("%s+%s", this.expLeft.print(), this.expRight.print());
	}
}
