package prueba_frecuencias;

import java.text.DecimalFormat;
/**
 * @author cluster
 */
public class Prueba_Frecuencias {
    public static void main(String[] args) {
        DecimalFormat fo = new DecimalFormat("0.0");
        DecimalFormat fo1 = new DecimalFormat("0.00000");
        Datos obj = new Datos();
        int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0;
        int n = 5, gl=0, a=1;
        int FE = 0;
        double Xcritio=9.4877;
        int intervalos[] = new int[5];
        double numeros[] = obj.numeros();
        int N=numeros.length;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(a+"  "+numeros[i]);
            a++;
            if (numeros[i] > 0 && numeros[i] <= 0.2) {
                cont1++;
                intervalos[0] = cont1;
            }
            if (numeros[i] > 0.2 && numeros[i] <= 0.4) {
                cont2++;
                intervalos[1] = cont2;

            }
            if (numeros[i] > 0.4 && numeros[i] <= 0.6) {
                cont3++;
                intervalos[2] = cont3;

            }
            if (numeros[i] > 0.6 && numeros[i] <= 0.8) {
                cont4++;
                intervalos[3] = cont4;

            }
            if (numeros[i] > 0.8 && numeros[i] <= 1) {
                cont5++;
                intervalos[4] = cont5;

            }

        }
        double inter = 0.2;
        FE = N / n;
        gl=n-1;
        double suma = 0;
        double chi = 0;
        double Xcalculado = 0;
        double suma1 = 0;
        System.out.println("Datos:"+
                                    "\n         N: "+N
                                   +"\n         n: "+n
                                   +"\n         gl: "+gl
                                   +"\n         X²critico: "+Xcritio
                          +"\n\nHipotesis:"
                                   +"\n         H0: Los numero pseudoaleatorios provienen de una "
                                   +"\n             distribuion uniforme"
                                   +"\n         H1: Los numero pseudoaleatorios no provienen de una "
                                   +"\n             distribuion uniforme \n");
        System.out.println("#intervalo" + "   FE" + "   FO" + "  (FO-FE)" + "   (FO-FE)²/FE");
        for (int i = 0; i < intervalos.length; i++) {
            suma = (intervalos[i]- FE);
            chi = Math.pow(suma, 2);
            suma1 = suma1 + chi;
            System.out.println("    " + fo.format(inter) + "      " + FE + "    " + intervalos[i]
                    + "      " + suma + "      " + fo.format(chi));
            inter = inter + 0.2;

        }
        Xcalculado = suma1 / FE;
        System.out.println("Total                              " + fo1.format(Xcalculado)
                            +"\n\nx²calucado:"+fo1.format(Xcalculado));
        if(Xcalculado<Xcritio){
            System.out.println("\nPrueba de hipostesis:"
                             + "\n       Se acepta la hipotesos H0 ya que "
                             + "\n       Xcalculado < Xcritico");
            
        }
        else{
            System.out.println("\nPrueba de hipostesis:"
                             + "\n       Se rechaza la hipotesos H0 y se acepta H1 ya que "
                             + "\n       Xcalculado > Xcritico");
        }
    }

}
