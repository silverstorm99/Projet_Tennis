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
 * 13/10/2019
 * @author Nicolas
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
    
    /**
     * 21/10/2019
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
     * 13/10/2019
     * @return String
     */
    public String getNomNaissance() {
        return this.nomNaissance;
    }

    /**
     * 13/10/20219
     * @return String
     */
    public String getNomCourant() {
        return this.nomCourant;
    }

    /**
     * 13/10/2019
     * @return String
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * 13/10/2019
     * @return String
     */
    public String getSurnom() {
        return this.surnom;
    }

    /**
     * 13/10/2019
     * @return Date
     */
    public Date getDateNaissance() {
        return this.dateNaissance;
    }

    /**
     * 13/10/2019
     * @return String
     */
    public String getLieuNaissance() {
        return this.lieuNaissance;
    }

    /**
     * 13/10/2019
     * @return Date
     */
    public Date getDateDeces() {
        return this.dateDeces;
    }

    /**
     * 13/10/2019
     * @return String
     */
    public String getNationalite() {
        return this.nationalite;
    }

    /**
     * 13/10/2019
     * @return int
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * 13/10/2019
     * @return int
     */
    public int getPoids() {
        return this.poids;
    }
    
    /**
     * 13/10/2019
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
     * 13/10/2019
     * @param nomCourant 
     */
    public void setNomCourant(String nomCourant) {
        this.nomCourant = nomCourant;
    }

    /**
     * 13/10/2019
     * @param surnom 
     */
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    /**
     * 13/10/2019
     * @param nationalite 
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     * 13/10/2019
     * @param poids 
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }
    
    /**
     * 21/10/2019
     * @param taille 
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    /* Methods */
    
    /**
     * 21/10/2019
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
