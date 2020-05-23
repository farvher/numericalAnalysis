package hello.abiertos;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

public class MetodoSecante {

    static DoubleFunction<Double> fn = x -> Math.exp(-x) - x;
    static DoubleFunction<Double> sm = x -> Math.pow(x, 3) - 6 * Math.pow(x, 2) + 11 * x - 6.1;

    static DoubleFunction<Double> sm1 = x-> Math.pow(x,2) - 3*x - 4;

    public static void main(String[] args) {

        System.out.println("Metodo de la secante ");
        System.out.println("raiz real es 0.56714329");
        Double x_1 = 5d;//.5d;
        Double x1 = 7d;//3.5d;
        fn = sm1;
        for (int i = 0; i < 8; i++) {
            Double xr = x1 - (fn.apply(x1) * (x_1 - x1)) / (fn.apply(x_1) - (fn.apply(x1)));
            System.out.println(xr);
            double er =  AproximacionErrores.errorRelativoAproximado(xr,x1);
            System.out.println("error "+er+"%");
            x_1 = x1;
            x1 = xr;
        }

    }

}
