/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.ArrayList;

/**
 * 11/11/2019
 * @author Nicolas
 */
public class Tournoi {
    protected Ville ville;
    protected Surface surface;
    protected Categorie categorie;
    protected ArrayList <Joueur> joueurs = new ArrayList <Joueur> (128);
    protected ArrayList <Match> matchs = new ArrayList <Match> (127);       // Un tournoi à 128 joueurs se fait en 127 matchs

    /* Constructors */
    
    /**
     * 17/11/2019
     * @param ville
     * @param categorie
     * @param joueurs
     */
    public Tournoi(Ville ville, Categorie categorie, ArrayList <Joueur> joueurs){
        
        /* Exeptions */
        
        // Seuls les matchs en simple seront joués
        if(categorie == Categorie.DOUBLE_FEMME || categorie == Categorie.DOUBLE_HOMME ||categorie == Categorie.DOUBLE_MIXTE){
            throw new IllegalArgumentException("Seul les tournoi en simple sont autorisé pour l'instant.");
        }
        
        // On vérifie qu'il n'y ait pas de femmes dans une catégorie SIMPLE_HOMME
        if(categorie == Categorie.SIMPLE_HOMME){
            for(int i=0; i<joueurs.size(); i++){
                if(joueurs.get(i).getVetement() != Vetement.SHORT){
                    throw new IllegalArgumentException("Il y a une femme inscrite dans un tournoi SIMPLE_HOMME.");
                }
            }
        }
        
        // On vérifie qu'il n'y ait pas d'hommes dans une catégorie SIMPLE_FEMME
        if(categorie == Categorie.SIMPLE_FEMME){
            for(int i=0; i<joueurs.size(); i++){
                if(joueurs.get(i).getVetement() != Vetement.JUPE){
                    throw new IllegalArgumentException("Il y a un homme inscrit dans un tournoi SIMPLE_FEMME.");
                }
            }
        }
        
        switch(ville){
            case LONDRES:
                this.surface = Surface.GAZON;
                break;
            case MELBOURNE:
                this.surface = Surface.PLEXICUSHION;
                break;
            case NEW_YORK:
                this.surface = Surface.DECOTURF;
                break;
            case PARIS:
                this.surface = Surface.TERRE_BATTUE;
                break;
            default:
                throw new IllegalArgumentException("La ville n'est pas comprise dans un championnat du Grand Chelem.");
        }
        
        this.ville = ville;
        this.categorie = categorie;
        this.joueurs = joueurs;
    }
    
    /**
     * 18/11/2019
     * @param surface
     * @param categorie
     * @param joueurs 
     */
    public Tournoi(Surface surface, Categorie categorie, ArrayList <Joueur> joueurs){
        
        /* Exeptions */
        
        // Seuls les matchs en simple seront joués
        if(categorie == Categorie.DOUBLE_FEMME || categorie == Categorie.DOUBLE_HOMME ||categorie == Categorie.DOUBLE_MIXTE){
            throw new IllegalArgumentException("Seul les tournoi en simple sont autorisé pour l'instant.");
        }
        
        // On vérifie qu'il n'y ait pas de femmes dans une catégorie SIMPLE_HOMME
        if(categorie == Categorie.SIMPLE_HOMME){
            for(int i=0; i<joueurs.size(); i++){
                if(joueurs.get(i).getVetement() != Vetement.SHORT){
                    throw new IllegalArgumentException("Il y a une femme inscrite dans un tournoi SIMPLE_HOMME.");
                }
            }
        }
        
        // On vérifie qu'il n'y ait pas d'hommes dans une catégorie SIMPLE_FEMME
        if(categorie == Categorie.SIMPLE_FEMME){
            for(int i=0; i<joueurs.size(); i++){
                if(joueurs.get(i).getVetement() != Vetement.JUPE){
                    throw new IllegalArgumentException("Il y a un homme inscrit dans un tournoi SIMPLE_FEMME.");
                }
            }
        }
        
        switch(surface){
            case GAZON:
                this.ville = Ville.LONDRES;
                break;
            case PLEXICUSHION:
                this.ville = Ville.MELBOURNE;
                break;
            case DECOTURF:
                this.ville = Ville.NEW_YORK;
                break;
            case TERRE_BATTUE:
                this.ville = Ville.PARIS;
                break;
            default:
                throw new IllegalArgumentException("La ville n'est pas comprise dans un championnat du Grand Chelem.");
        }
        
        this.surface = surface;
        this.categorie = categorie;
        this.joueurs = joueurs;
    }
    
    /* Getters */

    public Ville getVille() {
        return this.ville;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public ArrayList<Joueur> getJoueurs() {
        return this.joueurs;
    }

    public ArrayList<Match> getMatchs() {
        return this.matchs;
    }
    
    /* Methods */
    
    /*
    private ArrayList<Joueur> fillJoueur(){
        // En construction
    }
    */
}



