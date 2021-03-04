package com.example.gymaths.equations;

public class Number extends Leaf {
    private final float value;

    public Number(float value) {
        super(null, null);
        this.value = value;
    }

    @Override
    public Exp copy() {
        return new Number(this.getValue());
    }

    public float getValue() {
        return this.value;
    }

    @Override
    public double evaluate() {
        return this.value;
    }

    // TODO This
    @Override
    public Exp simplify() {
        return this;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }

    @Override
    public String toLatex() {
        return Float.toString(value);
    }


    @Override
    public String toLatexTree() {
        return String.format("%s", this.toString());
    }

}
