package hello.interpolacion;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

public class InterpolacionCuadratica {

    static DoubleFunction<Double> fn = x -> Math.log(x);

    public static void main(String[] args) {
        double x = 2;
        double vt = fn.apply(x);

        double x_0 = 1d;
        double x_1 = 4;
        double x_2 = 6;

        double b0,b1,b2;

        b0 = fn.apply(x_0);
        b1 = (fn.apply(x_1) - fn.apply(x_0)) / (x_1 - x_0);
        b2 = (((fn.apply(x_2) - fn.apply(x_1)) /(x_2 - x_1) )- ((fn.apply(x_1)-fn.apply(x_0)) /(x_1-x_0))) / (x_2 - x_0);

        System.out.println("b0: "+b0 );
        System.out.println("b0: "+b1 );
        System.out.println("b0: "+b2 );
        DoubleFunction<Double> f = a ->  b0 + (b1 *(a - x_0)) + (b2 * ((a-x_0) * (a - x_1))) ;

        System.out.println("f2 = "+ f.apply(2));
        double er = AproximacionErrores.errorRelativoVerdadero(vt,f.apply(x));
        System.out.println("Error: "+er);
    }

}
