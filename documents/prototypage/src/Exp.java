public abstract class Exp {
	public Exp expLeft;
	public Exp expRight;

	public Exp(Exp expLeft, Exp expRight) {
		this.expLeft = expLeft;
		this.expRight = expRight;
	}

	public abstract float evaluate() throws Exception;

	public abstract Exp simplify();

	@Override
	public abstract String toString();

	public abstract String toLatex();
	
	public abstract String toLatexTree();

	public void setLeft(Exp e)
	{
		this.expLeft = e;
	}

	public void setRight(Exp e)
	{
		this.expRight = e;
	}

	public void setBoth(Exp left, Exp right)
	{
		setLeft(left);
		setRight(right);
	}

	public static void main(String[] args) throws Exception {
		Exp generated = EquationGenerator.generateEquation(3); // Fait des execptions
		//System.out.println(generated.print());
		/*generated = EquationGenerator.QUADRATIC();
		System.out.println(generated.print());*/

		System.out.println("Tree : " + generated.toLatexTree());


		Exp eq_mult, simplified;
		//eq_mult = new Plus(new Plus(new Number(1), new Times(new Number(0), new Variable("x"))), new Number(4));
		eq_mult = new Times(new Plus(new Number(4), new Number(1)), new Number(0)); // (4 + 1) * 0 -> 0
		//eq_mult = EquationGenerator.generateEquation(4);
		System.out.println("Print          : " + eq_mult.toString());
		System.out.println("Latex          : " + eq_mult.toLatex());
		
		simplified = eq_mult.simplify();
		System.out.println("1 - Simplified : " + simplified.toString());
		System.out.println("Latex          : " + simplified.toLatex());

		simplified = simplified.simplify();
		System.out.println("2 - Simplified : " + simplified.toString()); 
		System.out.println("Latex          : " + simplified.toLatex());
		//System.out.println("Eval : " + simplified.evaluate());
	}
}
