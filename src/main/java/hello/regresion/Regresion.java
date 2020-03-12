package hello.regresion;

public class Regresion {
    private double[] x;
    private double[] y;
    private int n;          //número de datos
    public double a, b, c;    //pendiente y ordenada en el origen


    public static void main(String[] args) {
        double[] temperatura={5, 7, 10, 12, 16, 20, 23, 27, 19, 14, 9, 6};
        double[] ventas={9, 11, 15, 16, 20, 24, 27, 29, 22, 20, 14, 9};

        double[] xi = {1,2,3,4,5,6,7};
        double[] xu = {0.5,2.5,2.0,4.0,3.5,6.0,5.5};

        Regresion regresion=new Regresion(xi, xu);
        regresion.lineal();
        System.out.println("Pendiente             "+regresion.a);
        System.out.println("Ordenada en el origen "+regresion.b);
        System.out.println("a1 " + regresion.a);
        System.out.println("a2 " + regresion.c);

        System.out.printf("y = %sx + %s%n", regresion.a, regresion.c);


        //System.out.println("Indice de correlación "+regresion.correlacion());
    }

    public Regresion(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        n = x.length; //número de datos
    }

    public void lineal() {
        double pxy, sx, sy, sx2, sy2;
        pxy = sx = sy = sx2 = sy2 = 0.0;
        for (int i = 0; i < n; i++) {
            sx += x[i];
            sy += y[i];
            sx2 += x[i] * x[i];
            sy2 += y[i] * y[i];
            pxy += x[i] * y[i];
        }
        a = (n * pxy - sx * sy) / (n * sx2 - sx * sx);
        b = (sy - b * sx) / n;
        c = b - (a * (sx/n));
    }

    public double correlacion() {
//valores medios
        double suma = 0.0;
        for (int i = 0; i < n; i++) {
            suma += x[i];
        }
        double mediaX = suma / n;

        suma = 0.0;
        for (int i = 0; i < n; i++) {
            suma += y[i];
        }
        double mediaY = suma / n;
//coeficiente de correlación
        double pxy, sx2, sy2;
        pxy = sx2 = sy2 = 0.0;
        for (int i = 0; i < n; i++) {
            pxy += (x[i] - mediaX) * (y[i] - mediaY);
            sx2 += (x[i] - mediaX) * (x[i] - mediaX);
            sy2 += (y[i] - mediaY) * (y[i] - mediaY);
        }
        return pxy / Math.sqrt(sx2 * sy2);
    }
}
