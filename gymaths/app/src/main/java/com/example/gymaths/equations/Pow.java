package com.example.gymaths.equations;

/**
 * Implémentation de l'opération Puissance pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Pow extends Operator {

    /**
     * Constructeur de l'opération Puissance
     *
     * @param expLeft  Sous-arbre gauche
     * @param expRight Sous-arbre droit
     */
    public Pow(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    @Override
    public Exp copy() {
        return new Pow(this.expLeft.copy(), this.expRight.copy());
    }

    @Override
    public double evaluate() throws Exception {
        return (float) Math.pow(this.expLeft.evaluate(), this.expRight.evaluate());
    }

    @Override
    public Operator opposite() {
        // TODO: ajouter l'implémentation apres l'ajout de sqrt
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
