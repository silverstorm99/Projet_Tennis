/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * <b>Cette classe permet de créer un tournoi pour 128 joueurs.</b>
 * @since 11/11/2019
 * @author Nicolas
 * @see Joueur
 * @see Arbitre
 * @see Spectateur
 * @see Ville
 * @see Surface
 * @see Categorie
 * @see ArrayList
 * @see Match
 * @see Random
 */
public class Tournoi {
    protected Ville ville;
    protected Surface surface;
    protected Categorie categorie;
    protected ArrayList <Joueur> joueurs = new ArrayList <Joueur> (128);
    protected ArrayList <Match> matchs = new ArrayList <Match> (127);       // Un tournoi à 128 joueurs se fait en 127 matchs

    /* Constructors */
    
    /**
     * @since 17/11/2019
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
     * @since 18/11/2019
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
     * @return Ville
     */
    public Ville getVille() {
        return this.ville;
    }

    /**
     * @return Surface
     */
    public Surface getSurface() {
        return this.surface;
    }

    /**
     * @return Categorie
     */
    public Categorie getCategorie() {
        return this.categorie;
    }

    /**
     * @return ArrayList 
     */
    public ArrayList <Joueur> getJoueurs() {
        return this.joueurs;
    }

    /**
     * @return ArrayList
     */
    public ArrayList<Match> getMatchs() {
        return this.matchs;
    }
    
    
    /* Methods */
    
    
    /**
     * Cette méthode permet de générer les 127 matchs du tournoi.
     * @since 18/11/2019
     */
    private void genererMatch(){
        int nbArbitres = 10, nbSpectateurs = 100;
        Phase phase;
        
        for(int i=0; i<127; i++){
            Arbitre [] arbitres = new Arbitre [nbArbitres];
            Spectateur [] spectateurs = new Spectateur [nbSpectateurs];
            LinkedList <Billet> billets = new LinkedList <Billet>();
            Random random = new Random();
            int r;
            int prix = 100;
            
            // Génération des billets pour chaque matchs on part du principe qu'il y a 16000 places en tout dans les tribunes (avec 2000 places par tribune)
            for(int j=0; j<16000; j++){
                if(j>14000){billets.add(new Billet(prix, Tribune.N, j%2000));}
                else if(j>12000){billets.add(new Billet(prix, Tribune.NE, j%2000));}
                else if(j>10000){billets.add(new Billet(prix, Tribune.E, j%2000));}
                else if(j>8000){billets.add(new Billet(prix, Tribune.SE, j%2000));}
                else if(j>6000){billets.add(new Billet(prix, Tribune.S, j%2000));}
                else if(j>4000){billets.add(new Billet(prix, Tribune.SO, j%2000));}
                else if(j>2000){billets.add(new Billet(prix, Tribune.O, j%2000));}
                else{billets.add(new Billet(prix, Tribune.NO, j%2000));}
            }
           
            // Génération des spectateurs
            for(int j=0; j<nbSpectateurs; j++){
                r = random.nextInt(billets.size());
                spectateurs[j] = Spectateur.generer();
                spectateurs[j].acheterBillet(billets.get(r));
                billets.remove(r);
            }
            
            // Génération des arbitres
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
     * Cette méthode permet de remplir la liste des joueurs du tournoi.
     * @since 18/11/2019
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
     * Cette méthode permet de jouer automatiquement tout les matchs du tournoi.
     * @return Joueur
     * @since 21/11/2019
     * @param muteMatch
     * @param muteSet
     * @param muteJeu
     * @param muteEchange 
     */
    public Joueur play(boolean muteMatch, boolean muteSet, boolean muteJeu, boolean muteEchange){
        ArrayList <Joueur> vainqueursPremierTour = new ArrayList <Joueur> (64);
        ArrayList <Joueur> vainqueursDeuxiemeTour = new ArrayList <Joueur> (32);
        ArrayList <Joueur> vainqueursTroisiemeTour = new ArrayList <Joueur> (16);
        ArrayList <Joueur> vainqueursHuitiemeFinale = new ArrayList <Joueur> (8);
        ArrayList <Joueur> vainqueursQuartFinale = new ArrayList <Joueur> (4);
        ArrayList <Joueur> vainqueursDemiFinale = new ArrayList <Joueur> (2);
        ArrayList <Joueur> vainqueursFinal = new ArrayList <Joueur> (1);

        
        /*------------------------------------------ PREMIER TOUR ------------------------------------------*/
        
        // On mets les 128 joueurs dans les matchs du PREMIER_TOUR
        for(int i=0; i<127; i+=2){
            Joueur [] equipe1 = {this.joueurs.get(i)};
            Joueur [] equipe2 = {this.joueurs.get(i+1)};
            this.matchs.get(i/2).setEquipe1(equipe1);
            this.matchs.get(i/2).setEquipe2(equipe2);
        }
        
        // On joue les match du premier tour
        for(int i=0; i<64;i++){
            System.out.println("------------------------------------------- MATCH "+i+" PREMIER TOUR -------------------------------------------");
            vainqueursPremierTour.add(this.matchs.get(i).play(muteMatch, muteSet, muteJeu, muteEchange)[0]);
            this.matchs.get(i).arbitres[0].annoncerVainqueurMatch(vainqueursPremierTour.get(i), this.matchs.get(i).getPhase());
        }
        
        
        
        /*------------------------------------------ DEUXIEME TOUR ------------------------------------------*/
        
        // On mets les 64 joueurs dans les matchs du DEUXIEME_TOUR
        for(int i=0; i<64; i+=2){
            Joueur [] equipe1 = {vainqueursPremierTour.get(i)};
            Joueur [] equipe2 = {vainqueursPremierTour.get(i+1)};
            this.matchs.get(i/2 + 64).setEquipe1(equipe1);
            this.matchs.get(i/2 + 64).setEquipe2(equipe2);
        }
        
        // On joue les match du deuxième tour
        for(int i=0; i<32;i++){
            System.out.println("------------------------------------------- MATCH "+i+" DEUXIEME TOUR -------------------------------------------");
            vainqueursDeuxiemeTour.add(this.matchs.get(i+64).play(muteMatch, muteSet, muteJeu, muteEchange)[0]);
            this.matchs.get(i).arbitres[0].annoncerVainqueurMatch(vainqueursDeuxiemeTour.get(i), this.matchs.get(i+64).getPhase());
        }
        
        /*------------------------------------------ TROISIEME TOUR ------------------------------------------*/
        
        // On mets les 32 joueurs dans les matchs du TROISIEME_TOUR
        for(int i=0; i<32; i+=2){
            Joueur [] equipe1 = {vainqueursDeuxiemeTour.get(i)};
            Joueur [] equipe2 = {vainqueursDeuxiemeTour.get(i+1)};
            this.matchs.get(i/2 + 96).setEquipe1(equipe1);
            this.matchs.get(i/2 + 96).setEquipe2(equipe2);
        }
        
        // On joue les match du troisième tour
        for(int i=0; i<16;i++){
            System.out.println("------------------------------------------- MATCH "+i+" TROISIEME TOUR -------------------------------------------");
            vainqueursTroisiemeTour.add(this.matchs.get(i+96).play(muteMatch, muteSet, muteJeu, muteEchange)[0]);
            this.matchs.get(i).arbitres[0].annoncerVainqueurMatch(vainqueursTroisiemeTour.get(i), this.matchs.get(i+96).getPhase());
        }
        
        /*------------------------------------------ HUITIEME FINALE ------------------------------------------*/
        
        // On mets les 16 joueurs dans les matchs de HUITIEME_FINALE
        for(int i=0; i<16; i+=2){
            Joueur [] equipe1 = {vainqueursTroisiemeTour.get(i)};
            Joueur [] equipe2 = {vainqueursTroisiemeTour.get(i+1)};
            this.matchs.get(i/2 + 112).setEquipe1(equipe1);
            this.matchs.get(i/2 + 112).setEquipe2(equipe2);
        }
        
        // On joue les match de huitième de finale
        for(int i=0; i<8;i++){
            System.out.println("------------------------------------------- MATCH "+i+" HUITIEME FINALE -------------------------------------------");
            vainqueursHuitiemeFinale.add(this.matchs.get(i+112).play(muteMatch, muteSet, muteJeu, muteEchange)[0]);
            this.matchs.get(i).arbitres[0].annoncerVainqueurMatch(vainqueursHuitiemeFinale.get(i), this.matchs.get(i+112).getPhase());
        }
        
        
        /*------------------------------------------ QUART FINALE ------------------------------------------*/
        
        // On mets les 8 joueurs dans les matchs de QUART_FINALE
        for(int i=0; i<8; i+=2){
            Joueur [] equipe1 = {vainqueursHuitiemeFinale.get(i)};
            Joueur [] equipe2 = {vainqueursHuitiemeFinale.get(i+1)};
            this.matchs.get(i/2 + 120).setEquipe1(equipe1);
            this.matchs.get(i/2 + 120).setEquipe2(equipe2);
        }
        
        // On joue les match de quart de finale
        for(int i=0; i<4;i++){
            System.out.println("------------------------------------------- MATCH "+i+" QUART FINALE -------------------------------------------");
            vainqueursQuartFinale.add(this.matchs.get(i+120).play(muteMatch, muteSet, muteJeu, muteEchange)[0]);
            this.matchs.get(i).arbitres[0].annoncerVainqueurMatch(vainqueursQuartFinale.get(i), this.matchs.get(i+120).getPhase());
        }
        
        /*------------------------------------------ DEMI FINALE ------------------------------------------*/
        
        // On mets les 4 joueurs dans les matchs de DEMI_FINALE
        for(int i=0; i<4; i+=2){
            Joueur [] equipe1 = {vainqueursQuartFinale.get(i)};
            Joueur [] equipe2 = {vainqueursQuartFinale.get(i+1)};
            this.matchs.get(i/2 + 124).setEquipe1(equipe1);
            this.matchs.get(i/2 + 124).setEquipe2(equipe2);
        }
        
        // On joue les match de demi finale
        for(int i=0; i<2;i++){
            System.out.println("------------------------------------------- MATCH "+i+" DEMI FINALE -------------------------------------------");
            vainqueursDemiFinale.add(this.matchs.get(i+124).play(muteMatch, muteSet, muteJeu, muteEchange)[0]);
            this.matchs.get(i).arbitres[0].annoncerVainqueurMatch(vainqueursDemiFinale.get(i), this.matchs.get(i+124).getPhase());
        }
        
        /*------------------------------------------ FINALE ------------------------------------------*/
        
        // On mets les 2 joueurs dans le match FINALE
        for(int i=0; i<2; i+=2){
            Joueur [] equipe1 = {vainqueursDemiFinale.get(i)};
            Joueur [] equipe2 = {vainqueursDemiFinale.get(i+1)};
            this.matchs.get(i/2 + 126).setEquipe1(equipe1);
            this.matchs.get(i/2 + 126).setEquipe2(equipe2);
        }
        
        // On joue les match de demi finale
        for(int i=0; i<1;i++){
            System.out.println("------------------------------------------- MATCH FINALE -------------------------------------------");
            vainqueursFinal.add(this.matchs.get(i+126).play(muteMatch, muteSet, muteJeu, muteEchange)[0]);
            this.matchs.get(i).arbitres[0].annoncerVainqueurMatch(vainqueursFinal.get(i), this.matchs.get(i+126).getPhase());
        }
        
        return vainqueursFinal.get(0);
    }
}
