public abstract class Operator extends Exp {

    public Operator(Exp expLeft, Exp expRight) {
        super(expLeft, expRight);
    }

	public abstract Operator opposite();
    
}
