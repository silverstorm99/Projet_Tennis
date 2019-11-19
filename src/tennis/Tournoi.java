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
        this.joueurs = joueurs; // On enregistre les joueurs déjà enregistrer manuellement
        this.genererJoueur();   // On génère le reste de joueur pour atteindre les 128 joueurs du tournois
        this.genererMatch();
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
        this.genererMatch();
    }
    
    /* Getters */

    /**
     * 18/11/2019
     * @return Ville
     */
    public Ville getVille() {
        return this.ville;
    }

    /**
     * 18/11/2019
     * @return Surface
     */
    public Surface getSurface() {
        return this.surface;
    }

    /**
     * 18/11/2019
     * @return Categorie
     */
    public Categorie getCategorie() {
        return this.categorie;
    }

    /**
     * 18/11/2019
     * @return ArrayList 
     */
    public ArrayList <Joueur> getJoueurs() {
        return this.joueurs;
    }

    /**
     * 18/11/2019
     * @return ArrayList
     */
    public ArrayList<Match> getMatchs() {
        return this.matchs;
    }
    
    /* Methods */
    
    /**
     * 18/11/2019
     * Cette méthode permet de générer les 127 matchs du tournoi
     */
    private void genererMatch(){
        int nbArbitres = 10, nbSpectateurs = 100;
        Phase phase;
        
        for(int i=0; i<127; i++){
            Arbitre [] arbitres = new Arbitre [nbArbitres];
            Spectateur [] spectateurs = new Spectateur [nbSpectateurs];
            
            // Génération des arbitres
            for(int j=0; j<nbArbitres; j++){
                spectateurs[j] = Spectateur.generer();
            }
            // Génération des spectateurs
            for(int j=0; j<nbArbitres; j++){
                arbitres[j] = Arbitre.generer();
            }
            
            if(i > 125){phase = Phase.FINALE;}
            else if(i > 123){phase = Phase.DEMI_FINALE;}
            else if(i > 119){phase = Phase.QUART_FINALE;}
            else if(i > 111){phase = Phase.HUITIEME_FINALE;}
            else if(i > 95){phase = Phase.TROISIEME_TOUR;}
            else if(i > 63){phase = Phase.DEUXIEME_TOUR;}
            else{phase = Phase.PREMIER_TOUR;}
            
            Match match = new Match(this.categorie, phase, arbitres, spectateurs);
            this.matchs.add(match);
        }
    }
    
    /**
     * 18/11/2019
     * Cette méthode permet de remplir la list des joueurs du tournoi
     */
    private void genererJoueur(){
        int nbJoueurs = 128;
        Vetement vetement;
        
        switch(this.categorie){
            case SIMPLE_HOMME:
                vetement = Vetement.SHORT;
                break;
            case SIMPLE_FEMME:
                vetement = Vetement.JUPE;
                break;
            case DOUBLE_HOMME:
                vetement = Vetement.SHORT;
                break;
            case DOUBLE_FEMME:
                vetement = Vetement.JUPE;
                break;
            default:
                vetement = (Math.random()<0.5) ? Vetement.SHORT : Vetement.JUPE;
                break;
        }
        
        for(int i=this.joueurs.size(); i<nbJoueurs; i++){
            if(this.categorie == Categorie.SIMPLE_MIXTE || this.categorie == Categorie.DOUBLE_MIXTE){
                vetement = (Math.random()<0.5) ? Vetement.SHORT : Vetement.JUPE;
            }
            this.joueurs.add(Joueur.generer(vetement));
        }
    }
    
    /**
     * 19/11/2019
     */
    public void play(){
        ArrayList <Joueur> vainqueursPremierTour = new ArrayList <Joueur> (64);
        ArrayList <Joueur> vainqueursDeuxiemeTour = new ArrayList <Joueur> (32);
        ArrayList <Joueur> vainqueursTroisiemeTour = new ArrayList <Joueur> (16);
        ArrayList <Joueur> vainqueursHuitiemeFinale = new ArrayList <Joueur> (8);
        ArrayList <Joueur> vainqueursQuartFinale = new ArrayList <Joueur> (4);
        ArrayList <Joueur> vainqueursDemiFinale = new ArrayList <Joueur> (2);
        ArrayList <Joueur> vainqueursFinal = new ArrayList <Joueur> (1);
        
        // On mets les 128 joueurs dans les matchs du PREMIER_TOUR
        for(int i=0; i<127; i+=2){
            Joueur [] equipe1 = {this.joueurs.get(i)};
            Joueur [] equipe2 = {this.joueurs.get(i+1)};
            this.matchs.get(i/2).setEquipe1(equipe1);
            this.matchs.get(i/2).setEquipe2(equipe2);
        }
        
        // On joue les match du premier tour
        for(int i=0; i<64;i++){
            System.out.println("---------------------------- MATCH "+i+" ----------------------------------------------");
            vainqueursPremierTour.add(this.matchs.get(i/2).play()[0]);
        }
        /*
        for(int i=0; i<64;i++){
            System.out.println(vainqueursPremierTour.get(i).toString());
        }
        */
    }
}



