package com.example.gymaths.equations;

public abstract class EquationSimplificator {
    // Sources : 
    // https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java
    // https://cr.openjdk.java.net/~briangoetz/amber/pattern-match.html


    // TODO Inverser les fils de chaque noeud (sauf pour division?) pour pouvoir 
    // faire le test dans tous les cas de structuration du l'input

    /**
     * @param cible
     * @param modele
     * @return
     */
    public static boolean matchWith(Exp cible, Exp modele) {
        if (cible == null && modele == null) {
            return true;
        } else if (cible == null || modele == null) { // Cas ou un des deux arbre est null et pas donc pas l'autre
            return false;
        } else if (cible.getClass() == modele.getClass()
                || modele.getClass().isAssignableFrom(cible.getClass())
                || modele instanceof Ignored) {
            if (modele instanceof Number && cible instanceof Number) // Dans le cas ou le noeud est un nombre
            {
                return ((Number) cible).getValue() == ((Number) modele).getValue();
            } else if (modele instanceof Ignored) {
                return true;
            } else {
                return (matchWith(cible.expLeft, modele.expLeft) && matchWith(cible.expRight, modele.expRight)) || (matchWith(cible.expRight, modele.expLeft) && matchWith(cible.expLeft, modele.expRight));
            }
        } else {
            return false;
        }
    }
}
