/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * 13/10/2019
 * @author Nicolas
 */
public class Joueur extends Personne{
    protected Main main;
    protected String sponsor;
    protected int classement;
    protected String entraineur;
    
    protected Vetement vetement;
    protected Couleur couleur;
    
    public static int nbJoueur = 0; // Compte le nombre de joueur
    
    public Joueur   (String nomNaissance, String nomCourant, String prenom,
                    String surnom, Date dateNaissance, String lieuNaissance,
                    Date dateDeces, String nationalite, int taille, int poids,
                    Main main, String sponsor, String entraineur, 
                    Vetement vetement, Couleur couleur){
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        this.main = main;
        this.sponsor = sponsor;
        this.classement = nbJoueur + 1;
        this.entraineur = entraineur;
        
        this.vetement = vetement;
        this.couleur = couleur;
        
        nbJoueur ++;
    }

    /* Getters */ 
    
    /**
     * 21/10/2019
     * @return Main
     */
    public Main getMain() {
        return this.main;
    }

    /**
     * 21/10/2019
     * @return String
     */
    public String getSponsor() {
        return this.sponsor;
    }

    /**
     * 21/10/2019
     * @return int
     */
    public int getClassement() {
        return this.classement;
    }

    /**
     * 21/10/2019
     * @return String
     */
    public String getEntraineur() {
        return this.entraineur;
    }

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
    
    /* Setters */

    /**
     * 21/10/2019
     * @param main 
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * 21/10/2019
     * @param sponsor 
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * 21/10/2019
     * @param entraineur 
     */
    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

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
    
    /**
     * 21/10/2019
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " " + this.main + " " + this.sponsor + " " + 
                this.classement + " " + this.entraineur + " " + this.vetement 
                + " " + this.couleur;
    }
    
    /*servir, retourner un service, renvoyer la balle de l'adversaire, 
    faire des fautes, appeler l'arbitre, s'encourager, boire, criersa victoire/sa défaite*/
    
    public Action servir(){
        // Simulation
        double random = Math.random();
        if(random < 0.33){return Action.SERVICE_CORRECT;}
        else if(0.33 <= random && random < 0.66){return Action.SERVICE_FAUTE;}
        else{return Action.SERVICE_FILET;}
    }
    
    public Action renvoyer(){
        // Simulation
        double random = Math.random();
        if(random < 0.33){return Action.CORRECT;}
        else if(0.33 <= random && random < 0.66){return Action.FAUTE;}
        else{return Action.FILET;}
    }
}



