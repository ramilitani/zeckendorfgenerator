package br.com.rmsystems.zeckendorf.model;

/**
 *
 */
public class FibonacciNumber {

    private int number;
    private int index;

    public FibonacciNumber(int number, int index) {
        this.number = number;
        this.index = index;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
