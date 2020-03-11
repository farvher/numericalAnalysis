package hello.formulasintregacion;

import java.util.function.DoubleFunction;

public class ReglaDelTrapecio {

    // I = (b - a) (f(a)+f(b)/2)

    static DoubleFunction<Double> fn = x -> 0.2 + 25*x - 200*(Math.pow(x,2)) + 675*Math.pow(x,3) - 900*Math.pow(x,4) + 400*Math.pow(x,5);

    public static void main(String[] args) {
        Double b,a;
        b = 0.8d;
        a = 0d;
        System.out.println(fn.apply(a));
        System.out.println(fn.apply(b));

        Double res = (b-a) * ((fn.apply(a) + fn.apply(b))/2);
        System.out.println(res);

    }

}
