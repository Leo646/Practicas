package prueba_promedios;

import java.text.DecimalFormat;

/**
 * @author cluster
 */
public class Prueba_Promedios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Datos obj = new Datos();
        DecimalFormat formato = new DecimalFormat("0.00000");
        
        double Zcritico = 1.96, promedio = 0, a = 0;
        double U = 0, Nconfianza = 0.95, Zestadistico = 0;
        double datos[] = obj.numeros();
        int N =datos.length;
        for (int i = 0; i < datos.length; i++) {
            System.out.println(i + 1 + " " + datos[i]);
            U = U + datos[i];
        }
        promedio = U / N;
        a = ((double) 1 / 12);
        Zestadistico = ((promedio - 0.5) * Math.sqrt(N)) / (Math.sqrt(a));
        System.out.println("\nHipotesis: "
                + "\n\n       Hipotesis nula H0: U= 1/2"
                + "\n       Hipotesis alterna H1: U!= 1/2");

        System.out.println("\nTamaño de la muestra :" + N + "\nsumatoria: " + formato.format(U)
                + "\nNconfinza: " + Nconfianza + "\nZcritico: " + Zcritico
                + "\nPromedio: " + formato.format(promedio)
                + "\nZestadistico: " + formato.format(Zestadistico));
        if (Zestadistico < Zcritico) {
            System.out.println("\nPrueba de hipostesis:"
                    + "\n           Zestadistico <  Zcritico; por lo tanto no se"
                    + "\n           puede rechazar H0 de que los numeros pseudoaleatorios "
                    + "\n           tiene una media de 0.5");
        } else {
            System.out.println("\nPrueba de hipostesis:"
                    + "\n           Zestadistico >  Zcritico; por lo tanto  se"
                    + "\n           rechaza H0 y se acepta H1 de que los numero pseudoaleatorios "
                    + "\n           no tiene una media de 0.5");
        }

    }

}
