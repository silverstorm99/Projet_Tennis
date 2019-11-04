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
    protected int service;
    
    /* Constructor */
    
    /**
     * 03/11/2019
     * @param arbitres
     * @param equipe1
     * @param equipe2
     * @param spectateurs 
     */
    public Echange(Arbitre[] arbitres, Joueur[] equipe1, Joueur[] equipe2, Spectateur[] spectateurs, int Service) {
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
        this.service = Service;
    }
    
    /* Method */
    
    /**
     * 03/11/2019
     * @return Joueur []
     * Cette méthode renvoie l'équipe qui remportera l'échange
     */
    public Joueur [] play(){
        Joueur [][] equipe = {this.equipe1, this.equipe2};
        Joueur [] vainqueurEchange = {}; // Equipe qui remportera l'échange
        
        Integer[] score = {0,0}; // Scores (echange) de chaques équipes
        boolean echangeFini = false;
        // Simulation
        while(!echangeFini){
            echangeFini = Joueur.play(equipe[this.service %2],this.arbitres,score[this.service %2]);
            echangeFini = !echangeFini ? Joueur.play(equipe[this.service +1 %2],this.arbitres,score[this.service %2]) : echangeFini;
        }
        
        if(score[0] < score[1]){vainqueurEchange = this.equipe2;}
        else {vainqueurEchange = this.equipe1;}

        return vainqueurEchange;
    }
}










