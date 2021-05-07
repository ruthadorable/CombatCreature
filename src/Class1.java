import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;
public class Class1 {
    public static void main(String []args){
        /*1. Année bissextile
        Réaliser un petit algorithme qui sur base d’une année donnée va déterminer
        s’il s’agit d’une année bissextile.Une année est bissextile si elle est
        divisible par 4, mais non divisible par 100. Ou si elle est divisible par 400.


        2. Calculatrice
        Réaliser l’algorithme d’une calculatrice basique.
                L’utilisateur est invité à saisir un nombre, un opérateur et un deuxième nombre.
                La calculatrice affiche ensuite le résultat sous la forme
        "Le resultat de NB1 OPERATION NB2 est de RESULTAT"

        Les opération supporté sont : +  -  x  /
                Attention, il faut prendre en compte la division par Zero


        3. Gestion de date.
                L'utilisateur est invité à entrer une date via 3 saisie (jour, mois et année).
        Etape 1 : L'algorithme vérifie que la date encodé est valide.
        Etape 2 : Obtenir le jour de la semaine (Lundi, mardi, ...)
        Tips : https://fr.wikibooks.org/wiki/Curiosit%C3%A9s_math%C3%A9matiques/Trouver_le_jour_de_la

         */

        /**N1 Année bissextile**/
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrer une année ");
        int annee=Integer.parseInt(sc.nextLine());
        if((annee%4 ==0 && annee %100!=0 )||annee %400==00 )
        {
            System.out.println("L'année "+annee+" est bissextile");
        }
        else{
            System.out.println("L'annee"+annee+"n'est pas bissextile");
        }
        /***Calculatrice**/

        int continuer=1;
        while(continuer==1){
            System.out.println("Entrer un calcul");
            double nb1=Integer.parseInt(sc.nextLine());
            String operation= sc.nextLine().toString();
            double nb2=Double.parseDouble(sc.nextLine());
        try{
        if(operation.equals("+")){
            System.out.println(nb1+" + "+nb2+"="+(nb1+nb2) );
        }
        if(operation.equals("-")){
            System.out.println(nb1+" - "+nb2 +"= "+(nb1-nb2));
        }
        if(operation.equals(("*")))
        {
            System.out.println(nb1+" * "+nb2 +"= "+(nb1*nb2));
        }
        if(operation.equals(("/")))
        {
            System.out.println(nb1+" / "+nb2 +"= "+(nb1/nb2));
        }
        if(operation.equals(("%")))
        {
            System.out.println(nb1+" % "+nb2 +"= "+(nb1%nb2));
        } }
        catch(RuntimeException e){
            e.printStackTrace();
            System.out.println(e);
            continue;
        }
            System.out.println("Entrer un autre calcul? 1 pour oui/0 pour non");
            continuer=Integer.parseInt(sc.nextLine());
        }
        /**Gestion de date**/

        continuer=1;
        while(continuer==1)
        {
        System.out.println("Entrer une date Annee, Mois,Jour");
        int an=Integer.parseInt(sc.nextLine());
        int mois=Integer.parseInt(sc.nextLine());
        int jour=Integer.parseInt(sc.nextLine());
        LocalDate d=null;

        try
        {
            d=LocalDate.of(an,mois,jour);

        }
        catch(Exception e){
            System.out.println(e);


        }finally{

            System.out.println(d.getDayOfWeek());

            System.out.println("Entrer une autre date? 0/1");
            continuer=Integer.parseInt(sc.nextLine().toString());
        }
        }

        }


}
