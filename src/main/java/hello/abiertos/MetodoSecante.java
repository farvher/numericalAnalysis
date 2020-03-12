package hello.abiertos;

import java.util.function.DoubleFunction;

public class MetodoSecante {

    static DoubleFunction<Double> fn = x -> Math.exp(-x) - x;

    public static void main(String[] args) {

        System.out.println("Metodo de la secante ");
        System.out.println("raiz real es 0.56714329");
        Double xi = 0d;
        Double xu = 1.0d;

        Double xr = xu - (fn.apply(xu) * (xi-xu)) / (fn.apply(xi) -(fn.apply(xu)) );
        System.out.println(xr);


    }

}
