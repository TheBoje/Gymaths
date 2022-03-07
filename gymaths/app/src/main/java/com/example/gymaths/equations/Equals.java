package com.example.gymaths.equations;


/**
 * Implémentation de l'opération d'égalité pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Equals extends Operator {
    /** Modèle pour comparaison dans le cadre de la simplification. On utilise equals_cl pour
     * vérifier si l'arbre qu'on tente de simplifier suit ce modèle, et si c'est le cas, alors on
     * peut modifier l'arbre. L'idée est d'ajouter ces "patterns" pour implémenter de nouvelles
     * formes de simplifications plus complexes.
     * Note: Les objets Operator et Ignored représentent respectivement un opérateur quelconque
     * et un noeud quelconque.
     */
    private static final Exp equals_cl = new Equals(new Operator(new Ignored(), new Ignored()), new Ignored());

    /**
     * Contructeur de l'élément d'égalité
     * @param expLeft Sous-arbre gauche
     * @param expRight Sous-arbre droit
     */
    public Equals(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }


    @Override
    public Exp copy() {
        return new Equals(this.expLeft.copy(), this.expRight.copy());
    }

    /**
     * Évalue l'expression
     * On note que si l'arbre n'est pas équilibré de telle sorte qu'un des sous-arbre est
     * uniquement une variable et que l'autre est l'expression à évaluer, alors on ne peut pas
     * (avec l'implémentation actuelle) évaluer l'égalité.
     * @return Valeur de l'expression
     * @throws Exception Division par 0 ou présence d'une variable.
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


    @Override
    public String toString() {
        return String.format("%s = %s", this.expLeft.toString(), this.expRight.toString());
    }


    @Override
    public String toLatex() {
        return String.format("%s=%s", this.expLeft.toLatex(), this.expRight.toLatex());
    }


    // TODO: Implémenter les différentes opérations de simplifications
    @Override
    public Exp simplify() {
        if (EquationSimplificator.matchWith(this, equals_cl)) {
            this.clRotateRight();
            return new Equals(this.expLeft.simplify(), this.expRight.simplify());
        } else {
            return new Equals(this.expLeft.simplify(), this.expRight.simplify());
        }

    }


    @Override
    public String toLatexTree() {
        return String.format("[.= %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
    }

}
