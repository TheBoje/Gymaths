
public class Pow extends Operator
{

    public Pow(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    @Override
	public Exp copy() {
		return new Pow(this.expLeft.copy(), this.expRight.copy());
	}

    @Override
    public double evaluate() throws Exception {
        try {
			return (float)Math.pow(this.expLeft.evaluate(), this.expRight.evaluate());
		} catch (VariableEvaluationException e) {
			e.print();
			this.simplify();
			throw e;
		}
    }

    @Override
	public Operator opposite() {
        // TODO ajouter l'implémentation apres l'ajout de sqrt
		throw new UnsupportedOperationException();
	}

    @Override
    public Exp simplify() {
        return new Pow(this.expLeft.simplify(), this.expRight.simplify());
    }

    @Override
    public String toString() {
        return String.format("%s^(%s)", this.expLeft.toString(), this.expRight.toString());
    }

    @Override
    public String toLatex() {
        return String.format("%s^{%s}", this.expLeft.toLatex(), this.expRight.toLatex());
    }

    @Override
	public String toLatexTree() {
		return String.format("[.^ %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
	}    
}
