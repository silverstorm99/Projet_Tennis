/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * 21/10/2019
 * @author Nicolas
 */
public class Arbitre extends Personne{
    
    public static int nbArbitre = 0; // Compte le nombre d' arbitre
    
    /* Constructor */
    
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
    public Arbitre(String nomNaissance, String nomCourant, String prenom,
                    String surnom, Date dateNaissance, String lieuNaissance,
                    Date dateDeces, String nationalite, int taille, int poids){
        
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        
        nbArbitre++;
    }
    
    
    /* Methods */
    
    /**
     * 21/10/2019
     * @param score1
     * @param score2
     */
    public void annoncerScoreSet(int score1, int score2){
        System.out.println("Set : " + String.valueOf(score1) + "-" + String.valueOf(score2));
    }
}
