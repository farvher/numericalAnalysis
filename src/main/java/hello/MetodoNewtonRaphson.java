package hello;

import java.util.function.DoubleFunction;

public class MetodoNewtonRaphson {

	static DoubleFunction<Double> fx = x -> Math.exp(-x) - x;
	static DoubleFunction<Double> fx1 = x -> -Math.exp(-x) - 1;

	public static void main(String[] args) {
		System.out.println("Metodo de Newton-Raphson");

		Double xa = 0D;

		for (int i = 0; i < 10; i++) {
			System.out.println("-----------------");
			Double xr = xa - (fx.apply(xa) / fx1.apply(xa));
			System.out.println("xr : " + xr);
			System.out.println("Ep : " + AproximacionErrores.errorRelativoAproximado(xr, xa)+"%");
			xa = xr;
			System.out.println("-----------------");
		}
	}

}
