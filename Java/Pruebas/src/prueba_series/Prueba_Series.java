package prueba_series;

import java.text.DecimalFormat;

/**
 * @author cluster
 */
public class Prueba_Series {

    public static void main(String[] args) {
        Datos obj = new Datos();
        DecimalFormat fo=new DecimalFormat("0.0000");
        double numeros1[] = obj.numeros(), alf = 0.05, Xcritico = 24.9958;
        int N = numeros1.length - 1;
        int n = 4, gl = 0, a = 1;
        double FE = 0;
        int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0,
                cont5 = 0, cont6 = 0, cont7 = 0, cont8 = 0,
                cont9 = 0, cont10 = 0, cont11 = 0, cont12 = 0,
                cont13 = 0, cont14 = 0, cont15 = 0, cont16 = 0;;
        double arr1[] = new double[N];
        double arr2[] = new double[N];
        int[][] matrix = new int[n][n];
        int cont = 0;
        int ca = 0;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = numeros1[a - 1];
            arr2[i] = numeros1[a];
            System.out.println(a + "  " + arr1[i] + "   " + arr2[i]);
            a++;
            int b = 0;
            //fila 0 y columan 0,1,2,3
            if (arr1[i] < 0.25 & arr2[i] > 0.75 & arr2[i] <= 1) {
                cont1++;
            }
            if (arr1[i] > 0.25 & arr1[i] <= 0.5 & arr2[i] > 0.75 & arr2[i] <= 1) {
                cont2++;
            }
            if (arr1[i] > 0.5 & arr1[i] <= 0.75 & arr2[i] > 0.75 & arr2[i] <= 1) {
                cont3++;
            }
            if (arr1[i] > 0.75 & arr1[i] <= 1 & arr2[i] > 0.75 & arr2[i] <= 1) {
                cont4++;
            }
            //fila 1 y columan 0,1,2,3

            if (arr1[i] < 0.25 & arr2[i] > 0.5 & arr2[i] <= 0.75) {
                cont5++;
            }
            if (arr1[i] > 0.25 & arr1[i] <= 0.5 & arr2[i] > 0.5 & arr2[i] <= 0.75) {
                cont6++;
            }
            if (arr1[i] > 0.5 & arr1[i] <= 0.75 & arr2[i] > 0.5 & arr2[i] <= 0.75) {
                cont7++;
            }
            if (arr1[i] > 0.75 & arr1[i] <= 1 & arr2[i] > 0.5 & arr2[i] <= 0.75) {
                cont8++;
            }
            //fila 2 y columan 0,1,2,3
            if (arr1[i] < 0.25 & arr2[i] > 0.25 & arr2[i] <= 0.5) {
                cont9++;
            }
            if (arr1[i] > 0.25 & arr1[i] <= 0.5 & arr2[i] > 0.25 & arr2[i] <= 0.5) {
                cont10++;
            }
            if (arr1[i] > 0.5 & arr1[i] <= 0.75 & arr2[i] > 0.25 & arr2[i] <= 0.5) {
                cont11++;
            }
            if (arr1[i] > 0.75 & arr1[i] <= 1 & arr2[i] > 0.25 & arr2[i] <= 0.5) {
                cont12++;
            }
            //fila 3 y columan 0,1,2,3   
            if (arr1[i] < 0.25 & arr2[i] <= 0.25) {
                cont13++;
            }
            if (arr1[i] > 0.25 & arr1[i] <= 0.5 & arr2[i] <= 0.25) {
                cont14++;
            }
            if (arr1[i] > 0.5 & arr1[i] <= 0.75 & arr2[i] <= 0.25) {
                cont15++;
            }
            if (arr1[i] > 0.75 & arr1[i] <= 1 & arr2[i] <= 0.25) {
                cont16++;
            }
        }

        gl = (int) Math.pow(n, 2) - 1;
        System.out.println("\nDatos:"
                + "\n         N:" + N
                + "\n         n:" + n
                + "\n         gl:" + gl
                + "\n         α: " + alf
                + "\n         X²critico:" + Xcritico
        +"\n\nHipotesis:"
                                   +"\n         H0: Los numero pseudoaleatorios provienen de una "
                                   +"\n             distribuion uniforme"
                                   +"\n         H1: Los numero pseudoaleatorios no provienen de una "
                                   +"\n             distribuion uniforme \n");

        String cadena = "   ";
        String cad1 = " ";
        double e1=0;
        int e = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[0][0] = cont1;
                matrix[0][1] = cont2;
                matrix[0][2] = cont3;
                matrix[0][3] = cont4;

                matrix[1][0] = cont5;
                matrix[1][1] = cont6;
                matrix[1][2] = cont7;
                matrix[1][3] = cont8;

                matrix[2][0] = cont9;
                matrix[2][1] = cont10;
                matrix[2][2] = cont11;
                matrix[2][3] = cont12;

                matrix[3][0] = cont13;
                matrix[3][1] = cont14;
                matrix[3][2] = cont15;
                matrix[3][3] = cont16;
                
                cadena = cadena +""+ matrix[i][j] + "     ";
                

            }
            e++;
            e1=(double)e/n;
            cadena ="\n"+ cadena + "\n   ";
            cad1= cad1+"   "+e1;

        }
        System.out.println(cadena);
        System.out.println("---------------------------");
        System.out.println(cad1);
        
        int conta[]=new int[n*n];
        int f=0;
        System.out.println("\n\n#intervalo" + "      FE" + "     FO" + "  (FO-FE)" + "   (FO-FE)²/FE");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                conta[f]=matrix[i][j];
                f++;
            }
        }
        FE = N / Math.pow(n, 2);
        double resta=0;
        double chi=0;
        double suma1=0;
        double suma2=0;
        double suma3=0;
        double Xcalculado=0;
        for (int i = 0; i <Math.pow(n, 2) ; i++) {
            resta = (conta[i] - FE);
            suma1=suma1+FE;
            chi = Math.pow(resta, 2);
            suma2=suma2+conta[i];
            suma3 = suma3 + chi;
            System.out.println("    "+(i+1)+"        "+FE+"    "+conta[i]
                              +"   "+resta+"     "+fo.format(chi) );
            
        }
        Xcalculado = suma3 / FE;
        System.out.println("\nTotal         "+suma1+"      "+suma2+"           " 
                            + fo.format(Xcalculado)
                            +"\n\nx²calucado:"+fo.format(Xcalculado));
        if(Xcalculado<Xcritico){
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
