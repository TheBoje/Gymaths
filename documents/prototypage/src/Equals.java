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
		return this;
	}
}
