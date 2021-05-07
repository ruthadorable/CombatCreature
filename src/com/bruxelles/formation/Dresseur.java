package com.bruxelles.formation;
import java.util.*;
public class Dresseur {
    private String nom;
    private ArrayList <Creature> creatures=new ArrayList<Creature>(3);
    private int pointBonus=0;
    public int indicePokemon;

    public Dresseur()
    {

    }
    public Dresseur(String nom)
    {
        this.nom=nom;
    }
    public Dresseur(String nom, ArrayList <Creature> listPokemon)
    {
        this.nom=nom;
        this.creatures=listPokemon;
    }

    public String getNom() {
        return this.nom;
    }

    public ArrayList<Creature> getCreatures() {
        return this.creatures;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCreatures(ArrayList<Creature> pokemons) {
        this.creatures = pokemons;
    }


    public void changerCreature()
    {
        if(getPointBonus()>=100)
        {
            System.out.println("Changement de créature");
        }
    }
    public void addCreature()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Entrer le nom du pokemon");
        String nom=sc.nextLine();
        System.out.println("Entrer la valeur de force entre 1 et 10");
        int force=Integer.parseInt(sc.nextLine());
        force=gereErreur(force,1,10);
        System.out.println("Entrer la valeur de l'armure entre 1 et 10");
        int armure=Integer.parseInt(sc.nextLine());
        armure=gereErreur(armure,1,10);
        System.out.println("Entrer la valeur de la vitesse entre 1 et 10");
        int vitesse=Integer.parseInt(sc.nextLine());
        vitesse=gereErreur(vitesse,1,10);
        System.out.println("Entrer les points de vie initials");
        int pdv=Integer.parseInt(sc.nextLine());
        pdv=gereErreur(pdv,15, 30);
        Creature p=new Creature(nom,force,armure,vitesse,pdv);
        creatures.add(p);
    }
    public int getPointBonus()
    {
        return this.pointBonus;
    }
    public static int gereErreur(int input,int min , int max)
    {
        Scanner sc=new Scanner(System.in);
        while(input>max || input<min)
        {System.out.println("Erreur la valeur doit etre compris entre "+min+" et"+ max);
            input=Integer.parseInt(sc.nextLine());
        }
        return input;
    }
}
