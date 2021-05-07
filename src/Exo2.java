import java.util.*;
public class Exo2 {

    public static void main(String args[]){
        /**1)Table de multiplication de  2*/
        int i=1,j=2;
        System.out.println("---Table de "+j+" ---");
        while(i<=10){
            System.out.println(i+" * "+j+" = "+(i*j));
            i++;
        }
        /**2)Tables de multiplication de  2 à 9*/

        while(j<10  && i<=10){
            if(i==1)
            System.out.println("---Table de "+j+" ---");
            System.out.println(i+" * "+j+" = "+(i*j));
            i++;
        if(i==10){i=1;j++; }

        }
        /**3)Tables de multiplication de  2 à 9***/
        for(j=2;j<10;j++){
            System.out.println("---Table de "+j+" ---");
            for(i=1;i<=10;i++) System.out.println(i+" * "+ j +" = "+(i*j));
        }
        /**4)pow**/
        Scanner sc=new Scanner(System.in);
        int res=1;
        System.out.println("Entrer un nombre");
        int nb=Integer.parseInt(sc.nextLine());
        System.out.println("Entrer son exposant");
        int exp=Integer.parseInt(sc.nextLine());
        for(int c=0;c<exp;c++)
        {res*=nb;}
        System.out.println(nb+" exposant "+exp+" = "+res );
        /**5)factoriel**/System.out.println("Entrer un nombre pour trouver le factoriel");
        int nombre = Integer.parseInt(sc.nextLine());  res=1;
        for(int f= nombre ;f>0;f--){ res*=f; }
        System.out.println("factoriel de "+nombre +"vaut "+res);/**5)Sapin***/
        System.out.println("Entrer la taille du sapin");/**6)Sapin***/

        System.out.println("Entrer la taille du sapin");

        int hauteur=Integer.parseInt(sc.nextLine());

        //feuilles de sapin
        for(int k=1;k<=hauteur;k++)
        {       //espace
            for(int h=1;h<=hauteur-k;h++)
            {System.out.print(" ");}
            //feuille(s) de sapin
            for(int l=0;l<k+k-1;l++)
            {System.out.print("*");}
            System.out.println();//retour à la ligne
        }
        if(hauteur<=7){
            for(int k=2;k<=hauteur;k++)
            {System.out.print(" ");}//espaces
            System.out.print("#");
        }

        else if(hauteur>7 & hauteur<=14 ){
            //espaces
            //tronc double hauteur
            if(hauteur>10& hauteur<=20 ){i=0;while(i<2){for(int k=0;k<hauteur-2;k++)
            {System.out.print(" ");}
                System.out.println("###");i++; }
            }else{ for(int k=0;k<hauteur-2;k++)
            {System.out.print(" ");}
            System.out.print("###");
        }  }
        else if(hauteur>14 & hauteur<=21 ){

            //tronc double hauteur
            if(hauteur>10& hauteur<=20 ){i=0; while(i<2){for(int k=0;k<hauteur-3;k++)
            {System.out.print(" ");}
                System.out.println("#####");i++; }
            }else{for(int k=0;k<hauteur-2;k++)
            {System.out.print(" ");}
            System.out.print("#####");
}}
        }
}