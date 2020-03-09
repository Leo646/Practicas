package prueba_kolmogorov;

import java.text.DecimalFormat;

/**
 * @author cluster
 */
public class Prueba_Kolmogorov {

    public static void main(String[] args) {
        DecimalFormat fo = new DecimalFormat("0.00000");
        Datos obj = new Datos();
        double numeros[] = obj.numeros();
        int n = numeros.length;
        double desorden[] = obj.numeros();
        double Fx[] = new double[n];
        double resta[] = new double[n];
        double Dn=0, alfa=0.05, dcritico=0.242;
        
        System.out.println("Datos:"+"\n         n: "+n
                                   +"\n         alfa: "+alfa
                                   +"\n         dcritico: "+ dcritico);
        
        System.out.println("\n\ni"+"        Xi"+"     Fnx"+"      Dn=max|Fnx-Xi|\n");

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    double temp = numeros[j + 1];
                    numeros[j + 1] = numeros[j];
                    numeros[j] = temp;
                }
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            Fx[i] = (double) (i + 1) / n;
            resta[i] = Math.abs(Fx[i] - numeros[i]);

            System.out.println((i + 1) + "    " + numeros[i]
                    + "  " + fo.format(Fx[i]) + "     " + fo.format(resta[i]));

        }
        for (int i = 0; i < resta.length; i++) {
            if (resta[i] > Dn) {
                Dn = resta[i];
            }else
                Dn=Dn;
            
        }
        System.out.println("Dn: " + fo.format(Dn));
        if(Dn<dcritico){
            System.out.println("Se acepta H0 :Los números provienen de una distribucion unifome");
            
        }else{
            System.out.println("Se rechaza H0 y se acepta H1:Los números no provienen de "
                                + "una distribucion unifome");
            
        }
    }

}
