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
public class Jeu {
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
    public Jeu(Arbitre[] arbitres, Joueur[] equipe1, Joueur[] equipe2, Spectateur[] spectateurs) {
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
    }
    
    /* Method */
    
    /**
     * 03/11/2019
     * @return Joueur []
     * Cette méthode renvoie l'équipe qui remporte le jeu
     */
    public Joueur[] play(){
        Joueur [] vainqueurJeu = {}; // Equipe qui remportera le jeu
        Joueur [] vainqueurEchange = {}; // Equipe qui remportera l'échange
        int score1 = 0, score2 = 0; // Scores (echange) de chaques équipes
        
        while(score1 < 4 && score2 < 4){
            Echange echange = new Echange(this.arbitres, this.equipe1, this.equipe2, this.spectateurs);
            
            vainqueurEchange = echange.play();
            if(vainqueurEchange == this.equipe1){score1++;}
            else if(vainqueurEchange == this.equipe2){score2++;}
            
            this.arbitres[0].annoncerScoreJeu(score1, score2);
        }
        
        // Dans le cas où le score est de 40-AV (resp AV-40), tant qu'il n'y a pas d'écart de 2 points
        while(Math.abs(score1 - score2) < 2){
            Echange echange = new Echange(this.arbitres, this.equipe1, this.equipe2, this.spectateurs);
            
            vainqueurEchange = echange.play();
            if(vainqueurEchange == this.equipe1){score1++;}
            else if(vainqueurEchange == this.equipe2){score2++;}
            
            this.arbitres[0].annoncerScoreJeu(score1, score2);
        }
        
        if(score1 < score2){vainqueurJeu = this.equipe2;}
        else if(score1 > score2){vainqueurJeu = this.equipe1;}
        
        return vainqueurJeu;
    }
}
