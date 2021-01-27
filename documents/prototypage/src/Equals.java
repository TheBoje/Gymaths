public class Equals extends Exp {
	int value;

	public Equals(int value) {
		super(null, null);
		this.value = value;
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
