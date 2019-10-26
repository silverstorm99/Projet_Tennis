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
        int[] tab = {31,28,31,30,31,30,31,31,30,31,30,31}; //Derniers jours de chaque mois
        if (annee%400 == 0 || (annee%4 == 0 && annee%100 != 0)){tab[1] = 29;} // On vérifie si l'année est bissextile
        
        //  Vérification de la cohérence entre jour, mois et année
        if(annee < 1){throw new IllegalArgumentException("L'année n'est pas conforme.");}
        if(mois < 1 || mois > 12){throw new IllegalArgumentException("Le mois n'est pas conforme.");}
        if(jour < 1 || jour > tab[mois - 1]){throw new IllegalArgumentException("Le jour n'est pas conforme.");}
        
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    
    /* Getters */
    
    
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

    
    /* Method */
    
    /**
     * 25/10/2019
     * @return String
     */
    @Override
    public String toString(){
        String str_jour = "";
        String str_mois = "";
        if(this.mois < 10){str_mois = "0";}
        if(this.jour < 10){str_jour = "0";}
        return str_jour + this.jour + "/" + str_mois + this.mois + "/" + this.annee;
    }
}

















