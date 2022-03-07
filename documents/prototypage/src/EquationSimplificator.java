public class EquationSimplificator {
    // Sources : 
    // https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java
    // https://cr.openjdk.java.net/~briangoetz/amber/pattern-match.html
    // Multiplication par 0 :
    private final static Exp mult_0 = new Times(new Ignored(), new Number(0));
    private final static Exp add_0 = new Plus(new Ignored(), new Number(0));


    // TODO Inverser les fils de chaque noeud (sauf pour division?) pour pouvoir 
    // faire le test dans tous les cas de structuration du l'input
    /**
     *
     * @param cible
     * @param modele
     * @return
     */
    public static boolean matchWith(Exp cible, Exp modele)
    {
        if (cible == null){ // FIXME c'est un peu à chier ça non ?
            return true;
        }
        else if (modele == null)
        {
            return false;
        }
        else if ( cible.getClass() == modele.getClass()
                || modele.getClass().isAssignableFrom(cible.getClass()) 
                || modele instanceof Ignored)
        { 
            if (modele instanceof Number && cible instanceof Number) // Dans le cas ou le noeud est un nombre
            {
                return ((Number) cible).getValue() == ((Number) modele).getValue();
            }
            else if (modele instanceof Ignored)
            {
                return true;
            }
            else
            {
                return (matchWith(cible.expLeft, modele.expLeft) && matchWith(cible.expRight, modele.expRight)) || (matchWith(cible.expRight, modele.expLeft) && matchWith(cible.expLeft, modele.expRight));
            }
        }
        else
        {
            return false;
        }
    }

    public static Exp simplify(Exp exp){
        if (exp == null)
        {
            return exp;
        } 
        else if (matchWith(exp, mult_0))
        {
            return new Number(0);
        }
        else if (matchWith(exp, add_0))
        {
            // retourne le fils qui n'est pas 0
            if (exp.expLeft == new Number(0))
            {
                return exp.expRight;
            }
            else
            {
                return exp.expLeft;
            }
        }
        else // if (...) ajouter lets autres cas ici
        {
            exp.setBoth(simplify(exp.expLeft), simplify(exp.expRight));
            return exp;
        }
    }
}
