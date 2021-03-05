package com.example.gymaths.equations;
/**
 * La classe Leaf permet de regrouper toutes les classes
 * héritant de la classe Exp qui se retrouveront obligatoirement
 * en tant que feuille de l'arbre de syntaxe. 
 * On se sert donc de cette classe pour le pattern matching 
 * afin de pouvoir simplifier les opérations.
 * 
 */
public abstract class Leaf extends Exp {

    public Leaf(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }
}
