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
    protected ArrayList <Joueur> joueurs;
    protected ArrayList <Arbitre> arbitres;
    protected ArrayList <Spectateur> spectateurs;

    /* Constructors */
    
    /**
     * 14/11/2019
     * @param ville
     * @param categorie
     * @param joueurs
     * @param arbitres
     * @param spectateurs 
     */
    public Tournoi(Ville ville, Categorie categorie, ArrayList <Joueur> joueurs,
            ArrayList <Arbitre> arbitres, ArrayList <Spectateur> spectateurs) {
        
        /* Exeption */
        
        if(categorie == Categorie.DOUBLE_FEMME || categorie == Categorie.DOUBLE_HOMME ||categorie == Categorie.DOUBLE_MIXTE){
            throw new IllegalArgumentException("Seul les tournoi en simple sont autorisé pour l'instant.");
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
     * 14/11/2019
     * @param surface
     * @param categorie
     * @param joueurs 
     * @param arbitres 
     * @param spectateurs 
     */
    public Tournoi(Surface surface, Categorie categorie, ArrayList <Joueur> joueurs,
            ArrayList <Arbitre> arbitres, ArrayList <Spectateur> spectateurs) {
        
        /* Exeption */
        
        if(categorie == Categorie.DOUBLE_FEMME || categorie == Categorie.DOUBLE_HOMME ||categorie == Categorie.DOUBLE_MIXTE){
            throw new IllegalArgumentException("Seul les tournoi en simple sont autorisé pour l'instant.");
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
    
}






























