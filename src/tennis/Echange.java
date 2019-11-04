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
public class Echange {
    protected Arbitre [] arbitres;
    protected Joueur[] equipe1;
    protected Joueur[] equipe2;
    protected Spectateur[] spectateurs;
    
    /* Constructor */
    
    /**
     * 03/11/2019
     * @param arbitres
     * @param equipe1
     * @param equipe2
     * @param spectateurs 
     */
    public Echange(Arbitre[] arbitres, Joueur[] equipe1, Joueur[] equipe2, Spectateur[] spectateurs) {
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
    }
    
    /* Method */
    
    /**
     * 03/11/2019
     * @return Joueur []
     * Cette méthode renvoie l'équipe qui remportera l'échange
     */
    public Joueur [] play(){
        Joueur [] winners = {}; // Equipe qui remportera l'échange
        int score1 = 0, score2 = 0; // Scores (echange) de chaques équipes
        
        // Simulation
        double random = Math.random();
        if(random < 0.5){winners = this.equipe1;}
        else{winners = this.equipe2;}
        
        return winners;
    }
}






