package hello.interpolacion;

import java.util.function.DoubleFunction;

public class InterpolacionLineal {

    //

    static DoubleFunction<Double> ln = x -> Math.log(x);

    public static void main(String[] args) {

        System.out.printf("interpolacion " +interpolacionLineal(2d, 1d, 6d));
    }

    public static Double interpolacionLineal(Double x , Double xi, Double xu){

       return  ln.apply(xi) + ((ln.apply(xu) - ln.apply(xi))/(xu-xi)) * (x - xi);

    }

}
