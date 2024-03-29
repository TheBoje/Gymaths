public class Equals extends Exp {
	int value;

	public Equals(Exp expLeft, Exp expRight) {
		super(expLeft, expRight);
	}

	@Override
	public float evaluate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String print()
	{
		return String.format("(%s = %s)", this.expLeft.print(), this.expRight.print());
	}

	@Override
	public String toLatex()
	{
		return String.format("%s=%s", this.expLeft.toLatex(), this.expRight.toLatex());
	}

	@Override
	public void simplify() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
