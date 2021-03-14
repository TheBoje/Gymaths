package com.example.gymaths.equations;

/**
 * Type contenant les feuilles pour les {@code Exp}
 *
 * @author Vincent Commin & Louis Leenart
 */
public abstract class Leaf extends Exp {
    /*
     * La classe Leaf permet de regrouper toutes les classes héritant de la classe Exp qui se
     * retrouveront obligatoirement en tant que feuille de l'arbre de syntaxe. On se sert donc de
     * cette classe pour le pattern matching afin de pouvoir simplifier les opérations.
     */

    /**
     * Constructeur de feuille
     */
    public Leaf(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }
}
