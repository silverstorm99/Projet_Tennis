/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * 13/10/2019
 * @author Nicolas
 */
public class Date {
    private int jour;
    private int mois;
    private int annee;
    
    /**
     * 13/10/2019
     * @param jour
     * @param mois
     * @param annee 
     */
    public Date(int jour, int mois, int annee){
        if(jour < 1 || jour > 31){throw new IllegalArgumentException("Le jour n'est pas conforme.");}
        if(mois < 1 || mois > 12){throw new IllegalArgumentException("Le mois n'est pas conforme.");}
        if(annee < 1){throw new IllegalArgumentException("L'année n'est pas conforme.");}
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    
    /**
     * 13/10/2019
     * @return int
     */
    public int getJour() {
        return this.jour;
    }

    /**
     * 13/10/2019
     * @return int
     */
    public int getMois() {
        return this.mois;
    }

    /**
     * 13/10/2019
     * @return int
     */
    public int getAnnee() {
        return this.annee;
    }
}













