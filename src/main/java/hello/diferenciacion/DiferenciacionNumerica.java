package hello.diferenciacion;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class DiferenciacionNumerica {


    static DoubleFunction<Double> fx = x -> (-0.1d * Math.pow(x, 4)) - (0.15d * Math.pow(x, 3)) - (0.5d * Math.pow(x, 2)) - (0.25d * x) + 1.2d;
    static DoubleFunction<Double> fxp = x -> (-0.4d * Math.pow(x, 3)) - (0.45d * Math.pow(x, 2)) - x - 0.25;

    //
    //fx = 2x2 + 3x + 5
    static DoubleFunction<Double> fx1 = x -> 2 * Math.pow(x, 2) + 3 * x + 5;
    //fx = 4x + 3
    static DoubleFunction<Double> fx2 = x -> 4 * x + 3;


    public static void main(String[] args) {

        double h = 0.25d;
        double x = 7d;
        System.out.println("fx " + fx1.apply(x));
        System.out.println("fx prima " + fx2.apply(x));
        double fcenter = difCenter(x, h, fx1);
        double ffoward = difFoward(x, h, fx1);
        double fback = difBack(x, h, fx1);

        System.out.println("diferenciacion centrada fprima evaluada en " + x + "-->" + fcenter);
        System.out.println("diferenciacion adelante fprima evaluada en " + x + "-->" + ffoward);
        System.out.println("diferenciacion atras fprima evaluada en " + x + "-->" + fback);


    }

    public static double difBack(double x, double h, DoubleFunction<Double> fx) {
        double a = 3 * fx.apply(x);
        double b = 4 * fx.apply(x - h);
        double c =  fx.apply(x-h-h);
        double d = 2 * h;
        double res = (a - b + c) / d;
        return res;
    }

    public static double difFoward(double x, double h, DoubleFunction<Double> fx) {
        double a = -fx.apply(x + h + h);
        double b = 4 * fx.apply(x + h);
        double c = 3 * fx.apply(x);
        double d = 2 * h;
        double res = (a + b - c) / d;
        return res;
    }

    public static double difCenter(double x, double h, DoubleFunction<Double> fx) {
        double a = (-1 * fx.apply(x + h + h));
        double b = (8 * fx.apply(x + h));
        double c = (8 * fx.apply(x - h));
        double d = (fx.apply(x - h - h));
        double f = 12 * h;
        double res = (a + b - c + d) / f;
        return res;
    }

}

