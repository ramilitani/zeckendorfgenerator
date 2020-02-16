package br.com.rmsystems.zeckendorf.app;

import java.util.ArrayList;
import java.util.List;
import br.com.rmsystems.zeckendorf.model.FibonacciNumber;

/**
 *
 */
public class ZeckendorfNumberGenerator {

    private static int index;

    /**
     *
     * @param n
     * @return
     */
    public int findTheGreatestFibonacciNumber(int n)
    {
        if (n == 0 || n == 1) {
            return n;
        }

        index = 1;
        int init = 0, previous = 1, last = 1;
        while (last <= n) {
            init = previous;
            previous = last;
            last = init + previous;
            index++;

        }
        return previous;
    }

    /**
     *
     * @param n
     * @return
     */
    public List<FibonacciNumber> getSumFibonacciNumbersList(int n)
    {
        List<FibonacciNumber> sumFibonacciNumberList = new ArrayList<>();
        while (n > 0) {
            int number = findTheGreatestFibonacciNumber(n);
            sumFibonacciNumberList.add(new FibonacciNumber(number, index));
            index = 1;
            n = n - number;
        }
        return sumFibonacciNumberList;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public List<List<FibonacciNumber>> getZeckendorfRepresentation(int a, int b)
    {
        List<List<FibonacciNumber>> sumListForAllIntegers = new ArrayList<>();
        while (a < b) {
            sumListForAllIntegers.add(getSumFibonacciNumbersList(a));
            a++;
        }
        return sumListForAllIntegers;
    }
}
