package com.bruxelles.formation;

import java.util.Random;

public class Creature {
    private String nom;
    private int force;
    private int armure;
    private int vitesse;
    private int pointdevie;
    private int degats;
    private boolean esquiveAttaque=false;
    private boolean bonus=false;
    private  int pointBonus;
    public int cptPerdu=0,cptGagnant=0;
    public Creature()
    {
        Random r= new Random();
        this.force=1+r.nextInt(9);
        this.armure=10;
        this.vitesse=1+r.nextInt(9);
        this.pointdevie=15+r.nextInt(15);
    }
    public Creature(String nom,int force,int armure,int vitesse,int pointdevie)
    {
        this.nom=nom;
        this.force=force;
        this.armure=armure;
        this.vitesse=vitesse;
        this.pointdevie=pointdevie;
    }
    //setters
    public void setNom(String nom)
    {
        this.nom=nom;
    }
    public void setArmure(int armure) {
        this.armure = armure;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }



    public void setForce(int force) {
        this.force = force;
    }

    public void setPointdevie(int pointdevie) {
        this.pointdevie = pointdevie;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }


    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public void setEsquiveAttaque(boolean esquiveAttaque) {
        this.esquiveAttaque = esquiveAttaque;
    }

    public void setPointBonus(int pointBonus) {
        this.pointBonus = pointBonus;
    }
    //getters


    public int getPointdevie() {
        return pointdevie;
    }

    public String getNom() {
        return nom;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getArmure() {
        return armure;
    }

    public int getDegats() {
        return degats;
    }

    public int getForce() {
        return force;
    }

    public int getPointBonus() {
        return pointBonus;
    }

    public boolean isEsquiveAttaque() {
        return esquiveAttaque;
    }

    //methodes
    public void attaque(Creature ennemi)
    {
        System.out.println(this.nom+" attaque "+ennemi.nom);
        if(ennemi.isEsquiveAttaque())
        {
            System.out.println(ennemi.nom+" a esquivé votre attaque!");
        }
        else{
            Random r=new Random();
            if(r.nextInt(100)>=95)
            {
                ennemi.setPointdevie(ennemi.getPointdevie()-1);
                ennemi.setDegats((this.force)*this.vitesse);
                System.out.println(ennemi.nom+" subit "+ennemi.getDegats()+"points de dégats.");
            }
            else{
            ennemi.setPointdevie(ennemi.getPointdevie()-1);
            ennemi.setDegats((this.force/2)*this.vitesse);
            System.out.println(ennemi.nom+" subit "+ennemi.getDegats()+"points de dégats.");
            }
        }
        checkCreatureGagnant(ennemi);
    }
    public void esquive()
    {
        this.setEsquiveAttaque(true);
        this.setPointBonus(this.getPointBonus()+50);
        if(this.pointBonus%100==0)
        {
            System.out.println("Vous avez "+this.getPointBonus()+"points de points de bonus");
            System.out.println("Vous pouvez changez de créature "+((int) this.pointBonus/100)+" fois");
        }
    }
    public void seProteger(Creature ennemi)
    {   //restaure armure
        this.setArmure(getArmure()+5);
        //réduit les dégâts
        this.setDegats(this.getDegats()/2);
        checkCreatureGagnant(ennemi);
    }
    public void changerCreature(Creature pokemon )
    {
        if(getPointBonus()>=100)
        {
            System.out.println("Changement de créature");
            System.out.println(pokemon.nom+" a ton tour");
        }
    }
    public void checkCreatureGagnant(Creature cEnnemi)
    {
        if(cEnnemi.getPointdevie()==0)
        {
            System.out.println( cEnnemi.getNom()+" a perdu contre votre "+this.getNom());
            System.out.println("Votre"+this.getNom()+" a gagné!");
            this.cptGagnant++;
        }
        if(this.getPointdevie()==0)
        {
            System.out.println("Votre "+this.getNom()+ "a perdu!" );
            this.cptPerdu++;
        }
        if( this.cptGagnant==3 || cEnnemi.cptPerdu==3 )
        {
            System.out.println("Vous a gagné!");
        }

    }

}
