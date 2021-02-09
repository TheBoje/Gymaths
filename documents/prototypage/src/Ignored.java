public class Ignored extends Exp{

    /*
        Cette classe permet de passer à travers la 
        contrainte de pattern matching et d'instanciation
        que présente la classe Exp (qui est abstraite).
        On utilise cette classe comme noeud d'une branche
        indéfinie, càd dont on ignore les valeurs (car 
        les-dites valeurs sont indifférentes au résultat).

        TODO: S'assurer que l'on utilise pas ce noeud dans 
        une expression finale.
    */

    // Ce noeud ne contient ni valeur ni enfants.
    public Ignored()
    {
        super(null, null);
    }

    @Override
    public float evaluate() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public Exp simplify() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String print() {
        return "[ignored]";
    }

    @Override
    public String toLatex() {
        return "[ignored]";
    }
    
}
