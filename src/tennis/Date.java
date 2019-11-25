/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.Random;
import java.util.Scanner;

/**
 * <b>Cette classe permet de créer un objet de type date comprenant : </b>
 * <ul><li>jour</li>
 * <li>mois</li>
 * <li>annee</li></ul>
 * @since 13/10/2019
 * @author Nicolas, Clément
 * @see Personne
 */
public class Date {
    private int jour;
    private int mois;
    private int annee;
    
    /* Constructor */
    
    /**
     * @since 13/10/2019
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
     * @return int
     */
    public int getJour() {
        return this.jour;
    }

    /**
     * @return int
     */
    public int getMois() {
        return this.mois;
    }

    /**
     * @return int
     */
    public int getAnnee() {
        return this.annee;
    }

    
    /* Methods */
    
    /**
     * Cette méthode permet d'écrire la date sous la forme jj/mm/aa .
     * @since 25/10/2019
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
    
    /**
     * Cette méthode permet de générer une date de manière aléatoire.
     * @since 14/11/2019 
     * @param annee
     * @return Date
     */
    public static Date genererAleatoire(int annee){
        int[] tab = {31,28,31,30,31,30,31,31,30,31,30,31}; //Derniers jours de chaque mois
        Random random = new Random();
        
        int mois = random.nextInt(12) + 1;
        int jour = random.nextInt(tab[mois-1]) + 1;
        
        return new Date(jour, mois, annee);
    }

    protected static Scanner scanner = new Scanner(System.in);

    /**
     * 
     * @param dateof
     * @return Date
     */
    public static Date createInterface(String dateof){
        Date d = null;
        try {
            System.out.printf("\nJour de %s : ",dateof);
            int jour = scanner.nextInt();
            System.out.printf("\nMois de %s : ",dateof);
            int mois = scanner.nextInt();
            System.out.printf("\nAnnée de %s : ",dateof);
        	int annee = scanner.nextInt();
            d = new Date(jour, mois, annee);
			
		} catch (Exception e) {
            Random random = new Random();
            d = genererAleatoire((int)(7*random.nextGaussian() + 1991));
            System.out.println("Vous avez mal rentré la date, une date aléatoire a été crée ...");
        }
		
        return d;
    }
}
