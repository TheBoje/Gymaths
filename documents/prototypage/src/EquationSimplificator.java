public class EquationSimplificator {
    // https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java
    // Multiplication par 0 :
    private final static Exp mult_0 = new Times(new Variable(null), new Number(0));
    private final static Exp mult_0_solved = new Number(0);

    /**
     *
     * @param cible
     * @param modele
     * @return
     */
    private static boolean matchWith(Exp cible, Exp modele)
    {
        if (cible == null){
            return true;
        }
        else if (cible.getClass().getName().equals(modele.getClass().getName())){ // TODO C'est l'approche de vincent et je ne cautionne pas un tel déchet de code
            if (modele instanceof Number) // Dans le cas ou le noeud est un nombre
            {
                return ((Number) cible).getValue() == ((Number) modele).getValue();
            }
            else
            {
                return matchWith(cible.expLeft, modele.expLeft) && matchWith(cible.expRight, modele.expRight);
            }
        }
        else
        {
            return false;
        }
    }

    public static boolean matchWithMult(Exp cible)
    {
        return matchWith(cible, mult_0); // || matchWith(cible.expLeft, mult_0) || matchWith(cible.expRight, mult_0);
    }

    public static Exp remplaceExp(Exp cible, Exp modele){
        if (modele instanceof Number)
        {
            return new Number(((Number) modele).getValue());
        } else if (modele instanceof  Variable)
        {
            return null; // TODO Left here
            // TODO : passer par un gros switch qui récupère la bonne
            // structure au lieu d'utiliser un modèle de sortie.
        }
    }

    public static Exp solveMult(Exp cible)
    {
        if (matchWithMult(cible))
        {

        }
    }


    //public static Exp simplify(Exp exp){
        //if (matchWith(exp, mult_0))
    //}
}
