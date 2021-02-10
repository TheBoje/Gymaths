
public class Pow extends Exp
{

    public Pow(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    @Override
    public float evaluate() throws Exception {
        try {
			return (float)Math.pow(this.expLeft.evaluate(), this.expRight.evaluate());
		} catch (VariableEvaluationException e) {
			e.print();
			this.simplify();
			throw e;
		}
    }

    @Override
    public Exp simplify() {
        return this;
    }

    @Override
    public String print() {
        return String.format("%s^(%s)", this.expLeft.print(), this.expRight.print());
    }

    @Override
    public String toLatex() {
        return String.format("%s^{%s}", this.expLeft.print(), this.expRight.print());
    }
    
}