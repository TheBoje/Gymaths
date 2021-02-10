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
	public String toString()
	{
		return String.format("(%s = %s)", this.expLeft.toString(), this.expRight.toString());
	}

	@Override
	public String toLatex()
	{
		return String.format("%s=%s", this.expLeft.toLatex(), this.expRight.toLatex());
	}

	// TODO This
	@Override
	public Exp simplify() {
		return new Equals(this.expLeft.simplify(), this.expRight.simplify());
	}

	@Override
	public String toLatexTree() {
		return String.format("[.= %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	}

}
