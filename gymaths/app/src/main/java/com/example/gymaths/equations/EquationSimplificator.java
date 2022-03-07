package com.example.gymaths.equations;

/**
 * Classe abstraite contenant certaines classes nécessaires à la simplifications d'équations de
 * type {@code Exp}.
 *
 * @author Vincent Commin & Louis Leenart
 */
public abstract class EquationSimplificator {


    // TODO Inverser les fils de chaque noeud (sauf pour division?) pour pouvoir 
    // faire le test dans tous les cas de structuration du l'input

    /**
     * Compare les {@code Exp cible} et {@code modele} pour déterminer si les deux arbres sont
     * identiques (ou équivalents).
     *
     * @param cible Arbre d'expression à comparer
     * @param modele Arbre d'expression modèle
     * @return booléen, vrai si les deux arbres sont égaux ou équivalents, faux le cas contraire
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
