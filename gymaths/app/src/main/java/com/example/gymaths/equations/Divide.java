package com.example.gymaths.equations;

/**
 * Implémentation de l'opération de division pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Divide extends Operator {

    /**
     * Constructeur de l'opération de division
     * @param expLeft Sous-arbre gauche
     * @param expRight Sous-arbre droit
     */
    public Divide(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }


    @Override
    public Exp copy() {
        return new Divide(this.expLeft.copy(), this.expRight.copy());
    }

    /**
     * Évalue l'expression
     * @return Valeur de l'expression
     * @throws Exception Si {@code expRight} est évalué à 0, alors on ne peut pas évaluer
     * l'expression pour cet opérateur. Sinon, exception montante de l'évaluation d'un des
     * sous-arbres
     */
    @Override
    public double evaluate() throws Exception {
        double evaluateLeft = this.expLeft.evaluate();
        double evaluateRight = this.expRight.evaluate();
        if (evaluateRight == 0.0)
        {
            throw new UnsupportedOperationException();
        } else {
            return evaluateLeft / evaluateRight;
        }
    }

    @Override
    public Operator opposite() {
        return new Times(this.expLeft, this.expRight);
    }


    // TODO: Implémenter les différentes opérations de simplifications
    @Override
    public Exp simplify() {
        return new Divide(this.expLeft.simplify(), this.expRight.simplify());
    }


    @Override
    public String toString() {
        return String.format("(%s / %s)", this.expLeft.toString(), this.expRight.toString());
    }


    @Override
    public String toLatex() {
        return String.format("\\frac{%s}{%s}", this.expLeft.toLatex(), this.expRight.toLatex());
    }


    @Override
    public String toLatexTree() {
        return String.format("[./ %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
    }
}
