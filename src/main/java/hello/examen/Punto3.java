package hello.examen;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

/**
 * Cree un programa de computador que use el m´etodo de
 * la bisecci´on para encontrar la ra´ız de ϕ en (0, 1). Para el c´alculos de las
 * integrales se puede ayudar de los programas creados en los dos puntos
 * anteriores.
 *
 * @author Farith Sanmiguel
 * @version 1.0
 */
public class Punto3 {

    //f(y) = y^π
    static DoubleFunction<Double> fy = y -> Math.pow(y, Math.PI);

    //g(y) = y^(1/π)
    static DoubleFunction<Double> gy = y -> Math.pow(y, (1 / Math.PI));

    // ∫(x-y) f(y) dy
    static DoubleFunction<Double> I = x -> {
        double pi = Math.PI;
        double a = (1 / (pi + 1)) * x;
        double b = Math.pow(x, (pi + 2)) / (pi + 1);
        double c = 1 / (pi + 2);
        double d = (1 / (pi + 2)) * Math.pow(x, pi + 2);
        return (a - b - c + d);
    };

    // ∫(x-y) g(y) dy
    static DoubleFunction<Double> J = x -> {
        double pi = Math.PI;
        double a = pi / (pi + 1) * Math.pow(x, 1 + ((pi + 1)) / pi);
        double b = (pi / (2 * pi + 1)) * Math.pow(x, ((2 * pi) + 1) / pi);
        return (a - b);
    };

    // P(x) = ∫(x-y) g(y) dy + (x-y) f(y) dy
    static DoubleFunction<Double> P = x -> J.apply(x) + I.apply(x);


    public static void main(String[] args) {

        println("Punto 3");
        println("Raiz de P entre 0 y 1");
        double xa = 0;
        double xu = 1;
        println("Aplicamos biseccion");
        biseccion(xa, xu, P);
    }


    /**
     * Metodo de la biseccion
     */
    public static void biseccion(double xa, double xu, DoubleFunction<Double> fun) {
        double xrOld = 0D;
        double ep;
        double n = 100;
        for (int i = 1; i <= n; i++) {
            println("------------------------------");
            println("Iteracion " + (i));
            println("Valores iniciales " + xa + " y " + xu);
            Double xr = xr(xa, xu);
            println("xr " + xr);
            Double fxr = fxr(fun.apply(xa), fun.apply(xr));
            if (i > 0) {
                ep = AproximacionErrores.errorRelativoAproximado(xr, xrOld);
                println("Error relativo porcentual aproximado: " + ep + "%");
            }
            println("fxr " + fxr);
            xrOld = xr;
            if (fxr > 0) {
                xa = xr;
            } else {
                xu = xr;
            }
            if (fxr == 0D) {
                println("Final " + xr);
                break;
            }
            println("------------------------------");
        }

    }

    /**
     * Calcular xr
     */
    public static Double xr(Double xi, Double xu) {
        return (xi + xu) / 2;
    }

    /**
     * Calcula fxr
     */
    public static Double fxr(Double a, Double b) {
        return a * b;
    }

    static void println(Object p) {
        System.out.println(p);
    }


}
