import java.security.GeneralSecurityException;

public abstract class Exp {
	public Exp expLeft;
	public Exp expRight;

	public Exp(Exp expLeft, Exp expRight) {
		this.expLeft = expLeft;
		this.expRight = expRight;
	}

	public abstract float evaluate() throws Exception;

	public abstract void simplify();

	public abstract String print();

	public abstract String toLatex();

	public void setLeft(Exp e)
	{
		this.expLeft = e;
	}

	public void setRight(Exp e)
	{
		this.expRight = e;
	}

	public static void main(String[] args) throws Exception {
		Exp exp = new Plus(new Plus(new Number(3), new Number(2)), new Times(new Number(3), new Number(-1)));
		Exp eq_3x7eq1 = null;
		Exp generated = EquationGenerator.generateEquation(10);
		System.out.println(generated.print());
		/*generated = EquationGenerator.QUADRATIC();
		System.out.println(generated.print());*/

		Exp eq_mult = new Times(new Variable("x"), new Number(0));
		boolean res = EquationSimplificator.matchWithMult(eq_mult);
		System.out.println("Evaluate : " + eq_mult.print());
		System.out.format("%s\n", res ? "True" : "False");
	}
}
