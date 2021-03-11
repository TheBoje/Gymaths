package com.example.gymaths.equations;

import org.jetbrains.annotations.NotNull;

/**
 * Implémentation du type Opérateur pour les <code>Exp</code>
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Operator extends Exp {
    /*
    Il serait bien plus cohérent de rendre cette classe abstraite pour des raisons
    d'implémentations, cependant, pour pouvoir comparer les types avec les arbres de reférence,
    il est nécessaire que cette classe soit instanciable.

    FIXME: Comme pour le cas de la classe Ignored, il faudrait faire une classe qui est
     instanciable et qui correspond à tous les opérateurs uniquement.

    Vincent toi qui regarde ce délice, sache que je ne suis pas fier.
    */

    /**
     * Contructeur de l'expression suivant la structure d'un AST.
     * Même si Operator est instanciable, son utilisation en tant qu'objet instancié doit être
     * limité au test comparaison dans les différentes opérations de simplification.
     * TODO: Rendre Operator une classe abstraite et ajouter une nouvelle classe
     * (IgnoredOperator?) pour la remplacer pour les comparaisons des opérations de simplification.
     * @param expLeft Arbre d'expression gauche
     * @param expRight Arbre d'expression droit
     */
    public Operator(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    /**
     * Retourne l'opérateur opposé à opérateur instancié, i.e un objet Divide retourne un objet
     * Times.
     * @return Arbre de type opposé au type instancié contenant les mêmes sous-arbres
     */
    public Operator opposite() {
        throw new UnsupportedOperationException();
    }

    /**
     * Permet de faire une "copie profonde" (deep copy) de l'objet. À implémenter dans les
     * sous-classes.
     * @return Retourne une copie profonde de l'arbre
     */
    @Override
    public Exp copy() {
        throw new UnsupportedOperationException();
    }

    /**
     * Évalue l'expression
     * @return Valeur de l'expression
     * @throws Exception si l'arbre contient une variable ou une division par 0
     */
    @Override
    public double evaluate() throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Lance une itération de simplification de l'arbre
     * @return Retourne l'arbre simplifié
     */
    @Override
    public Exp simplify() {
        throw new UnsupportedOperationException();
    }

    /**
     * Affiche l'expression à partir de l'arbre
     * @return Retourne le string contenant l'expression
     */
    @NotNull
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    /**
     * Affiche le mot en LaTeX de l'expression
     * @return Retourne le string LaTeX de l'expression
     */
    @Override
    public String toLatex() {
        throw new UnsupportedOperationException();
    }

    /**
     * Affiche le mot en LaTeX pour dessiner l'arbre en suivant la méthode suivante proposé sur
     * <a href="https://tex.stackexchange.com/a/5451">tex.stackexchange.com/</a>
     * @return Retourne le string LaTeX de l'arbre
     */
    @Override
    public String toLatexTree() {
        throw new UnsupportedOperationException();
    }

    /**
     * Opération de rotation vers la droite de l'arbre
     * respectant l'équivalence d'une équation.
     * 
     *      P             P
     *     / \           / \
     *    Q   w  <=>    u  Q-1
     *   / \               / \
     *  u   v             w   v
     * 
     * où Q-1 correspond à l'opération inverse de Q
     * 
     * <p> exemple :
     * x*a + b = c <=> x*a = c - b
     * 
     *        =                 _=_
     *       / \               /   \
     *      +   c             *     -
     *     / \               / \   / \
     *    *   b    <=>      x   a c   b
     *   / \
     *  x   a
     * </p>
     */
    public void clRotateRight() {
        if (this.expLeft != null && this.expLeft instanceof Operator) {
            Operator p = ((Operator) this.expLeft).opposite(); // créer la méthode qui génère l'opérateur opposé
            Exp u = p.expLeft;
            Exp v = p.expRight;
            Exp w = this.expRight;

            p.setBoth(w, v);
            this.setBoth(u, p);
        }
    }

    /**
     * Opération de rotation vers la droite de l'arbre.
     * TODO: Expliciter
     */
    public void clRotateLeft() {
        if (this.expRight != null && this.expRight instanceof Operator) {
            Operator p = ((Operator) this.expRight).opposite();
            Exp u = this.expLeft;
            Exp v = p.expLeft;
            Exp w = p.expRight;

            p.setBoth(u, w);
            this.setBoth(p, v);
        }
    }
}
