package com.example.gymaths.equations;

import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * Cette classe permet de manipuler les expressions mathématiques utilisés dans le cadre de
 * l'application Gymaths.
 *
 * @author Vincent Commin & Louis Leenart
 */
public abstract class Exp {
    /*
    * Le but est de pouvoir générer, résoudre, simplifier et afficher les expressions pour d'un
    * côté mettre au point des exercices, et comparer les résultats avec les propositions de
    * l'utilisateur.
    *
    * La structure utilisé pour répondre à ce problème est l'utilisation d'AST (arbre abstrait de
    * syntaxe) dont chaque noeud représente un opérateur et chaque feuille représente un nombre ou
    * une variable. On utilise aussi le principe de polymorphisme pour ajouter des opérations aisément.
    *
    * Plus particulièrement, notre implémentation comporte deux sous arbres représentés par les
    * attributs expLeft et expRight.
    *
    * */
    public Exp expLeft;
    public Exp expRight;

    /**
     * Contructeur de l'expression suivant la structure d'un AST.
     * @param expLeft Arbre d'expression gauche
     * @param expRight Arbre d'expression droit
     */
    public Exp(Exp expLeft, Exp expRight) {
        this.expLeft = expLeft;
        this.expRight = expRight;
    }

    /**
     * Compare si deux expressions sont égales algébriquement
     * @param exp1 expression à comparer avec <code>exp2</code>
     * @param exp2 expression à comparer avec <code>exp1</code>
     * @return Booléen : true si <code>exp1</code> et <code>exp2</code> sont identiques
     * algébriquement, false dans le cas contraire.
     */
    public static boolean areEqual(Exp exp1, Exp exp2) {
        // Vérification que l'on est pas au bout de l'arbre et que les deux Exp sont de même type
        if ((exp1 != null && exp2 != null) && exp1.getClass().getName().equals(exp2.getClass().getName())) {
            // Dans le cas d'une variable, on vérifie que le nom est le même, pour le moment peu
            // utile, mais sera important si utilisation de plusieurs variables.
            if (exp1 instanceof Variable) {
                return ((Variable) exp1).getName().equals(((Variable) exp2).getName());
            // Dans le cas d'un nombre, on vérifie que la valeur est identique
            } else if (exp1 instanceof Number) {
                return ((Number) exp1).getValue() == ((Number) exp1).getValue();
            } else {
                // Descente de la demande de vérification d'égalité
                return areEqual(exp1.expLeft, exp2.expLeft) && areEqual(exp1.expRight, exp2.expRight);
            }
        } else return (exp1 == null && exp2 == null);
    }

    /**
     * Permet de faire une "copie profonde" (deep copy) de l'objet. À implémenter dans les
     * sous-classes.
     * @return Retourne une copie profonde de l'arbre
     */
    public abstract Exp copy();

    /**
     * Évalue l'expression
     * @return valeur de l'expression
     * @throws Exception si l'arbre contient une variable ou une division par 0
     */
    public abstract double evaluate() throws Exception;

    /**
     * Lance une itération de simplification de l'arbre
     * @return Retourne l'arbre simplifié
     */
    public abstract Exp simplify();

    /**
     * Simplifie entièrement l'arbre dans la mesure des opérations de simplification implémentées
     * @return Retourne l'arbre simplifié
     */
    public Exp fullSimplify() {
        Exp last;
        Exp actual = this;
        do {
            last = actual.copy();
            actual = actual.simplify();
        } while (!areEqual(last, actual));
        return actual;
    }

    /**
     * Affiche l'expression à partir de l'arbre
     * @return Retourne le string contenant l'expression
     */
    @Override
    public abstract String toString();

    /**
     * Affiche le mot en LaTeX de l'expression
     * @return Retourne le string LaTeX de l'expression
     */
    public abstract String toLatex();

    /**
     * Affiche le mot en LaTeX pour dessiner l'arbre en suivant la méthode suivante proposé sur
     * <a href="https://tex.stackexchange.com/a/5451">tex.stackexchange.com/</a>
     * @return Retourne le string LaTeX de l'arbre
     */
    public abstract String toLatexTree();


    /**
     * Remplace les deux sous-arbres par respectivement <code>left</code> et <code>right</code>.
     * @param left nouveau sous-arbre gauche
     * @param right nouveau sous-arbre droit
     */
    public void setBoth(Exp left, Exp right) {
        this.expLeft = left;
        this.expRight = right;
    }

    /**
     * Zone de tests
     * @param args non utilisé ici
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void main(String[] args) throws Exception {
        Exp generated = EquationGenerator.generateEquation(4);


        Exp eq_mult, eq_equals, simplified;
        eq_mult = new Minus(new Times(new Minus(new Number(4), new Number(1)), new Number(0)), new Minus(new Number(0), new Number(1)));
        eq_equals = new Equals(new Plus(new Times(new Variable("x"), new Number(7)), new Number(2)), new Number(6));

        System.out.println("Print         : " + eq_mult.toString());
        System.out.println("Parse 3       : " + Parser.parse("3"));
        System.out.println("Parse 3.4     : " + Parser.parse("3.4").toLatexTree());
        System.out.println("Parse 13.3/12 : " + Parser.parse("13.3/12").evaluate());
    }
}
