package br.com.rmsystems.zeckendorf.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import br.com.rmsystems.zeckendorf.app.ZeckendorfNumberGenerator.FibonacciNumber;

@RunWith(JUnitPlatform.class)
public class ZeckendorfNumberGeneratorTest {

    static ZeckendorfNumberGenerator zeckendorfNumberGenerator;
    static List<ZeckendorfNumberGenerator.FibonacciNumber> sumFibonacciNumberList;
    static List<List<Integer>> listOfAllIntegers;

    @BeforeAll
    public static void init() {
        zeckendorfNumberGenerator = new ZeckendorfNumberGenerator();
        sumFibonacciNumberList = new ArrayList<>();
        listOfAllIntegers = new ArrayList<>();
    }

    @Test
    public void getTheGreatestFibonacciNumberLessThanOrEqualToN() {
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(0), 0);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(1), 1);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(2), 2);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(3), 3);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(4), 3);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(5), 5);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(6), 5);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(7), 5);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(8), 8);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(9), 8);
        assertEquals(zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(10), 8);
    }

    @Test
    public void getTheSumFibonacciNumbersList() {

        sumFibonacciNumberList = zeckendorfNumberGenerator.getSumFibonacciNumbersList(0);
        assertTrue(sumFibonacciNumberList.isEmpty());
        sumFibonacciNumberList = zeckendorfNumberGenerator.getSumFibonacciNumbersList(1);
        assertTrue(hasElement(sumFibonacciNumberList,1));
        sumFibonacciNumberList = zeckendorfNumberGenerator.getSumFibonacciNumbersList(2);
        assertTrue(hasElement(sumFibonacciNumberList,2));
        sumFibonacciNumberList = zeckendorfNumberGenerator.getSumFibonacciNumbersList(3);
        assertTrue(hasElement(sumFibonacciNumberList,3));
        sumFibonacciNumberList = zeckendorfNumberGenerator.getSumFibonacciNumbersList(5);
        assertTrue(hasElement(sumFibonacciNumberList,5));
        sumFibonacciNumberList = zeckendorfNumberGenerator.getSumFibonacciNumbersList(6);
        assertTrue(hasElement(sumFibonacciNumberList,5));
        assertTrue(hasElement(sumFibonacciNumberList,1));
        sumFibonacciNumberList = zeckendorfNumberGenerator.getSumFibonacciNumbersList(10);
        assertTrue(hasElement(sumFibonacciNumberList,8));
        assertTrue(hasElement(sumFibonacciNumberList,2));
    }

    @Test
    public void mustBeReturnTheZeckendorfRepresentationOfAllIntegers() {

        assertList(0,1);
        assertList(0,2);
        assertList(0,3);
        assertList(0,5);
    }

    public void assertList(int a, int b) {

        List<List<FibonacciNumber>> listOfAllIntegers = zeckendorfNumberGenerator.getZeckendorfRepresentation(a,b);
        while (a < b) {
            if (a == 0) {
                assertTrue(listOfAllIntegers.get(a).isEmpty());
            } else {
                assertTrue(hasElement(listOfAllIntegers.get(a),
                        zeckendorfNumberGenerator.findTheGreatestFibonacciNumber(a)));
            }
            a++;
        }
    }

    private boolean hasElement(List<FibonacciNumber> fibonacciNumbers, int number) {
        boolean result = false;
        for (FibonacciNumber fibonacciNumber : fibonacciNumbers) {
            if (fibonacciNumber.getNumber() == number) {
                result = true;
                break;
            }
        }
        return result;
    }
}
