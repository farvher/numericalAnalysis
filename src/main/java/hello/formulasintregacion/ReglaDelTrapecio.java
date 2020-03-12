package hello.formulasintregacion;

import java.util.function.DoubleFunction;

public class ReglaDelTrapecio {

    // I = (b - a) (f(a)+f(b)/2)

    static DoubleFunction<Double> fn = x -> 0.2 + 25 * x - 200 * (Math.pow(x, 2)) + 675 * Math.pow(x, 3) - 900 * Math.pow(x, 4) + 400 * Math.pow(x, 5);
    static DoubleFunction<Double> fn2 = x -> -400 + 4050*x -10800*Math.pow(x,2) + 8000*Math.pow(x,3);
    public static void main(String[] args) {

        System.out.println("REGLA DEL TRAPECIO f(x) = 0.2 +25x - 200x2 + 675x3 - 900x4 +400x5");
        System.out.println("valor real de la integral = 1.640533");
        Double b, a;
        b = 0.8d;
        a = 0d;
        System.out.println(fn.apply(a));
        System.out.println(fn.apply(b));

        Double res = (b - a) * ((fn.apply(a) + fn.apply(b)) / 2);
        System.out.println("un solo segmento " + res);
        Integer n = 4;
        Double h = (b - a) / n;
        Double psx = 0d;
        Double x = a;
        for (int i = 1; i < n; i++) {
            psx +=  fn.apply((x+=h));
        }

        Double I = (b - a) * ((fn.apply(a) + (2*psx) + fn.apply(b)) / (2 * n));
        System.out.println("segmentos n = " + n +" es " + I);


    }

}
