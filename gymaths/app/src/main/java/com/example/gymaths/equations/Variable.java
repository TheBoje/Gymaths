package com.example.gymaths.equations;

/**
 * Implémentation de la feuille Variable pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Variable extends Leaf {
    // Conteneur du nom de la variable. ex : "x".
    private final String name;

    /**
     * Constructeur de la feuille Vombre
     *
     * @param name Nom de la variable
     */
    public Variable(String name) {
        super(null, null);
        this.name = name;
    }

    /**
     * Retourne le nom de la variable
     *
     * @return Le nom du noeud Variable
     */
    public String getName() {
        return this.name;
    }

    @Override
    public Exp copy() {
        return new Variable(this.getName());
    }

    @Override
    public double evaluate() throws VariableEvaluationException {
        throw new VariableEvaluationException();
    }

    @Override
    public Exp simplify() {
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String toLatex() {
        return this.name;
    }

    @Override
    public String toLatexTree() {
        return String.format("%s", this.name);
    }
}