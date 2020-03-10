package hello.cerrados;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

public class MetodoFalsaPosicion {


    // f(x) = x4 + 3x3 - 2
    static DoubleFunction<Double> fun = x -> Math.pow(x, 4) + (3 * (Math.pow(x, 3))) - 2;

    public static void main(String[] args) {

        System.out.println("Metodo de la falsa posicion f(x) = x4 + 3x3 - 2");

        Double xa = 0D;
        Double xu = 1D;
        Double xrOld = 0D;
        Double ep = 100D;

        for (int i = 0; i < 100; i++) {
            System.out.println("------------------------------");
            System.out.println("Iteracion " +(i+1));
            System.out.println("Valores iniciales " + xa + " y " + xu);
            Double xr = xr(xa, xu);
            System.out.println("xr " + xr);
            Double fxr = fxr(fun.apply(xa), fun.apply(xr));
            if (i > 0) {
                ep = AproximacionErrores.errorRelativoAproximado(xr, xrOld);
                System.out.println("Error ep: " + ep);
            }
            System.out.println("fxr " + fxr);
            xrOld = xr;
            if (fxr > 0) {
                xa = xr;
            } else {
                xu = xr;
            }
            if(fxr == 0D){
                System.out.println("Final " + xr );
                break;
            }
            System.out.println("------------------------------");
        }

    }

    /**
     *   xr = xu - f(xu)(xi - xu)/f(xi) - f(xu)
     * */
    public static Double xr(Double xi, Double xu) {
        return xu - ( (fun.apply(xu) * (xi - xu)) / ( fun.apply(xi) - fun.apply(xu)) );
    }

    public static Double fxr(Double a, Double b) {
        return a * b;
    }

}
