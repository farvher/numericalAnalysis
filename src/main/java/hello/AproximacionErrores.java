package hello;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;

/**
 * 
 * Clase Utilitaria para calcular los errores y aproximaciones
 * 
 * @author fsanmiguel
 */
public class AproximacionErrores {

	static DoubleFunction<Double> x2 = x -> Math.pow(x, 2) / factorial(2);
	static DoubleFunction<Double> x3 = x -> Math.pow(x, 3) / factorial(3);
	static DoubleFunction<Double> x4 = x -> Math.pow(x, 4) / factorial(4);
	static DoubleFunction<Double> x5 = x -> Math.pow(x, 5) / factorial(5);
	static DoubleFunction<Double> x6 = x -> Math.pow(x, 6) / factorial(6);

	static List<DoubleFunction<Double>> functions = Arrays.asList(x2, x3, x4, x5, x6);

	public static void main(String[] args) {

		System.out.println("Funcion exponencial: ");
		System.out.println("factorial de 5 : " + factorial(5));
		// 1 + x + x2/2! + x3/3!
		System.out.println("Expansion en series de Maclaurin - Serie de potencia  1 + x + x2/2! + x3/3!");
		double x = 0.5d;

		Double anterior = 1D;
		Double actual = 1 + x;
		System.out.println("res : " + actual);
		System.out.println("et : " + errorRelativoVerdadero(Math.exp(x), actual));
		System.out.println("ea : " + errorRelativoAproximado(actual, anterior));
		anterior = actual;
		for (int i = 0; i < functions.size(); i++) {
			System.out.println("evaluando x"+(i+2) );
			actual = actual + functions.get(i).apply(x);
			System.out.println("res : " + actual);
			System.out.println("et : " + errorRelativoVerdadero(Math.exp(x), actual));
			System.out.println("ea : " + errorRelativoAproximado(actual, anterior));
			anterior = actual;
		}

	}

	/**
	 * valor exacto del error
	 */
	public static Double errorVerdadero(Double valorVerdadero, Double valorAproximado) {
		return valorVerdadero - valorAproximado;
	}

	/*
	 * porcentaje del error relativo
	 */
	public static Double errorRelativoVerdadero(Double valorVerdadero, Double errorVerdadero) {
		return ((valorVerdadero - errorVerdadero) / valorVerdadero) * 100;
	}

	/**
	 * porcentaje error relativo aproximado
	 */
	public static Double errorRelativoAproximado(Double aproximacionActual, Double aproximacionAnterior) {
		return ((aproximacionActual - aproximacionAnterior) / aproximacionActual) * 100;
	}

	/**
	 * algoritmo recursivo para obtener el factoria el --a hace un decremento antes
	 * de ejecutar nuevamente
	 */
	public static int factorial(int a) {
		if (a == 0 || a == 1) {
			return 1;
		} else {
			return a * (factorial(--a));
		}

	}

}
