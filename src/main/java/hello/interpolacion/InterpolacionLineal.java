package hello.interpolacion;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

public class InterpolacionLineal {

    //

    static DoubleFunction<Double> ln = x -> Math.log(x);

    public static void main(String[] args) {
        double x = 2;
        double vt = ln.apply(x);

        double x_0 = 1d;
        double x_1 = 6d;

        double il = interpolacionLineal(x, x_0, x_1);
        System.out.println("interpolacion " +il);
        double er = AproximacionErrores.errorRelativoVerdadero(vt,il);
        System.out.println("error " + er);
    }

    public static Double interpolacionLineal(Double x , Double xi, Double xu){

       return  ln.apply(xi) + ((ln.apply(xu) - ln.apply(xi))/(xu-xi)) * (x - xi);

    }

}
