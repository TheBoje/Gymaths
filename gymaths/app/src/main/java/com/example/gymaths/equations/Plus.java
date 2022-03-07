package com.example.gymaths.equations;

/**
 * Implémentation de l'opération Plus pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Plus extends Operator {
    /** Modèle pour comparaison dans le cadre de la simplification. */
    private static final Exp plus_0 = new Plus(new Ignored(), new Number(0));

    /**
     * Constructeur de l'opération Plus
     *
     * @param expLeft  Sous-arbre gauche
     * @param expRight Sous-arbre droit
     */
    public Plus(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    @Override
    public Exp copy() {
        return new Plus(this.expLeft != null ? this.expLeft.copy() : null, this.expRight != null ? this.expRight.copy() : null);
    }

    @Override
    public double evaluate() throws Exception {
        return this.expLeft.evaluate() + this.expRight.evaluate();
    }

    @Override
    public Operator opposite() {
        return new Minus(this.expLeft, this.expRight);
    }

    // TODO: Implémenter les différentes opérations de simplifications
    @Override
    public Exp simplify() {
        if (EquationSimplificator.matchWith(this, plus_0)) {
            if (this.expLeft instanceof Number && ((Number) this.expLeft).getValue() == 0) {
                return this.expRight;
            } else {
                return this.expLeft;
            }
        }
        return new Plus(this.expLeft.simplify(), this.expRight.simplify());
    }

    @Override
    public String toString() {
        return String.format("%s + %s", this.expLeft.toString(), this.expRight.toString());
    }

    @Override
    public String toLatex() {
        return String.format("%s+%s", this.expLeft.toLatex(), this.expRight.toLatex());
    }

    @Override
    public String toLatexTree() {
        return String.format("[.+ %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
    }
}
