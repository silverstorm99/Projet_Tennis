/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette classe permet de créer un objet Billet qui sera aacheté par un Spectateur pour aller voir un match.</b>
 * @since 21/10/2019
 * @author Nicolas
 * @see Spectateur
 * @see Tribune
 */
public class Billet {
    protected int prix;
    protected Tribune tribune;
    protected int place;
    
    public static int nbBillet = 0; // Compte le nombre de billet vendu
    
    /* Constructor */
    
    /**
     * @param prix
     * @param tribune
     * @param place 
     */
    public Billet(int prix, Tribune tribune, int place){
        this.prix = prix;
        this.tribune = tribune;
        this.place = place;
        
        nbBillet++;
    }
    
    /* Getters */

    /**
     * @return int
     */
    public int getPrix() {
        return this.prix;
    }

    /**
     * @return Tribune
     */
    public Tribune getTribune() {
        return this.tribune;
    }

    /**
     * @return int
     */
    public int getPlace() {
        return this.place;
    }
    
    /* Method */
    
    /**
     * Cette méthode décrit le billet avec ses variables d'instances.
     * @since 24/11/2019
     * @return String
     */
    @Override
    public String toString(){
        return String.valueOf(this.place) +" "+ String.valueOf(this.tribune) +" "+ String.valueOf(this.prix) + " €";
    }
}
