package com.example.gymaths.equations;

/**
 *
 */
public class Equals extends Operator {
    /**
     *
     */
    private static final Exp equals_cl = new Equals(new Operator(new Ignored(), new Ignored()), new Ignored());

    /**
     *
     * @param expLeft
     * @param expRight
     */
    public Equals(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    /**
     *
     * @return
     */
    @Override
    public Exp copy() {
        return new Equals(this.expLeft.copy(), this.expRight.copy());
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public double evaluate() throws Exception {
        if (this.expLeft instanceof Variable) {
            return this.expRight.evaluate();
        } else if (this.expRight instanceof Variable) {
            return this.expLeft.evaluate();
        } else {
            throw new UnbalancedEqualException();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s = %s", this.expLeft.toString(), this.expRight.toString());
    }

    /**
     *
     * @return
     */
    @Override
    public String toLatex() {
        return String.format("%s=%s", this.expLeft.toLatex(), this.expRight.toLatex());
    }


    // TODO This

    /**
     *
     * @return
     */
    @Override
    public Exp simplify() {
        if (EquationSimplificator.matchWith(this, equals_cl)) {
            this.clRotateRight();
            return new Equals(this.expLeft.simplify(), this.expRight.simplify());
        } else {
            return new Equals(this.expLeft.simplify(), this.expRight.simplify());
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String toLatexTree() {
        return String.format("[.= %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
    }

}
