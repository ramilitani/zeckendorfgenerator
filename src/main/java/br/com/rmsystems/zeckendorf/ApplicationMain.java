package br.com.rmsystems.zeckendorf;

import br.com.rmsystems.zeckendorf.app.ZeckendorfNumberGenerator;
import br.com.rmsystems.zeckendorf.model.FibonacciNumber;

import java.util.List;

/**
 *
 */
public class ApplicationMain {

    public static void main(String[] args)
    {
        System.out.println("Initializing the ZeckendorfNumberGenerator application");
        if (args == null || args.length != 2)
            throw new RuntimeException("Must have 2 integer arguments");

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (a >= b ) {
            throw new RuntimeException("The first argument must be less than the second argument");
        }

        ZeckendorfNumberGenerator generator = new ZeckendorfNumberGenerator();
        List<List<FibonacciNumber>> sumList = generator.getZeckendorfRepresentation(a,b);
        print(sumList, a);

    }

    /**
     * Print only the numbers
     * @param fibonacciNumberList
     */
    private static void print(List<List<FibonacciNumber>> fibonacciNumberList, int start)
    {
        for (int i = 0; i < fibonacciNumberList.size(); i++) {
            System.out.print( "Number " + start + "\t: ");
            for (int j = 0; j < fibonacciNumberList.get(i).size(); j ++) {
                System.out.print(fibonacciNumberList.get(i).get(j).getNumber() + " ");
            }
            System.out.print("\t\t\t| ");
            printZeckendorfRepresentation(fibonacciNumberList.get(i));
            System.out.println();
            start++;
        }
    }

    /**
     * Print in a zeckendorf representation
     * @param fibonacciNumberList
     */
    private static void printZeckendorfRepresentation(List<FibonacciNumber> fibonacciNumberList)
    {
        if (!fibonacciNumberList.isEmpty()) {
            int index = fibonacciNumberList.get(0).getIndex();
            int size = fibonacciNumberList.size();
            int i = 0;
            FibonacciNumber fibonacciNumber = null;
            while (index>0) {
                if (i < size) {
                    fibonacciNumber = fibonacciNumberList.get(i);
                    i++;
                }
                if(index == fibonacciNumber.getIndex()) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                index--;
            }
        }
    }
}
