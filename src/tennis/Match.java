/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * 25/10/2019
 * @author Nicolas
 */
public class Match {
    protected Categorie categorie;
    protected Phase phase;
    protected Arbitre [] arbitres;
    protected Joueur[] joueurs;
    protected Spectateur[] spectateurs;
    
    
    /* Constructors */
    
    /**
     * 25/10/2019
     * @param categorie
     * @param phase
     * @param arbitres
     * @param joueurs
     * @param spectateurs 
     */
    public Match(Categorie categorie, Phase phase, Arbitre [] arbitres, 
            Joueur [] joueurs, Spectateur [] spectateurs) {
        
        /* Exceptions */
        
        // On vérifie si il y a bien que deux joueurs homme dans un match simple homme
        if(categorie == Categorie.SIMPLE_HOMME){
            if(joueurs.length != 2){throw new IllegalArgumentException("Il n'y a pas que deux joueurs homme dans un match simple homme.");}
            for(Joueur joueur : joueurs){
                if(joueur.getVetement() != Vetement.SHORT){
                    throw new IllegalArgumentException("Il y a au moins un joueur femme dans un match simple homme.");
                }
            }
        }

        // On vérifie si il y a bien que quatres joueurs homme dans un match double homme
        if(categorie == Categorie.DOUBLE_HOMME){
            if(joueurs.length != 4){throw new IllegalArgumentException("Il n'y a pas que quatres joueurs homme dans un match double homme.");}
            for(Joueur joueur : joueurs){
                if(joueur.getVetement() != Vetement.SHORT){
                    throw new IllegalArgumentException("Il y a au moins un joueur femme dans un match double homme.");
                }
            }
        }
        
        // On vérifie si il y a bien que deux joueurs femme dans un match simple femme
        if(categorie == Categorie.SIMPLE_FEMME){
            if(joueurs.length != 2){throw new IllegalArgumentException("Il n'y a pas que deux joueurs femme dans un match simple femme.");}
            for(Joueur joueur : joueurs){
                if(joueur.getVetement() != Vetement.JUPE){
                    throw new IllegalArgumentException("Il y a au moins un joueur homme dans un match simple femme.");
                }
            }
        }
        
        // On vérifie si il y a bien que quatres joueurs femme dans un match double femme
        if(categorie == Categorie.DOUBLE_FEMME){
            if(joueurs.length != 4){throw new IllegalArgumentException("Il n'y a pas que quatres joueurs femme dans un match double femme.");}
            for(Joueur joueur : joueurs){
                if(joueur.getVetement() != Vetement.JUPE){
                    throw new IllegalArgumentException("Il y a au moins un joueur homme dans un match double femme.");
                }
            }
        }
        
        System.out.println(joueurs.length);
        
        this.categorie = categorie;
        this.phase = phase;
        this.arbitres = arbitres;
        this.joueurs = joueurs;
        this.spectateurs = spectateurs;
    }
    
    
    /* Getters */
    
    /**
     * 25/10/2019
     * @return Categorie
     */
    public Categorie getCategorie() {
        return this.categorie;
    }
    
    /**
     * 25/10/2019
     * @return Phase
     */
    public Phase getPhase() {
        return this.phase;
    }
    
    /**
     * 25/10/2019
     * @return Arbitre[]
     */
    public Arbitre [] getArbitres() {
        return this.arbitres;
    }

    /**
     * 25/10/2019
     * @return Joueur[]
     */
    public Joueur [] getJoueurs() {
        return this.joueurs;
    }

    /**
     * 25/10/2019
     * @return Spectateur[]
     */
    public Spectateur [] getSpectateurs() {
        return this.spectateurs;
    }    
}

