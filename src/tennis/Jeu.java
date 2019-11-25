/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette classe permet de créer un jeu entre deux équipes/joueurs.</b>
 * @since 25/10/2019
 * @author Nicolas, Clément
 * @see Echange
 * @see Set
 * @see Joueur
 * @see Arbitre
 * @see Spectateur
 */
public class Jeu {
    protected Arbitre [] arbitres;
    protected Joueur[] equipe1;
    protected Joueur[] equipe2;
    protected Spectateur[] spectateurs;
    protected int service;
    
    /* Constructor */
    
    /**
     * 03/11/2019
     * @param arbitres
     * @param equipe1
     * @param equipe2
     * @param spectateurs 
     */
    public Jeu(Arbitre[] arbitres, Joueur[] equipe1, Joueur[] equipe2, Spectateur[] spectateurs,int service) {
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
        this.service = service;
    }
    
    /* Method */
    
    /**
     * Cette méthode renvoie l'équipe qui remporte le jeu.
     * @since 20/11/2019
     * @param muteJeu
     * @param muteEchange
     * @return Joueur []
     */
    public Joueur[] play(boolean muteJeu, boolean muteEchange){
        Joueur [] vainqueurJeu = {}; // Equipe qui remportera le jeu
        Joueur [] vainqueurEchange = {}; // Equipe qui remportera l'échange
        int score1 = 0, score2 = 0; // Scores (echange) de chaques équipes
        
        // Dans le cas où le score est de 40-AV (resp AV-40), tant qu'il n'y a pas d'écart de 2 points
        while((score1 < 4 && score2 < 4) || Math.abs(score1 - score2) < 2){
            Echange echange = new Echange(this.arbitres, this.equipe1, this.equipe2, this.spectateurs, this.service);
            
            vainqueurEchange = echange.play(muteEchange);
            if(vainqueurEchange == this.equipe1){score1++;}
            else if(vainqueurEchange == this.equipe2){score2++;}
            
            // Permet d'afficher ou non les résultats de chaque jeu
            if(!muteJeu){
                this.arbitres[0].annoncerScoreJeu(score1, score2);
            }
        }
        
        if(score1 < score2){vainqueurJeu = this.equipe2;}
        else if(score1 > score2){vainqueurJeu = this.equipe1;}
        
        return vainqueurJeu;
    }
}
