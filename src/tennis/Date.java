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
        if(annee < 1){throw new IllegalArgumentException("L'année n'est pas conforme.");}
        if(mois < 1 || mois > 12){throw new IllegalArgumentException("Le mois n'est pas conforme.");}
        if(jour < 1 || jour > 31){throw new IllegalArgumentException("Le jour n'est pas conforme.");}
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

    /**
     * 13/10/2019
     * @param jour 
     */
    public void setJour(int jour) {
        this.jour = jour;
    }

    /**
     * 13/10/2019
     * @param mois 
     */
    public void setMois(int mois) {
        this.mois = mois;
    }

    /**
     * 13/10/2019
     * @param annee 
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    @Override
    public String toString(){
        String str = "";
        if(this.mois < 10){str = "0";}
        return this.jour + "/" + str + this.mois + "/" + this.annee;
    }
}





