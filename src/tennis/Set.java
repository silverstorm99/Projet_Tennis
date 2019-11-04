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
public class Set {
    protected Arbitre [] arbitres;
    protected Joueur[] equipe1;
    protected Joueur[] equipe2;
    protected Spectateur[] spectateurs;
    
    
    /* Constructor */
    
    /**
     * 02/11/2019
     * @param arbitres
     * @param equipe1
     * @param equipe2
     * @param spectateurs 
     */
    public Set(Arbitre [] arbitres, Joueur [] equipe1, Joueur [] equipe2, Spectateur [] spectateurs){
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
    }
    
    /* Method */
    
    /**
     * 03/11/2019
     * @return Joueur []
     * Cette méthode renvoie l'équipe qui remporte le set
     */
    public Joueur[] play(){
        Joueur [] vainqueurSet = {}; // Equipe qui remportera le set
        Joueur [] vainqueurJeu = {}; // Equipe qui remportera le jeu
        int score1 = 0, score2 = 0; // Scores (jeux) de chaques équipes
        
        int service = Math.random() < 0.5 ? 0 : 1; // Determine aleatoirement qui sert le premier
        
        // Prends aussi le cas où le score est de 6-5 (resp 5-6), tant qu'il n'y a pas d'écart de 2 points
        while((score1 < 6 && score2 < 6) || Math.abs(score1 - score2) < 2){
            Jeu jeu = new Jeu(this.arbitres, this.equipe1, this.equipe2, this.spectateurs,service++ %2); //service 0 veut dire service par l'equipe 1
            
            vainqueurJeu = jeu.play();
            if(vainqueurJeu == this.equipe1){score1++;}
            else if(vainqueurJeu == this.equipe2){score2++;}
            
            this.arbitres[0].annoncerScoreSet(vainqueurJeu, score1, score2);
        }
        
        
        if(score1 < score2){vainqueurSet = this.equipe2;}
        else if(score1 > score2){vainqueurSet = this.equipe1;}
        
        return vainqueurSet;
    }
}
















