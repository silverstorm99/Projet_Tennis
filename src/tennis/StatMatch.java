/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette classe répertorie les statistiques pour chaque match de chaque joueur.</b>
 * @see Statistique
 * @author Nicolas
 * @since 23/11/2019
 */
public class StatMatch {
    private int nbSet;
    private int nbJeu;
    private int nbEchange;
    private int nbPoint;
    private int nbAce;
    private int nbPremierService;
    private int nbSecondService;
    private int nbDoubleFaute;
    private int nbBalleBreak;
    private int nbBalleBreakRemporte;
    private float vitesseBallePremierService;
    private float vitesseBalleSecondService;
    
    /* Constructor */
    
    public StatMatch() {
        this.nbSet = 0;
        this.nbJeu = 0;
        this.nbEchange = 0;
        this.nbPoint = 0;
        this.nbAce = 0;
        this.nbPremierService = 0;
        this.nbSecondService = 0;
        this.nbDoubleFaute = 0;
        this.nbBalleBreak = 0;
        this.nbBalleBreakRemporte = 0;
        this.vitesseBallePremierService = 0;    // Vitesse moyenne des balles aux premiers services
        this.vitesseBalleSecondService = 0;     // Vitesse moyenne des balles aux seconds services
    }

    /* Getters */
    
    /**
     * @return int
     */
    public int getNbSet() {
        return this.nbSet;
    }

    /**
     * @return int
     */
    public int getNbJeu() {
        return this.nbJeu;
    }

    /**
     * @return int
     */
    public int getNbEchange() {
        return this.nbEchange;
    }

    /**
     * @return int
     */
    public int getNbPoint() {
        return this.nbPoint;
    }

    /**
     * @return int
     */
    public int getNbAce() {
        return this.nbAce;
    }

    /**
     * @return int
     */
    public int getNbPremierService() {
        return this.nbPremierService;
    }

    /**
     * @return int
     */
    public int getNbSecondService() {
        return this.nbSecondService;
    }

    /**
     * @return int
     */
    public int getNbDoubleFaute() {
        return this.nbDoubleFaute;
    }

    /**
     * @return int
     */
    public int getNbBalleBreak() {
        return this.nbBalleBreak;
    }

    /**
     * @return int
     */
    public int getNbBalleBreakRemporte() {
        return this.nbBalleBreakRemporte;
    }

    /**
     * @return float
     */
    public float getVitesseBallePremierService() {
        return this.vitesseBallePremierService;
    }

    /**
     * @return float
     */
    public float getVitesseBalleSecondService() {
        return this.vitesseBalleSecondService;
    }
    
    /* Methods */

    public void addNbSet() {
        this.nbSet++;
    }

    public void addNbJeu() {
        this.nbJeu++;
    }

    public void addNbEchange() {
        this.nbEchange++;
    }

    public void addNbPoint() {
        this.nbPoint++;
    }

    public void addNbAce() {
        this.nbAce++;
    }

    /**
     * @param vitesseBallePremierService 
     * @see updateVitesseBallePremierService
     */
    public void addNbPremierService(float vitesseBallePremierService) {
        this.nbPremierService++;
        updateVitesseBallePremierService(vitesseBallePremierService);
    }

    /**
     * @param vitesseBalleSecondService 
     * @see updateVitesseBalleSecondService
     */
    public void addNbSecondService(float vitesseBalleSecondService) {
        this.nbSecondService++;
        updateVitesseBallePremierService(vitesseBallePremierService);
    }

    public void addNbDoubleFaute() {
        this.nbDoubleFaute++;
    }

    public void addNbBalleBreak() {
        this.nbBalleBreak++;
    }

    public void addNbBalleBreakRemporte() {
        this.nbBalleBreakRemporte++;
    }

    /**
     * Cette méthode remet à jour la vitesse moyenne des balles aux premiers services
     * @param vitesseBallePremierService 
     * @see addNbPremierService
     */
    private void updateVitesseBallePremierService(float vitesseBallePremierService) {
        this.vitesseBallePremierService = (this.vitesseBallePremierService + vitesseBallePremierService) / this.nbPremierService;
    }
    
    /**
     * Cette méthode remet à jour la vitesse moyenne des balles aux seconds services
     * @param vitesseBalleSecondService 
     * @see addNbSecondService
     */
    private void updateVitesseBalleSecondService(float vitesseBalleSecondService) {
        this.vitesseBalleSecondService = (this.vitesseBalleSecondService+vitesseBalleSecondService) / this.nbSecondService;
    }   
}
