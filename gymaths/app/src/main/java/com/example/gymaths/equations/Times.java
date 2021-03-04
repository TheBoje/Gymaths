package com.example.gymaths.equations;

public class Times extends Operator
{
	private static final Exp times_0 = new Times(new Ignored(), new Number(0));

	// modèle pour la distribution TODO: peut être trouver un moyen de mettre uniquement une
	private static final Exp distribPlus = new Times(new Plus(new Ignored(), new Ignored()), new Ignored());
	private static final Exp distribMinus = new Times(new Minus(new Ignored(), new Ignored()), new Ignored());
	
	public Times(Exp expLeft, Exp expRight)
	{
		super(expLeft, expRight);
	}

	@Override
	public Exp copy() {
		return new Times(this.expLeft != null ? this.expLeft.copy() : null, this.expRight != null ? this.expRight.copy() : null);
	}

	@Override
	public double evaluate() throws Exception
	{
		try {
			return this.expLeft.evaluate() * this.expRight.evaluate();
		} catch (VariableEvaluationException e) {
			e.print();
			this.simplify();
			throw e;
		}
	}

	@Override
	public Operator opposite() {
		// TODO Eval expRight == 0 ? (pour éviter la div par 0)
		return new Divide(this.expLeft, this.expRight);
	}

	@Override
	public Exp simplify() {
		if (EquationSimplificator.matchWith(this, times_0))
		{
			return new Number(0);
		}
		else if(EquationSimplificator.matchWith(this, distribPlus))
		{
			return new Plus(new Times(this.expLeft.expLeft.simplify(), this.expRight), new Times(this.expLeft.expRight.simplify(), this.expRight));
		}	
		else if(EquationSimplificator.matchWith(this, distribMinus))
		{
			return new Minus(new Times(this.expLeft.expLeft.simplify(), this.expRight), new Times(this.expLeft.expRight.simplify(), this.expRight));
		}
		else // ajouter des else if () avec les autres cas pour ajouter des cas de simplification
		{
			return new Times(this.expLeft.simplify(), this.expRight.simplify());
		}
	}

	@Override
	public String toString() // TODO Improve this
	{
		if (this.expLeft instanceof Leaf && this.expRight instanceof Leaf)
		{
			return String.format("%s * %s", this.expLeft.toString(), this.expRight.toString());
		}
		else if (this.expLeft instanceof Leaf) // Cas ou juste le gauche est une feuille
		{			
			return String.format("%s * (%s)", this.expLeft.toString(), this.expRight.toString());
		}
		else if (this.expRight instanceof Leaf) // Cas ou juste le droit est une feuille
		{			
			return String.format("(%s) * %s", this.expLeft.toString(), this.expRight.toString());
		}
		else // Cas ou les deux fils sont des opérateurs 
		{			
			return String.format("(%s) * (%s)", this.expLeft.toString(), this.expRight.toString());
		}
	}

	@Override
	public String toLatex()
	{
		return String.format("%s*%s", this.expLeft.toLatex(), this.expRight.toLatex());
	}

	@Override
	public String toLatexTree() {
		return String.format("[.* %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	} 
}
