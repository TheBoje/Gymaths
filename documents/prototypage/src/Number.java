public class Number extends Exp {
	private int value;

	public Number(int value) {
		super(null, null);
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}

	@Override
	public float evaluate() {
		return this.value;
	}

	@Override
	public String print() {
		return Integer.toString(value);
	}

	@Override
	public String toLatex() {
		return Integer.toString(value);
	}

	@Override
	public void simplify() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
