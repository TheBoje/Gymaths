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

	public void clRotateRight()
	{
		if(this.expLeft != null)
		{
			Exp p = this.expLeft.opposite(); // créer la méthode qui génère l'opérateur opposé
			Exp u = p.expLeft;
			Exp v = p.expRight;
			Exp w = this.expRight;

			p.setBoth(w, v);
			this.setBoth(u, p);
		}
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
