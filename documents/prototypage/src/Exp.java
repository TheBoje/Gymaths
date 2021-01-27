public abstract class Exp
{
	public Exp expLeft;
	public Exp expRight;

	public Exp(Exp expLeft, Exp expRight)
	{
		this.expLeft 	= expLeft;
		this.expRight 	= expRight;
	}

	public abstract float evaluate();

	public abstract void simplify();

	public abstract String print();

	public abstract String toLatex();

	public static void main(String[] args)
	{
		Exp exp = new Plus(new Plus(new Number(3), new Number(2)), new Times(new Number(3), new Number(-1)));
		System.out.println(exp.print());
		System.out.println("Evaluate : " + exp.evaluate());
	}
}
