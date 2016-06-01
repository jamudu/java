//superheroes
package superheroes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author jaume
 */
public class Superheroes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int puntuacio [] = new int[2];
        String nomSuperh[] = new String[2];
        int elements [][] = new int [4][3];
        String miss =" ";
        String miss2 = "";
        int opcio=0;
        
        //usuarisEscollits(escollits);
        //entrarElements(escollits, elements, nomElem);
    
        do{
         menu();
         miss="introdueix opcio: ";
         miss2="el valor ha de estar entre 1 i 5";
         opcio=(int)(demanarNumeroDec(miss,miss2, 1,5,0));
         switch (opcio){
          case 1:
             registSuperh(nomSuperh);
             break;
          case 2:
             nivellHabilitat(puntuacio, nomSuperh, buscarSuperh(nomSuperh));
             break;
          case 3:
             //especialista(elements, escollits, nomElem);
             break;
          case 4:
             //modificar(escollits, elements, nomElem);
             break;
          }
       }while (opcio!=5);
    }

//funcio nivellHabilitat 
    public static void nivellHabilitat(int array[], String array2[], int superH){     //throws IOException{
       BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
       Random aleatori = new Random();
       String miss="";
       miss="hola " + igualar(array2[superH].toLowerCase(),10) + " entra nivell de dificaultat (1)baix, (2)alt: ";
       int nivell=(int)demanarNumeroDec(miss, "", 1,2,0);
       switch (nivell){
           case 1:
             int numero = aleatori.nextInt(20) + 1;
             int adivina=0, cont=0;
             boolean trobat=false;
             do{
                miss="\nintrodueix numero del 1 al 20: ";
                adivina=(int)demanarNumeroDec(miss,"",1,20,0);
                cont ++;
                if (adivina==numero){
                     array[superH]++;
                     System.out.println("molt be, sumes 1 punt. TOTAL " + array[superH]+ "\n");
                     trobat=true;
                }else if (cont==5){
                     System.out.println("no ho has adivinat. el numero es el " + numero);
                     System.out.println("has aconseguit 0 punts\n");
                }else if (adivina>numero){
                     System.out.println("el numero es mes petit que " + adivina);
                }else{
                     System.out.println("el numero es mes gran " + adivina);
                }
             }while (cont<5 && !trobat);
               break;
           case 2:
               break;
       }
    }

    
//funcio buscar superheroi
    public static int buscarSuperh(String array[])throws IOException{
       BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
       int index=0;
       String nom="";
       do{
          System.out.println();
          System.out.print("introdueix superheroi: ");
          nom=(bb.readLine());
          if (!"superman".equalsIgnoreCase(nom) && !"batman".equalsIgnoreCase(nom)){
             System.out.println("el nom nomes pot ser 'superman' o 'batman'");
          }
       }while (!"superman".equalsIgnoreCase(nom) && !"batman".equalsIgnoreCase(nom));
       for (int i=0;i<array.length;i++){
          if (nom.equalsIgnoreCase(array[i])) index=i;
        }
        System.out.println();
        return index;
    }

//funcio entrar superherois
    public static void registSuperh(String array[])throws IOException{
       BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
       System.out.println();
       for (int i=0;i<array.length;i++){
             System.out.print("introdueix superheroi " + (i+1) + " : ");
             array[i]=(bb.readLine());
             if (!"superman".equalsIgnoreCase(array[i]) && !"batman".equalsIgnoreCase(array[i])){
                System.out.println("el nom nomes pot ser 'superman' o 'batman'\n");
                i--;
             }
          }
          System.out.println();
    }

//funcio igualar longitud nom
    public static String igualar(String nom, int longi){
      String espai = "                              ";
      nom = nom + espai.substring(1,longi-nom.length());
      return nom; 
    }      
    
//funcio que demana un numero enter o decimal (si tipo=0 enter, si tipo=1 decimal)
    public static double demanarNumeroDec(String frase, String fraserror, int min, int max, int tipo) {
        BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
        boolean error = false;
        double numero = 0;
        do {
            try {
                do {
                    error = false;
                    System.out.print(frase);
                    numero = Double.parseDouble(bb.readLine());
                    if (numero < min || numero > max) {
                        if (fraserror.equals("")){
                           System.out.println("numero fora d'interval");
                        }else{
                        System.out.println(fraserror);
                        }
                    }
                    if (tipo == 0 && (int) numero != numero) {
                        System.out.println("el numero ha de ser enter");
                        numero = min - 1;
                    }
                } while (numero < min || numero > max);
                return numero;
            } catch (IOException ex) {
                System.out.println("error de entrada sortida");
                error = true;
                return 0;
            } catch (NumberFormatException ex) {
                System.out.println("ha de ser un numero\n");
                error = true;
            }
        } while (error);
        return 0;
    }

//funcio menu
    public static void menu() {
        System.out.println(" *** S U P E R H E R O E S ***\n");
        System.out.println(" 1 - registrar superheroe");
        System.out.println(" 2 - millorar habilitat");
        System.out.println(" 3 - la gran batalla");
        System.out.println(" 4 - resultat final");
        System.out.println(" 5 - sortir\n");
    }
}
