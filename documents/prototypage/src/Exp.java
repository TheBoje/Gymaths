public abstract class Exp {
	public Exp expLeft;
	public Exp expRight;

	public Exp(Exp expLeft, Exp expRight) {
		this.expLeft = expLeft;
		this.expRight = expRight;
	}

	public abstract Exp copy();

	public abstract double evaluate() throws Exception;

	public abstract Exp simplify();

	public static boolean areEqual(Exp e1, Exp e2) {
		if ((e1 != null && e2 != null) && e1.getClass().getName().equals(e2.getClass().getName())) {
			if (e1 instanceof Variable) {
				return ((Variable) e1).getName().equals(((Variable) e2).getName());
			} else if (e1 instanceof Number) {
				return ((Number) e1).getValue() == ((Number) e1).getValue();
			} else {
				return areEqual(e1.expLeft, e2.expLeft) && areEqual(e1.expRight, e2.expRight);
			}
		} else if (e1 == null && e2 == null)  
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Exp fullSimplify() {
		Exp last = this.copy();
		Exp actual = this;
		do {
			last = actual.copy();
			actual = actual.simplify();
		} while (!areEqual(last, actual));
		return actual;
	}

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
		Exp generated = EquationGenerator.generateEquation(4); // Fait des execptions
		//System.out.println(generated.print());
		/*generated = EquationGenerator.QUADRATIC();
		System.out.println(generated.print());*/

		//System.out.println("Tree           : " + generated.toLatexTree());


		Exp eq_mult, eq_equals, simplified;
		//eq_mult = new Plus(new Plus(new Number(1), new Times(new Number(0), new Variable("x"))), new Number(4));
		eq_mult = new Minus(new Times(new Minus(new Number(4), new Number(1)), new Number(0)), new Minus(new Number(0), new Number(1))); 
		eq_equals = new Equals(new Plus(new Times(new Variable("x"), new Number(7)), new Number(2)), new Number(6));
		//eq_mult = EquationGenerator.generateEquation(4);
		System.out.println("Print          : " + eq_mult.toString());
		
		simplified = eq_mult.simplify();
		System.out.println("1 - Simplified : " + simplified.toString());
		
		simplified = simplified.simplify();
		System.out.println("2 - Simplified : " + simplified.toString()); 
		//System.out.println("F - Simplified : " + generated.fullSimplify().toString());
		//System.out.println("Tree           : " + generated.fullSimplify().toLatexTree());
		
		System.out.println("Print          : " + eq_equals.toString());
		
		simplified = eq_equals.fullSimplify();
		System.out.println("F - Simplified : " + simplified.toString());

		
		System.out.println("Eval           : " + simplified.evaluate());
	}
}
