package com.example.gymaths.equations;

import org.jetbrains.annotations.NotNull;

/**
 * La classe Number correspond au nombre réels de
 * l'arbre de syntaxe. Cette classe sera toujours une feuille
 * de l'arbre.
 */
public class Number extends Leaf {
    private final float value;

    public Number(float value) {
        super(null, null);
        this.value = value;
    }

    @Override
    public Exp copy() {
        return new Number(this.getValue());
    }

    /**
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

    /**
     * On retourne le noeud car le nombre est déjà au
     * maximum de la simplification.
     * @return le noeud
     */
    @Override
    public Exp simplify() {
        return this;
    }

    @NotNull
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
