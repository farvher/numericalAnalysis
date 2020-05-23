package hello.examen;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

/**
 * Repita el punto anterior usando la regla de Simpson
 *
 * @author Farith Sanmiguel
 * @version 1.0
 */
public class Punto2 {

    //f(y) = y^π
    static DoubleFunction<Double> fy = y -> Math.pow(y, Math.PI);

    //g(y) = y^(1/π)
    static DoubleFunction<Double> gy = y -> Math.pow(y, (1 / Math.PI));

    // P(0) = -∫ yf(y) dy
    static DoubleFunction<Double> p_0 = y -> -y * fy.apply(y);

    // P(1) = ∫ (1-y) g(y) dy
    static DoubleFunction<Double> p_1 = y -> (1 - y) * gy.apply(y);

    // ∫(x-y) f(y) dy
    static DoubleFunction<Double> I = x->{
        double pi = Math.PI;
        double a = (1 / (pi+1)) * x;
        double b = Math.pow(x,(pi+2))/ (pi+1);
        double c = 1/(pi+2);
        double d= (1/(pi+2)) * Math.pow(x,pi+2);
        return (a-b-c+d);
    };

    // ∫(x-y) g(y) dy
    static  DoubleFunction<Double> J = x -> {
        double pi = Math.PI;
        double a = pi /(pi+1) * Math.pow(x,1+((pi+1))/pi) ;
        double b = (pi /(2*pi +1 ))* Math.pow(x,((2*pi)+1)/pi);
        return (a-b);
    } ;

    // P(x) = ∫(x-y) g(y) dy + (x-y) f(y) dy
    static DoubleFunction<Double> P = x -> J.apply(x) + I.apply(x);


    public static void main(String[] args) {

        println("Punto 2");

        double vt_0 = -0.194492264d;
        println("valor verdadero -∫ yf(y) dy ; evaluada en 0 y 1  = " + vt_0);
        double vt_1 = 0.327198273d;
        println("valor verdadero  //  -∫ yf(y) dy evaluada en 0 y 1 = " + vt_1);
        //segmentos
        println("Aplicamos regla de Simpson");
        int n = 1000;
        double res1 = reglaSimpson(0d, 1d, p_0, n);
        println("-∫ yf(y) dy  = " + res1);
        println("Error relativo porcentual: " + AproximacionErrores.errorRelativoVerdadero(vt_0, res1) + "%");

        double res2 = reglaSimpson(0d, 1d, p_1, n);
        println("∫ (1-y) g(y) dy = " + res2);
        println("Error relativo porcentual: " + AproximacionErrores.errorRelativoVerdadero(vt_1, res2) + "%");
        double aux = 0;


        for (int i = 1; i <=1000 ; i++) {
            double s = 1d/1000;
            double p = P.apply(aux);
            println("x = "+ aux + " --> "+p);
            aux+=s;
        }
         println("Raiz Aproximada  0.5200000000000004 --> " + P.apply(0.5200000000000004d));

    }

    /**
     * Regla del simpson multiple
     */
    public static double reglaSimpson(double a, double b, DoubleFunction<Double> fn, int n) {
        Double h = (b - a) / n;
        Double sump = 0d;
        Double sumi = 0d;
        Double i = a;

        for (int r = 1; r < n; r++) {
            Double tmp = fn.apply(i+=h);
            sump += r%2==0 ? tmp:0d;
            sumi += r%2!=0 ? tmp:0d;
        }
        Double I = (b-a) *((fn.apply(a) +(4*sumi) + (2*sump) + fn.apply(b))/(n*3));
        return I;
    }

    static void println(Object p) {
        System.out.println(p);
    }


}
