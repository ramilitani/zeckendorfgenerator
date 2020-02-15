package br.com.rmsystems.zeckendorf;

import java.util.List;

public class ApplicationMain {

    public static void main(String[] args) {
        System.out.println("Initializing the ZeckendorfNumberGenerator application");
        if (args == null || args.length != 2)
            throw new RuntimeException("Must have 2 integer arguments");

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (a >= b ) {
            throw new RuntimeException("The first argument must be less than the second argument");
        }
    }
}
