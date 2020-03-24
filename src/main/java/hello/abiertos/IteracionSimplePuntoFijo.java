package hello.abiertos;


import java.util.function.DoubleFunction;

/**
 *
 * primer metodo abierto
 * @author farith sanmiguel
 *
 * */
public class IteracionSimplePuntoFijo {

    static DoubleFunction<Double> fn  = x-> Math.sin(Math.sqrt(x)) - x;
    static DoubleFunction<Double> gn = x -> Math.sin(Math.sqrt(x));

    public static void main(String[] args) {

        System.out.println("PUNTO FIJO ITERACION");
        double xi = 1;

        for (int i = 0; i < 100; i++) {

             double xr = gn.apply(xi);
            System.out.println("iteracion  "+ i+ " xi = "+xi );
                xi = xr;
                if (fn.apply(xi) == 0){
                    break;
                }

        }





    }


}
