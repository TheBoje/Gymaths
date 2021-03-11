package com.example.gymaths.equations;

import org.jetbrains.annotations.NotNull;

/**
 * Implémentation de l'opération de division pour les <code>Exp</code>
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

    /**
     * Permet de faire une "copie profonde" (deep copy) de l'objet. À implémenter dans les
     * sous-classes.
     * @return Retourne une copie profonde de l'arbre
     */
    @Override
    public Exp copy() {
        return new Divide(this.expLeft.copy(), this.expRight.copy());
    }

    /**
     * Évalue l'expression
     * @return Valeur de l'expression
     * @throws Exception Si <code>expRight</code> est évalué à 0, alors on ne peut pas évaluer
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

    /**
     *
     * @return
     */
    @Override
    public Operator opposite() {
        return new Times(this.expLeft, this.expRight);
    }

    /**
     *
     * @return
     */
    // TODO This
    @Override
    public Exp simplify() {
        return new Divide(this.expLeft.simplify(), this.expRight.simplify());
    }

    /**
     *
     * @return
     */
    @NotNull
    @Override
    public String toString() {
        return String.format("(%s / %s)", this.expLeft.toString(), this.expRight.toString());
    }

    /**
     *
     * @return
     */
    @Override
    public String toLatex() {
        return String.format("\\frac{%s}{%s}", this.expLeft.toLatex(), this.expRight.toLatex());
    }

    /**
     *
     * @return
     */
    @Override
    public String toLatexTree() {
        return String.format("[./ %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
    }
}
