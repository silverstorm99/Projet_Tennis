/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * 21/10/2019
 * @author Nicolas
 */
public class Billet {
    protected int prix;
    protected Tribune tribune;
    protected int place;
    
    public static int nbBillet = 0; // Compte le nombre de billet vendu
    
    public Billet(int prix, Tribune tribune, int place){
        this.prix = prix;
        this.tribune = tribune;
        this.place = place;
        
        nbBillet++;
    }
    
    /* Getters */

    /**
     * 21/10/2019
     * @return int
     */
    public int getPrix() {
        return this.prix;
    }

    /**
     * 21/10/2019
     * @return Tribune
     */
    public Tribune getTribune() {
        return this.tribune;
    }

    /**
     * 21/10/2019
     * @return int
     */
    public int getPlace() {
        return this.place;
    }
    
    
}




