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
public class Spectateur extends Personne{
    protected Vetement vetement;
    protected Couleur couleur;
    protected Billet billet;
    
    public static int nbSpectateur = 0; // Compte le nombre de spectateur
    
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
     * @param vetement
     * @param couleur 
     */
    public Spectateur(String nomNaissance, String nomCourant, String prenom,
                    String surnom, Date dateNaissance, String lieuNaissance,
                    Date dateDeces, String nationalite, int taille, int poids,
                    Vetement vetement, Couleur couleur){
        
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        this.vetement = vetement;
        this.couleur = couleur;
        
        nbSpectateur++;
    }
    
    
    /* Getters */
    
    
    /**
     * 21/10/2019
     * @return Vetement
     */
    public Vetement getVetement() {
        return this.vetement;
    }

    /**
     * 21/10/2019
     * @return Couleur
     */
    public Couleur getCouleur() {
        return this.couleur;
    }
    
    /**
     * 21/10/2019
     * @return Billet
     */
    public Billet getBillet(){
        return this.billet;
    }
    
    
    /* Setters */
    
    
    /**
     * 21/10/2019
     * @param vetement 
     */
    public void setVetement(Vetement vetement) {
        this.vetement = vetement;
    }

    /**
     * 21/10/2019
     * @param couleur 
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur; 
    }
    
    
    /* Methods */
    
    public void acheterBillet(int prix, Tribune tribune, int place){
        this.billet = new Billet(prix, tribune, place);
    }
    
    public void applaudir(){
        System.out.println("CLAP CLAP CLAP");
    }
    public void crier(){
        System.out.println("ALLEZ !!!");
    }
    public void huer(){
        System.out.println("BOOOOOOOOOOO !!!! NUL !");
    }
    public void dormir(){
        System.out.println("ZzZzZzZzZzZzZ");
    }
}



























