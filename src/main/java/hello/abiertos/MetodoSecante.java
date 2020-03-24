package hello.abiertos;

import java.util.function.DoubleFunction;

public class MetodoSecante {

    static DoubleFunction<Double> fn = x -> Math.exp(-x) - x;
    static DoubleFunction<Double> sm = x -> Math.pow(x, 3) - 6 * Math.pow(x, 2) + 11 * x - 6.1;

    static DoubleFunction<Double> sm1 = x-> 6 - 8*x + 1.5*Math.pow(x,2);

    public static void main(String[] args) {

        System.out.println("Metodo de la secante ");
        System.out.println("raiz real es 0.56714329");
        Double xi = 2.5d;
        Double xu = 3.5d;
        fn = sm;
        for (int i = 0; i < 8; i++) {
            Double xr = xu - (fn.apply(xu) * (xi - xu)) / (fn.apply(xi) - (fn.apply(xu)));
            System.out.println(xr);
            xi = xu;
            xu = xr;
        }


    }

}
