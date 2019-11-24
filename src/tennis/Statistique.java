/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.LinkedList;

/**
 * <b>Cette classe répertorie les statistiques de match de chaque joueur.</b>
 * @see StatMatch
 * @see Joueur
 * @author Nicolas
 * @since 21/11/2019
 */
public class Statistique{
    /* Statistiques personnelles */
    private int matchJoues;
    private int matchRemporte;
    private int nbTournoi;        // Nombre de participation aux tournois
    private int gains;
    
    private double probaServiceCorrect;
    private double probaRenvoieCorrect;
    private double probaRenvoieFaute;  // probaRenvoieCorrect < probaRenvoieFaute d'où le else if
    
    /* Statistiques personnelles pour chaques matchs */
    private LinkedList <StatMatch> statMatch;
    
    /* Constructor */

    public Statistique() {
        this.matchJoues = 0;
        this.matchRemporte = 0;
        this.nbTournoi = 0;
        this.gains = 0;
    }
    
    /* Getters */

    /**
     * @return int
     */
    public int getMatchJoues() {
        return this.matchJoues;
    }

    /**
     * @return int
     */
    public int getMatchRemporte() {
        return this.matchRemporte;
    }

    /**
     * @return int
     */
    public int getNbTournoi() {
        return this.nbTournoi;
    }

    /**
     * @return int
     */
    public int getGains() {
        return this.gains;
    }

    /**
     * @return int
     */
    public LinkedList<StatMatch> getStatMatch() {
        return this.statMatch;
    }

    /**
     * @return 
     */
    public double getProbaServiceCorrect() {
        return this.probaServiceCorrect;
    }

    /**
     * @return double
     */
    public double getProbaRenvoieCorrect() {
        return this.probaRenvoieCorrect;
    }

    /**
     * @return double
     */
    public double getProbaRenvoieFaute() {
        return this.probaRenvoieFaute;
    }
    
    /* Setters */

    /**
     * @param probaServiceCorrect 
     */
    public void setProbaServiceCorrect(double probaServiceCorrect) {
        this.probaServiceCorrect = probaServiceCorrect;
    }

    /**
     * @param probaRenvoieCorrect 
     */
    public void setProbaRenvoieCorrect(double probaRenvoieCorrect) {
        this.probaRenvoieCorrect = probaRenvoieCorrect;
    }

    /**
     * @param probaRenvoieFaute 
     */
    public void setProbaRenvoieFaute(double probaRenvoieFaute) {
        this.probaRenvoieFaute = probaRenvoieFaute;
    }
    
    
    /* Methods */

    /**
     * @see addStatMacth
     */
    public void addMatchJoues() {
        this.matchJoues++;
        addStatMatch();
    }

    public void addMatchRemporte() {
        this.matchRemporte++;
    }

    public void addNbTournoi() {
        this.nbTournoi++;
    }

    public void addGains(int gains) {
        this.gains += gains;
    }

    /**
     * @see addStatMatch
     * @see StatMach
     */
    private void addStatMatch() {
        this.statMatch.add(new StatMatch());
    }
}
