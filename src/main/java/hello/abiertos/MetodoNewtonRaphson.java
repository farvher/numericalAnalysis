package hello.abiertos;

import hello.aproximaciones.AproximacionErrores;

import java.util.function.DoubleFunction;

public class MetodoNewtonRaphson {

	static DoubleFunction<Double> fx = x -> Math.exp(-x) - x;
	static DoubleFunction<Double> fx1 = x -> -Math.exp(-x) - 1;

	static DoubleFunction<Double> sm = x-> -20 + 6*x - 4*Math.pow(x,2) + 0.5*Math.pow(x,3);
	static DoubleFunction<Double> sm1 = x-> 6 - 8*x + 1.5*Math.pow(x,2);

	public static void main(String[] args) {
		System.out.println("Metodo de Newton-Raphson");

		Double xa = 0D;

		for (int i = 0; i < 100; i++) {
			System.out.println(i + "-----------------");
			Double xr = xa - (sm.apply(xa) / sm1.apply(xa));
			System.out.println("xr : " + xr);
			double ep = AproximacionErrores.errorRelativoAproximado(xr, xa);
			double et = AproximacionErrores.errorRelativoVerdadero(7.1034020,xr);
			System.out.println("Ep : " + ep+"%");
			System.out.println("Et : " + et+"%");
			xa = xr;
			if(ep==0){break;}
			System.out.println("-----------------");
		}
	}

}
