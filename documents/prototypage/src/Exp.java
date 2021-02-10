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
		Exp exp = new Plus(new Plus(new Number(3), new Number(2)), new Times(new Number(3), new Number(-1)));
		Exp eq_3x7eq1 = null;
		Exp generated = EquationGenerator.generateEquation(5); // Fait des execptions
		//System.out.println(generated.print());
		/*generated = EquationGenerator.QUADRATIC();
		System.out.println(generated.print());*/
		System.out.println("Tree : " + generated.toLatexTree());
		Exp eq_mult;
		eq_mult = new Plus(new Plus(new Number(1), new Times(new Number(0), new Variable("x"))), new Number(4));
		System.out.println("Print : " + eq_mult.toString());				// 1 + (x * 0) + 4
		Exp simplified = EquationSimplificator.simplify(eq_mult);
		System.out.println("1 - Simplified : " + simplified.toString()); 	// 1 + 0 + 4
		simplified = EquationSimplificator.simplify(simplified);
		System.out.println("2 - Simplified : " + simplified.toString()); 	// 1 + 4
		
		eq_mult = new Plus(new Plus(new Number(1), new Times(new Number(0), new Variable("x"))), new Number(4));
		System.out.println("Print : " + eq_mult.toString());
		Exp try_simplified = eq_mult.simplify();
		System.out.println("1 - Simplified : " + try_simplified.toString());
		try_simplified = try_simplified.simplify();
		System.out.println("2 - Simplified : " + try_simplified.toString()); 
		
	}
}
