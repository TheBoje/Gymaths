package com.example.gymaths.equations;

public class UnbalancedEqualException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 8900678354832314636L;

    public void print() {
        System.out.println("Evaluation failed: Equals node needs the variable to be immediatly after");
    }
}
