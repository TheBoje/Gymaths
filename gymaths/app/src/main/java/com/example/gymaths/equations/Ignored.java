package com.example.gymaths.equations;

/**
 * Implémentation du noeud indéfini pour les {@code Exp}
 *
 * Le rôle de ce type est d'avoir à disposition un noeud indéfini pour le pattern matching dans
 * les opérations de simplification. Il est important de noter que cette classe n'est pas prévue
 * pour son utilisation dans une expression finale, mais uniquement dans le cadre de "modèle"
 * pour le pattern matching de simplification.
 *
 * @author Vincent Commin & Louis Leenart
 */
public class Ignored extends Exp {

    /*
        Cette classe permet de passer à travers la contrainte de pattern matching et
        d'instanciation que présente la classe Exp (qui est abstraite). On utilise cette classe
        comme noeud d'une branche indéfinie, càd dont on ignore les valeurs (car les-dites
        valeurs sont indifférentes au résultat).

        TODO: S'assurer que l'on utilise pas ce noeud dans une expression finale.
    */

    /**
     * Constructeur du noeud indéfini
     */
    public Ignored() {
        super(null, null);
    }

    @Override
    public Exp copy() {
        return new Ignored();
    }

    @Override
    public double evaluate() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public Exp simplify() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "[ignored]";
    }

    @Override
    public String toLatex() {
        return "[ignored]";
    }

    @Override
    public String toLatexTree() {
        return "ignored";
    }
}
