package carga;
import java.text.DecimalFormat;
/**
 *
 * @author leonardo
 */
public class Carga {
    public static void main(String[] args) {
        DecimalFormat n = new DecimalFormat("0.0000");
        double ptina = 0;
        int excede=0;
        int Noexcede=0;
        int si = 0;
        int no = 0;
        int semilla=17218;
        int nu =260 ;
        double aleatorio=0;
        System.out.println("#corr"  + "\tTina " + "\t" + "#Alet  " + "\t" 
                           + "P.tina" + "\t" + "P.Acu" + "\t" +"Exceso");
        for(int i=1; i <= nu; i++) {
            double pAcumulado = 0;
            System.out.println(" ");
            for (int j = 1; j <= 5; j++) {
                semilla = (172 * semilla) % 30307;
                aleatorio= (double) semilla / 30307;
                if(aleatorio < 0.5) {
                    ptina = 190 + Math.sqrt(800 * aleatorio);
                    pAcumulado = pAcumulado + ptina;
                }else{
                    ptina = 230 - Math.sqrt(800 * (1 - aleatorio));
                    pAcumulado = pAcumulado + ptina;
                    
                }if (pAcumulado < 1000) {
                    
                    System.out.println(" \t" + j + "\t" + n.format(aleatorio)+"\t" + Math.round(ptina)
                            + "\t" + Math.round(pAcumulado)+"\t"+"no");
                }if(j==5 && pAcumulado<1000){
                    Noexcede ++;
                   
                }if (pAcumulado > 1000) {
                    System.out.println(i+"\t"+j+"\t"+n.format(aleatorio)+"\t"+ Math.round(ptina)
                            + "\t"+Math.round(pAcumulado)+"\t" + "si");
                    excede++;
                    pAcumulado = ptina; 
                }
            }
        }
        double P_exceso=0;
        double P_Noexceso=0;
        P_exceso= (double) excede/nu*100;
        P_Noexceso=(double) Noexcede/nu*100;
        System.out.println("\nexcedio peso: "+ excede);
        System.out.println("no excedio el peso: "+    Noexcede);
        System.out.println("Probabilidad de que exceda: "+P_exceso);
        System.out.println("Probabilidad de que no exceda: "+P_Noexceso);
    }
}