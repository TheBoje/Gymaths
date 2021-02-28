public class Operator extends Exp {
    /*
        Il serait bien plus cohérent de rendre
        cette classe abstraite pour des raisons 
        d'implémentations, cependant, pour pouvoir
        comparer les types avec les arbres de re-
        férence, il est nécessaire que cette classe
        soit instanciable.
        - FIXME: Comme pour le cas de la classe
        Ignored, il faudrait faire une classe qui 
        est instanciable et qui correspond à tous
        les opérateurs uniquement. 
        Vincent toi qui regarde ce délice, sache
        que je ne suis pas fier.
    */
    private static final int precedence = 0; // TODO Mettre à jour pour chaque opérateur

    public Operator(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

    public boolean isRightAssociative(){ // TODO Mettre à jour pour chaque opérateur
        
    }

    public char getSymbol(){ // TODO Mettre à jour pour chaque opérateur
        return 'a';
    }

    public int comparePrecedence(Exp o)// TODO Mettre à jour pour chaque opérateur
    {
        if (o instanceof Operator)
        {
            Operator other = (Operator) o;
            return precedence > other.precedence ? 1 :
                    other.precedence == precedence ? 0 : -1;
        }
        else{
            return -((Operator)o).comparePrecedence(this);
        }
    }


	public Operator opposite()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Exp copy() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    @Override
    public String toLatex() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toLatexTree() {
        throw new UnsupportedOperationException();
    }
 
    public void clRotateRight()
	{
		if(this.expLeft != null && this.expLeft instanceof Operator)
		{
			Operator p = ((Operator) this.expLeft).opposite(); // créer la méthode qui génère l'opérateur opposé
			Exp u = p.expLeft;
			Exp v = p.expRight;
			Exp w = this.expRight;

			p.setBoth(w, v);
			this.setBoth(u, p);
		}
    }
    
    public void clRotateLeft()
    {
        if(this.expRight != null && this.expRight instanceof Operator)
        {
            Operator p = ((Operator)this.expRight).opposite();
            Exp u = this.expLeft;
            Exp v = p.expLeft;
            Exp w = p.expRight;

            p.setBoth(u, w);
            this.setBoth(p, v);
        }
    }
}
