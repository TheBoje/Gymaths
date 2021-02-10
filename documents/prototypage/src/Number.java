public class Number extends Leaf {
	private int value;

	public Number(int value) {
		super(null, null);
		this.value = value;
	}

	@Override
	public Exp copy() {
		return new Number(this.getValue());
	}

	public int getValue(){
		return this.value;
	}

	@Override
	public float evaluate() {
		return this.value;
	}

	// TODO This
	@Override
	public Exp simplify() {
		return this;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}

	@Override
	public String toLatex() {
		return Integer.toString(value);
	}


	@Override
	public String toLatexTree() {
		return String.format("%s", this.toString());
	}
    
}
