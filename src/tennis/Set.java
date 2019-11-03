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
    
    
    /* Constructors */
    
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
    
    /* Methods */
    
    /**
     * 02/11/2019
     * @return Joueur []
     * Cette méthode renvoie l'équipe qui remporte le set
     */
    public Joueur[] play(){
        Joueur [] winners = {}; // Equipe qui remportera le set
        int score1 = 0, score2 = 0; // Scores (jeux) de chaques équipes
        
        while(score1 < 6 && score2 < 6){
            
        }
        
        if(score1 < score2){winners = this.equipe2;}
        else if(score1 > score2){winners = this.equipe1;}
        
        return winners;
    }
}















