/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import data.FileData;

import java.time.LocalDate; // import the LocalDate class
import java.util.ArrayList;

/**
 * <b>Cette classe (abstraite) rescence les instances communes aux arbitres, joueurs et spectateurs.</b>
 * @since 13/10/2019
 * @author Nicolas
 * @see Arbitre
 * @see Joueur 
 * @see Spectateur
 * @see Date
 * @see ArrayList
 * @see FileData
 */
public abstract class Personne{
    protected String nomNaissance;
    protected String nomCourant;
    protected String prenom;
    protected String surnom;
    protected Date dateNaissance;
    protected String lieuNaissance;
    protected Date dateDeces;
    protected String nationalite;
    protected int taille;
    protected int poids;
    
    public static int nbPersonne = 0; // Compte le nombre de personne
    
     
    protected static ArrayList <String> prenomMasculin = FileData.getData("prenomMasculin");
    protected static ArrayList <String> prenomFeminin = FileData.getData("prenomFeminin");
    protected static ArrayList <String> nomFamille = FileData.getData("nomFamille");
    protected static ArrayList <String> villeNaissance = FileData.getData("villeNaissance");
    protected static ArrayList <String> pays = FileData.getData("pays");
    protected static ArrayList <String> sponsor = FileData.getData("sponsor");
    
    /* Constructor */
    /**
     * @since 21/10/2019
     * @param nomNaissance
     * @param nomCourant
     * @param prenom
     * @param surnom
     * @param dateNaissance
     * @param lieuNaissance
     * @param dateDeces
     * @param nationalite
     * @param taille
     * @param poids 
     */
    public Personne(String nomNaissance, String nomCourant, String prenom,String surnom, Date dateNaissance, String lieuNaissance,Date dateDeces, String nationalite, int taille, int poids){
        this.nomNaissance = nomNaissance;
        this.nomCourant = nomCourant;
        this.prenom = prenom;
        this.surnom = surnom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.dateDeces = dateDeces;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        
        nbPersonne++;
    }
    
    
    /* Getters */

    /**
     * @return String
     */
    public String getNomNaissance() {
        return this.nomNaissance;
    }

    /**
     * @return String
     */
    public String getNomCourant() {
        return this.nomCourant;
    }

    /**
     * @return String
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * @return String
     */
    public String getSurnom() {
        return this.surnom;
    }

    /**
     * @return Date
     */
    public Date getDateNaissance() {
        return this.dateNaissance;
    }

    /**
     * @return String
     */
    public String getLieuNaissance() {
        return this.lieuNaissance;
    }

    /**
     * @return Date
     */
    public Date getDateDeces() {
        return this.dateDeces;
    }

    /**
     * @return String
     */
    public String getNationalite() {
        return this.nationalite;
    }

    /**
     * @return int
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * @return int
     */
    public int getPoids() {
        return this.poids;
    }
    
    /**
     * Cette méthode calcule et renvoie l'age de la personne
     * @return int
     */
    public int getAge(){
        LocalDate now = LocalDate.now();
        int age = now.getYear() - this.getDateNaissance().getAnnee();
        if(now.getMonthValue() - this.getDateNaissance().getMois() < 0){age--;}
        else if(now.getMonthValue() - this.getDateNaissance().getMois() == 0){
            if(now.getDayOfMonth() - this.getDateNaissance().getJour()< 0){age--;}
        }
        return age;
    }
    
    
    /* Setters */

    /**
     * @param nomCourant 
     */
    public void setNomCourant(String nomCourant) {
        this.nomCourant = nomCourant;
    }

    /**
     * @param surnom 
     */
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    /**
     * @param nationalite 
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * @param poids 
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }
    
    /**
     * @param taille 
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    
    /* Methods */
    
    /**
     * Cette méthode revoie les valeurs des variables d'instances de la personne. 
     * @since 21/10/2019
     * @return String
     */
    @Override
    public String toString(){
        return this.nomNaissance + " " + this.nomCourant + " " + this.prenom 
                + " " + this.surnom + " " + this.dateNaissance + " " + 
                this.lieuNaissance + " " + this.dateDeces + " " + 
                this.nationalite + " " + this.taille + " " + this.poids;
    }
}

