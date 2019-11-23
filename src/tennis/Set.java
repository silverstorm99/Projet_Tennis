/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette classe permet de créer un set entre deux équipes/joueurs.</b>
 * @since 25/10/2019
 * @author Nicolas
 * @see Match
 * @see Jeu
 * @see Arbitre
 * @see Joueur
 * @see Spectateur
 */
public class Set {
    protected Arbitre [] arbitres;
    protected Joueur[] equipe1;
    protected Joueur[] equipe2;
    protected Spectateur[] spectateurs;
    protected int service;    
    
    /* Constructor */
    
    /**
     * 02/11/2019
     * @param arbitres
     * @param equipe1
     * @param equipe2
     * @param spectateurs 
     */
    public Set(Arbitre [] arbitres, Joueur [] equipe1, Joueur [] equipe2, Spectateur [] spectateurs, int service){
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
        this.service = service;
    }
    
    /* Method */
    
    /**
     * Cette méthode renvoie l'équipe qui remporte le set.
     * @since 20/11/2019
     * @param muteSet
     * @param muteJeu
     * @param muteEchange
     * @return Joueur []
     */
    public Joueur[] play(boolean muteSet, boolean muteJeu, boolean muteEchange){
        Joueur [] vainqueurSet = {}; // Equipe qui remportera le set
        Joueur [] vainqueurJeu = {}; // Equipe qui remportera le jeu
        int score1 = 0, score2 = 0; // Scores (jeux) de chaques équipes
        
        // Prends aussi le cas où le score est de 6-5 (resp 5-6), tant qu'il n'y a pas d'écart de 2 points
        while((score1 < 6 && score2 < 6) || Math.abs(score1 - score2) < 2){
            Jeu jeu = new Jeu(this.arbitres, this.equipe1, this.equipe2, this.spectateurs,(this.service++) %2); //service 0 veut dire service par l'equipe 1
            
            vainqueurJeu = jeu.play(muteJeu, muteEchange);
            if(vainqueurJeu == this.equipe1){score1++;}
            else if(vainqueurJeu == this.equipe2){score2++;}
            
            // Permet d'afficher ou non les résultats de chaque set
            if(!muteSet){
                this.arbitres[0].annoncerScoreSet(vainqueurJeu, score1, score2);
            }
        }
        
        if(score1 < score2){vainqueurSet = this.equipe2;}
        else if(score1 > score2){vainqueurSet = this.equipe1;}
        
        return vainqueurSet;
    }
}
