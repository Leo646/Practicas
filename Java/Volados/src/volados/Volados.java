package volados;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class Volados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b, meta;
        DecimalFormat n = new DecimalFormat("0.00000");
        double numeroAzar;
        int j = 1, totalGanadas = 0, totalPerdidas = 0, totalCorridas = 0;
        int ganancia = 0;
        int auxGanancia = 0;
        Scanner num = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dinero que dispone");
        a = num.nextInt();
        System.out.println("Ingrese que va apostar");
        b = num.nextInt();
        System.out.println("Ingrese la meta a coseguir");
        meta = num.nextInt();
        int entrada = a;
        int apuesta = b;
        int semilla = 17218;
        mensaje();
        if (entrada < apuesta) {
            System.out.println("el dinero inicial es inferior a su apuesta");
        } else {
            while (j <= 10000) {
                semilla = (172 * semilla) % 30307;
                numeroAzar = (double) semilla / 30307;
                if (numeroAzar < 0.5) {
                    ganancia = a + b;
                    if (ganancia >= meta) {
                        System.out.println(j + "\t" + a + "\t" + b + "\t" + n.format(numeroAzar)
                                + "\t\tsi" + "\t" + ganancia + "\tsi" + "\n ");
                        j++;
                        totalGanadas++;
                        a = entrada;
                        b = apuesta;
                    }
                    if (ganancia < meta) {
                        System.out.println("\t" + a + "\t" + b + "\t" + n.format(numeroAzar)
                                + "\t\tsi" + "\t" + ganancia);
                        a = ganancia;
                        b = apuesta;
                    }
                } else {
                    ganancia = a - b;
                    if (ganancia < meta & ganancia > 0) {
                        System.out.println("\t" + a + "\t" + b + "\t" + n.format(numeroAzar)
                                + "\t\tno" + "\t" + ganancia);
                        a = ganancia;
                        b = b * 2;
                    }
                    if (ganancia <= 0) {
                        System.out.println(j + "\t" + a + "\t" + b + "\t" + n.format(numeroAzar)
                                + "\t\tno" + "\t" + ganancia + "\tquiebra" + "\n");
                        a = entrada;
                        b = apuesta;
                        j++;
                        totalPerdidas++;
                    }
                    if (a < b) {
                        b = a;
                    }
                }
            }
        }
        totalCorridas = totalGanadas + totalPerdidas;
        System.out.println("Total ganadas " + totalGanadas);
        System.out.println("Total perdias " + totalPerdidas);
        System.out.println("Total corridas " + totalCorridas);
        probabilidades(totalGanadas, totalPerdidas, totalCorridas);
    }

    public static void mensaje() {
        System.out.println("#corr" + "\tC.Ini" + "\tApuesta" + "\t#aleatorio" + "\tGano?" + " "
                + "\tGananc." + "\tmeta?");
    }

    public static void probabilidades(int g, int p, int c) {
        int ganar = g;
        int perder = p;
        double proGanar = 0;
        double proPerder = 0;
        proGanar = (double) ganar / c * 100;
        proPerder = (double) perder / c * 100;
        System.out.println("probabilidad de ganar " + proGanar + " %");
        System.out.println("probabilidad de perder " + proPerder + " %");
    }
}
