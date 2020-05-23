package hello.examen;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

/**
 * Elija 5 parejas (x, ϕ(x)) encontrados en el primer punto
 * de este examen, y construya un polinomio de interpolaci´on de Lagrange entre ellos.
 * Cree un programa de computador que use el m´etodo de
 * Newton-Raphson sobre este polinomio para encontrar una aproximaci´on a la ra´ız de ϕ en (0, 1)
 *
 * @author Farith Sanmiguel
 * @version 1.0
 */
public class Punto4 {

    //
    static DoubleFunction<Double> fn = x ->
            (-0.1664 * Math.pow(x, 4))
                    + (0.2858 * Math.pow(x, 3))
                    + (0.1640 * Math.pow(x, 2))
                    + (0.2373 * x)
                    - 0.1944;
    //
    static DoubleFunction<Double> fn1 = x ->
            (-0.6656 * Math.pow(x, 3))
                    + (0.8574 * Math.pow(x, 2))
                    + (0.328 * x)
                    + 0.2373;

    public static void main(String[] args) {

        println("Punto 4");
        double xa = 0;
        double xu = 1;
        metodoNewtonRaphson(xa, fn, fn1);

    }


    /**
     * Metodo de Newton - Raphson
     */
    public static void metodoNewtonRaphson(double xa, DoubleFunction<Double> fn, DoubleFunction<Double> fn1) {

        for (int i = 1; i <= 100; i++) {
            println("-----------------");
            println("Iteracion " + (i));
            Double xr = xa - (fn.apply(xa) / fn1.apply(xa));
            println("xr : " + xr);
            double ep = AproximacionErrores.errorRelativoAproximado(xr, xa);
            println("Error relativo porcentual : " + ep + "%");
            xa = xr;
            if (ep == 0d) {
                println("Raiz aproximada: "+ xa);
                break;
            }
            println("-----------------");
        }

    }

    static void println(Object p) {
        System.out.println(p);
    }


}
