package hello.formulasintregacion;

import java.util.function.DoubleFunction;
import java.util.function.ToDoubleBiFunction;

public class ReglaDeSimpson {


    static DoubleFunction<Double> fn = x -> 0.2 + 25 * x - 200 * (Math.pow(x, 2)) + 675 * Math.pow(x, 3) - 900 * Math.pow(x, 4) + 400 * Math.pow(x, 5);
    static ToDoubleBiFunction<Double,Double> simpson = (a,b)  -> (b-a) * ((fn.apply(a) +(4*(fn.apply(b/2))) + fn.apply(b))/6);

    public static void main(String[] args) {
        System.out.println("REGLA DE SIMPSON f(x) = 0.2 +25x - 200x2 + 675x3 - 900x4 +400x5");
        System.out.println("valor real de la integral = 1.640533");
        Double a,b;
        a = 0d;
        b = 0.8;
        System.out.println("resultado simpson I = "+ simpson.applyAsDouble(a,b));

        System.out.println("REGLA DE SIMPSON multiple");
        Integer n = 4;
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
        System.out.println("resultado simpson n="+n+" I = "+I);
    }

}
