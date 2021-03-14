package com.example.gymaths.equations;

/**
 * Implémentation de l'opération de multiplication pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Times extends Operator {
    /** Modèle pour comparaison dans le cadre de la simplification. */
    private static final Exp times_0 = new Times(new Ignored(), new Number(0));

    // TODO: peut être trouver un moyen de mettre uniquement une seule?
    private static final Exp distribPlus = new Times(new Plus(new Ignored(), new Ignored()), new Ignored());
    private static final Exp distribMinus = new Times(new Minus(new Ignored(), new Ignored()), new Ignored());

    /**
     * Constructeur de l'opération de multiplication
     *
     * @param expLeft  Sous-arbre gauche
     * @param expRight Sous-arbre droit
     */
    public Times(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    @Override
    public Exp copy() {
        return new Times(this.expLeft != null ? this.expLeft.copy() : null, this.expRight != null ? this.expRight.copy() : null);
    }

    @Override
    public double evaluate() throws Exception {
        return this.expLeft.evaluate() * this.expRight.evaluate();
    }

    @Override
    public Operator opposite() {
        // TODO: Eval expRight == 0 ? (pour éviter la div par 0)
        return new Divide(this.expLeft, this.expRight);
    }

    @Override
    public Exp simplify() {
        if (EquationSimplificator.matchWith(this, times_0)) {
            return new Number(0);
        } else if (EquationSimplificator.matchWith(this, distribPlus) && this.expLeft.expLeft != null && this.expLeft.expRight != null ) {
            return new Plus(new Times(this.expLeft.expLeft.simplify(), this.expRight), new Times(this.expLeft.expRight.simplify(), this.expRight));
        } else if (EquationSimplificator.matchWith(this, distribMinus) && this.expLeft.expLeft != null && this.expLeft.expRight != null) {
            return new Minus(new Times(this.expLeft.expLeft.simplify(), this.expRight), new Times(this.expLeft.expRight.simplify(), this.expRight));
        } else // ajouter des else if () avec les autres cas pour ajouter des cas de simplification
        {
            return new Times(this.expLeft.simplify(), this.expRight.simplify());
        }
    }

    @Override
    public String toString() // FIXME: A améliorer, utiliser la priorité des opérations et leur
    // précédence pour déterminer si la parenthèse est nécessaire. La méthode actuelle ne permet
    // pas d'afficher un nombre minimal de parenthèses et est peut-être responsable de problèmes
    // d'affichage.
    {
        if (this.expLeft instanceof Leaf && this.expRight instanceof Leaf) {
            return String.format("%s * %s", this.expLeft.toString(), this.expRight.toString());
        } else if (this.expLeft instanceof Leaf) // Cas ou juste le gauche est une feuille
        {
            return String.format("%s * (%s)", this.expLeft.toString(), this.expRight.toString());
        } else if (this.expRight instanceof Leaf) // Cas ou juste le droit est une feuille
        {
            return String.format("(%s) * %s", this.expLeft.toString(), this.expRight.toString());
        } else // Cas ou les deux fils sont des opérateurs
        {
            return String.format("(%s) * (%s)", this.expLeft.toString(), this.expRight.toString());
        }
    }

    @Override
    public String toLatex() {
        return String.format("%s*%s", this.expLeft.toLatex(), this.expRight.toLatex());
    }

    @Override
    public String toLatexTree() {
        return String.format("[.* %s %s ]", this.expLeft.toLatexTree(), this.expRight.toLatexTree());
    }
}
