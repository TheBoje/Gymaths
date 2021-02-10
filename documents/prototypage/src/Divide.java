public class Divide extends Exp 
{
    public Divide(Exp expLeft, Exp expRight)
	{
		super(expLeft, expRight);
	}

	@Override
	public float evaluate() throws Exception
	{
		try {

			float el = this.expLeft.evaluate();
			float er = this.expRight.evaluate();

			if(er == 0.0)
				throw new UnsupportedOperationException();

			return el / er;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.simplify();
			throw e;
		}
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
