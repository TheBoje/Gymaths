package com.example.gymaths.equations;

import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 *
 */
public abstract class Exp {
    public Exp expLeft;
    public Exp expRight;

    /**
     *
     * @param expLeft
     * @param expRight
     */
    public Exp(Exp expLeft, Exp expRight) {
        this.expLeft = expLeft;
        this.expRight = expRight;
    }

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    public static boolean areEqual(Exp e1, Exp e2) {
        if ((e1 != null && e2 != null) && e1.getClass().getName().equals(e2.getClass().getName())) {
            if (e1 instanceof Variable) {
                return ((Variable) e1).getName().equals(((Variable) e2).getName());
            } else if (e1 instanceof Number) {
                return ((Number) e1).getValue() == ((Number) e1).getValue();
            } else {
                return areEqual(e1.expLeft, e2.expLeft) && areEqual(e1.expRight, e2.expRight);
            }
        } else return e1 == null && e2 == null;
    }

    /**
     *
     * @return
     */
    public abstract Exp copy();

    /**
     *
     * @return
     * @throws Exception
     */
    public abstract double evaluate() throws Exception;

    /**
     *
     * @return
     */
    public abstract Exp simplify();

    /**
     *
     * @return
     */
    public Exp fullSimplify() {
        Exp last = this.copy();
        Exp actual = this;
        do {
            last = actual.copy();
            actual = actual.simplify();
        } while (!areEqual(last, actual));
        return actual;
    }

    /**
     *
     * @return
     */
    @Override
    public abstract String toString();

    /**
     *
     * @return
     */
    public abstract String toLatex();

    /**
     *
     * @return
     */
    public abstract String toLatexTree();

    /**
     *
     * @param e
     */
    public void setLeft(Exp e) {
        this.expLeft = e;
    }

    /**
     *
     * @param e
     */
    public void setRight(Exp e) {
        this.expRight = e;
    }

    /**
     *
     * @param left
     * @param right
     */
    public void setBoth(Exp left, Exp right) {
        setLeft(left);
        setRight(right);
    }

    /**
     *
     * @param args
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void main(String[] args) throws Exception {
        Exp generated = EquationGenerator.generateEquation(4);


        Exp eq_mult, eq_equals, simplified;
        //eq_mult = new Plus(new Plus(new Number(1), new Times(new Number(0), new Variable("x"))), new Number(4));
        eq_mult = new Minus(new Times(new Minus(new Number(4), new Number(1)), new Number(0)), new Minus(new Number(0), new Number(1)));
        eq_equals = new Equals(new Plus(new Times(new Variable("x"), new Number(7)), new Number(2)), new Number(6));

        System.out.println("Print         : " + eq_mult.toString());
        System.out.println("Parse 3       : " + Parser.parse("3"));
        System.out.println("Parse 3.4     : " + Parser.parse("3.4"));
        System.out.println("Parse 13.3/12 : " + Parser.parse("13.3/12").evaluate());
    }
}
