package com.example.gymaths.equations;

/**
 * Implémentation de la feuille nombre pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */

public class Number extends Leaf {
    /*
     * La classe Number correspond au nombre réels de l'arbre de syntaxe. Cette classe sera
     * toujours une feuille de l'arbre.
     */


    private final float value;

    /**
     * Constructeur de la feuille Nombre
     *
     * @param value Valeur du nombre
     */
    public Number(float value) {
        super(null, null);
        this.value = value;
    }

    @Override
    public Exp copy() {
        return new Number(this.getValue());
    }

    /**
     * Valeur contenue dans la feuille
     *
     * @return La valeur du noeud Number
     */
    public float getValue() {
        return this.value;
    }

    @Override
    public double evaluate() {
        return this.value;
    }

    @Override
    public Exp simplify() {
        return this;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }

    @Override
    public String toLatex() {
        return Float.toString(value);
    }


    @Override
    public String toLatexTree() {
        return String.format("%s", this.toString());
    }

}
