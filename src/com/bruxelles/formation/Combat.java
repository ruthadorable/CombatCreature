package com.bruxelles.formation;
import java.util.*;
public class Combat {
    private Dresseur[] dresseurs= new Dresseur[2];
    private  Creature[] creature=new Creature[2];
    private int round=1;
    private int numcreature;
    private int numcreature0,numcreature1;
    private boolean tourDresseur0;
    private boolean finPartie=false;
    public Combat()
    {
        this.round=5;
    }
    public Combat(Dresseur dresseur1,Dresseur dresseur2)
    {
        dresseurs[0]=dresseur1;
        dresseurs[1]=dresseur2;
        this.round=5;
    }
    public void declarerJoueursEtPokemons()
    {
        Scanner sc=new Scanner(System.in);
        Dresseur d=new Dresseur();
        for(int i=0;i<2;i++){
        System.out.println("Entrer le nom du joueur "+(i+1));
        String nom=sc.nextLine();
        dresseurs[i]=new Dresseur(nom);
            System.out.println("Creer ses 3 pokemons");
            for(int j=0;j<3;j++)
            {
                System.out.println("Pokemon "+(j+1));
                this.dresseurs[i].addCreature();
            }
        }
    }
    public void commence()
    {
        System.out.println( dresseurs[0].getNom() +" vs "+dresseurs[1].getNom());
        Random r = new Random();
        numcreature=r.nextInt(3);
        for(int i=0;i<2;i++)
        {
            creature[i]=dresseurs[i].getCreatures().get(r.nextInt(numcreature));
            System.out.println(dresseurs[i].getNom()+" lance "+creature[i].getNom());
        }

    }
    public void debutCombat()
    {
        System.out.println("---Début du combat---");
        System.out.println("Round "+round);
        if(dresseurs[0].getCreatures().get(numcreature).getVitesse()>dresseurs[0].getCreatures().get(numcreature).getVitesse())
        {
            dresseurs[0].getCreatures().get(numcreature).attaque(dresseurs[1].getCreatures().get(numcreature));
            tourDresseur0=true;
        }
        else{
            dresseurs[1].getCreatures().get(numcreature).attaque(dresseurs[0].getCreatures().get(numcreature));
            tourDresseur0=false;
        }
        numcreature0=numcreature1=numcreature;

    }
    public void ennemiCombat()
    {
        Random r=new Random();
        final int num=r.nextInt(3);
        switch(num)
        { // l'ennemi attaque
            case 1: if(tourDresseur0)
                    {   tourDresseur0=false;
                        dresseurs[1].getCreatures().get(numcreature1).attaque(dresseurs[0].getCreatures().get(numcreature0));
                    }
                    else
                    {   tourDresseur0=true;
                        dresseurs[0].getCreatures().get(numcreature1).attaque(dresseurs[1].getCreatures().get(numcreature0));
                    }
                    break;
             //l'ennemi esquive l'attaque
            case 2: if(tourDresseur0)
                {   tourDresseur0=false;
                    dresseurs[1].getCreatures().get(numcreature1).esquive();
                }
                else
                {   tourDresseur0=true;
                    dresseurs[0].getCreatures().get(numcreature0).esquive();
                }
                    break;
            //l'ennemi sort l'armure
            case 3: if(tourDresseur0)
            {   tourDresseur0=false;
                dresseurs[1].getCreatures().get(numcreature1).seProteger(dresseurs[0].getCreatures().get(numcreature0));
            }
            else
            {   tourDresseur0=true;
                dresseurs[0].getCreatures().get(numcreature0).seProteger(dresseurs[1].getCreatures().get(numcreature1));
            }
                break;
            default: if(tourDresseur0)
            {   tourDresseur0=false;
                Creature c=dresseurs[1].getCreatures().get(r.nextInt(3));
                dresseurs[1].getCreatures().get(numcreature).changerCreature(c);
                dresseurs[1].indicePokemon=dresseurs[1].getCreatures().indexOf(c);
                numcreature1=dresseurs[1].indicePokemon;
            }
            else
            {   tourDresseur0=true;
                Creature c=dresseurs[0].getCreatures().get(r.nextInt(3));
                dresseurs[0].getCreatures().get(numcreature).changerCreature(c);
                dresseurs[0].indicePokemon=dresseurs[0].getCreatures().indexOf(c);
                numcreature0=dresseurs[1].indicePokemon;
            }
                break;
        }


    }
    public void checkDresseurGagnant()
    {
        if( dresseurs[0].getCreatures().get(numcreature0).cptGagnant==3 || dresseurs[1].getCreatures().get(numcreature1).cptPerdu==3 )
        {
            System.out.println(dresseurs[0]+" a gagné!");
            finPartie=true;
        }
        else if(dresseurs[1].getCreatures().get(numcreature1).cptGagnant==3 || dresseurs[0].getCreatures().get(numcreature0).cptPerdu==3)
        {   System.out.println(dresseurs[1]+" a gagné!");
            finPartie=true;
        }
    }
    public static void main(String []args)
    {
        Combat duel=new Combat();
        duel.declarerJoueursEtPokemons();
        duel.commence();
        duel.debutCombat();
        while(duel.round<6 && duel.finPartie==false)
        {
        for(int i=0;i<10;i++) {
            duel.ennemiCombat();
            duel.checkDresseurGagnant();

        }
        duel.round++;
        }

    }
}
