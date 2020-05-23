package hello.examen;

import hello.aproximaciones.AproximacionErrores;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleFunction;
import java.util.function.ToDoubleBiFunction;

/**
 * Cree un programa de computador que use la regla de los
 * trapecios para aproximar los valores de las integrales que definen a ϕ
 * con un error relativo porcentual menor al 5 %. Con estas aproximaciones
 * de las integrales estime el valor de ϕ para 1000 valores de x ∈ [0, 1]
 * igualmente espaciados. Con esta t´ecnica d´e un valor aproximado de la
 * ra´ız de ϕ en (0,1)
 *
 * @author Farith Sanmiguel
 * @version 1.0
 */
public class Punto1 {

    //f(y) = y^π
    static DoubleFunction<Double> fy = y -> Math.pow(y, Math.PI);

    //g(y) = y^(1/π)
    static DoubleFunction<Double> gy = y -> Math.pow(y, (1 / Math.PI));

    // P(0) = -∫ yf(y) dy
    static DoubleFunction<Double> p_0 = y -> -y * fy.apply(y);

    // P(1) = ∫ (1-y) g(y) dy
    static DoubleFunction<Double> p_1 = y -> (1 - y) * gy.apply(y);

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

        println("Punto 1");

        double vt_0 = -0.194492264d;
        println("valor verdadero -∫ yf(y) dy ; evaluada en 0 y 1  = " + vt_0);
        double vt_1 = 0.327198273d;
        println("valor verdadero  //  -∫ yf(y) dy evaluada en 0 y 1 = " + vt_1);
        //segmentos
        println("Aplicamos regla del trapecio");
        int n = 1000;
        double res1 = reglaTrapecio(0d, 1d, p_0, n);
        println("-∫ yf(y) dy  = " + res1);
        println("Error relativo porcentual: " + AproximacionErrores.errorRelativoVerdadero(vt_0, res1) + "%");

        double res2 = reglaTrapecio(0d, 1d, p_1, n);
        println("∫ (1-y) g(y) dy = " + res2);
        println("Error relativo porcentual: " + AproximacionErrores.errorRelativoVerdadero(vt_1, res2) + "%");
        double aux = 0;
        double s = 1d / n;
        for (int i = 1; i <= n; i++) {
            double p = P.apply(aux);
            println("x = " + aux + " --> " + p);
            aux += s;
        }

        println("Raiz Aproximada  0.5200000000000004 --> " + P.apply(0.5200000000000004d));


    }

    /**
     * Regla del trapecio multiple
     */
    public static double reglaTrapecio(double a, double b, DoubleFunction<Double> fn, int n) {
        Double h = (b - a) / n;
        Double psx = 0d;
        Double x = a;
        for (int i = 1; i < n; i++) {
            psx += fn.apply((x += h));
        }
        Double I = (b - a) * ((fn.apply(a) + (2 * psx) + fn.apply(b)) / (2 * n));
        return I;
    }

    static void println(Object p) {
        System.out.println(p);
    }


}
