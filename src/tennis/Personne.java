/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.time.LocalDate; // import the LocalDate class

/**
 * 13/10/2019
 * @author Nicolas
 */
public abstract class Personne {
    private String nomNaissance;
    private String nomCourant;
    private String prenom;
    private String surnom;
    private Date dateNaissance;
    private String lieuNaissance;
    private Date dateDeces;
    private String nationalite;
    private int taille;
    private int poids;
    
    public static int nbPersonne = 0; // Compte le nombre de personne
    
    /* Listes des prénoms masculins, féminins et nom de famille */ 
    public static String [] prenomMasculin = {"Alexandre","Aurélien","Baptiste",
        "Clément","Dorian","Florian","Gaétan", "Grégoire","Julien","Louis",
        "Maxime","Nicolas","Paul","Pierre","Quentin","Romain","Thibaud","Thomas",
        "Valentin","Vincent"};
    
    public static String [] prenomFeminin = {"Amélie","Aurélie","Axelle",
        "Camille","Cloé","Flora","Garance","Jade","Julie","Lucie","Manon",
        "Mélanie","Nicole","Pauline","Perrine","Romane","Roxane","Théa",
        "Valentine","Zoé"};
    
    public static String [] nomFamille = {"MARTIN","BLANC","DUBOIS",
        "RICHARD","PETIT","LEROY","LEFEBVRE","FOURNIER","GIRARD","MERCIER","DUPONT",
        "LAMBERT","MARTINEZ","LEGRAND","ROUSSEAU","MULLER","HENRY","MASSON",
        "LEMAIRE","DUVAL"};
    
    // Cette liste est utiliser pour la génération de joueurs, arbitres et spectateurs
    public static String [] villeNaissance = {"Paris","Marseille","Lyon",
        "Bordeaux","Strasbourg","Lille","Grenoble","Toulouse","Toulon","Nice","Metz",
        "Brest","Amiens","Nancy","Saint-Etienne","Tours","Orléans","Annecy",
        "Lorient","Rennes"};
    
    public static String [] pays = {"Allemange","Autriche","Belgique",
        "Croatie","Damemark","Espagne","Finlande", "France","Grèce","Hongrie",
        "Irlande","Italie","Luxembourg","Monaco","Norvège","Pays-Bas","Pologne","Portugal",
        "Royaume-Uni","Ukraine"};
    
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
