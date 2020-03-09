/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_pocker;

import java.text.DecimalFormat;

/**
 *
 * @author cluster
 */
public class Prueba_Pocker {

    public static void main(String[] args) {
        Datos obj = new Datos();
        DecimalFormat fo = new DecimalFormat("0.000");
        String letras[] = obj.numeros();
        double FEsperada[] = {30.240, 50.400, 10.800,
            7.200, 0.900, 0.450, 0.10};
        double FObservada[] = new double[7];
        double resta = 0;
        double Xcritico = 7.81;
        double Xcalculado = 0;
        double chi = 0;
        int n = letras.length;
        String texto2 = "";
        String cadena1 = "";
        String cad[];
        int p = 0;
        int unPar = 0, dif = 0, dosPares = 0, tercia = 0,
                full = 0, pocker = 0, quintilla = 0;
        for (int i = 0; i < letras.length; i++) {
            cad = letras[i].split("\\."); //buscar
            cadena1 = cad[1];
            int diferentes = 0, par = 0, dpar = 0, ttercia = 0,
                    ffull = 0, ppocker = 0, qquintilla = 0;
            for (int j = 0; j < cadena1.length(); j++) {
                for (int k = j + 1; k < cadena1.length(); k++) {
                    if (cadena1.charAt(j) != cadena1.charAt(k)) {
                        diferentes++;
                        if (diferentes == 10) {
                            diferentes = 0;
                            dif++;
                            FObservada[0] = dif;
                        }
                    }
                    if (cadena1.charAt(j) == cadena1.charAt(k)) {

                        par++;
                        dpar++;
                        ttercia++;
                        ppocker++;
                        ffull++;
                        qquintilla++;
                        if (par == 1) {

                            unPar++;
                            FObservada[1] = unPar;
                        }
                        if (par == 2) {
                            unPar--;
                            FObservada[1] = unPar;
                        }
                        if (dpar == 2) {
                            dosPares++;
                            FObservada[2] = dosPares;

                        }
                        if (dpar == 3) {
                            dosPares--;
                            FObservada[2] = dosPares;

                        }

                        if (ttercia == 3) {
                            tercia++;
                            FObservada[3] = tercia;
                        }
                        if (ttercia == 4) {
                            tercia--;
                            FObservada[3] = tercia;

                        }
                        if (ppocker == 6) {
                            pocker++;
                            FObservada[4] = pocker;

                        }
                        if (ppocker == 7) {
                            pocker--;
                            FObservada[4] = pocker;

                        }
                        if (ffull == 4) {
                            full++;
                            FObservada[5] = full;

                        }
                        if (ffull == 5) {
                            full--;
                            FObservada[5] = full;

                        }
                        if (qquintilla == 10) {
                            qquintilla = 0;
                            quintilla++;
                            FObservada[6] = quintilla;
                        }
                    }
                }
            }
        }
        
         System.out.println("Hipotesis:"
                                   +"\n         H0: Los numero pseudoaleatorios provienen de una "
                                   +"\n             distribuion uniforme"
                                   +"\n         H1: Los numero pseudoaleatorios no provienen de una "
                                   +"\n             distribuion uniforme \n");

        System.out.println(
                "todas diferentes     " + dif
                + "\nUn Par:              " + (unPar)
                + "\nDos pares:           " + (dosPares)
                + "\nTercia:              " + (tercia)
                + "\nPocker:              " + (pocker)
                + "\nFull:                " + full
                + "\nQuintilla:           " + quintilla);
        
        System.out.println("\n\n FObservada" + "    FEsperada" + "  (FO-FE)"
                + "     (FO-FE)²/FE");

        for (int i = 0; i < FEsperada.length; i++) {
            resta = (FObservada[i] - FEsperada[i]);
            chi = Math.pow(resta, 2) / FEsperada[i];
            Xcalculado = Xcalculado + chi;
            System.out.println("    " + FObservada[i] + "         " + FEsperada[i]
                    + "    " + fo.format(resta) + "         " + fo.format(chi));

        }

        System.out.println("\nTotal:                                " + fo.format(Xcalculado));
        if(Xcalculado<Xcritico){
            System.out.println("Se acepta H0");
        }
        else{
            System.out.println("Se rechaza H0 y se acepta H1");
        }
    }

}
