/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * <b>Cette classe qui hérite de la classe Personne permet de créer un objet arbitre.</b>
 * @since 21/10/2019
 * @author Nicolas
 * @see Personne
 */
public class Arbitre extends Personne{
    
    public static int nbArbitre = 0; // Compte le nombre d' arbitre
    
    /* Constructor */
    
    /**
     * @param nomNaissance
     * @param nomCourant
     * @param prenom
     * @param surnom
     * @param dateNaissance
     * @param lieuNaissance
     * @param dateDeces
     * @param nationalite
     * @param taille
     * @param poids 
     */
    public Arbitre(String nomNaissance, String nomCourant, String prenom, String surnom, Date dateNaissance, String lieuNaissance, Date dateDeces, String nationalite, int taille, int poids){
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids);
        nbArbitre++;
    }

    
    /* Methods */

    protected static Scanner scanner = new Scanner(System.in);

    /**
     * Cette méthode permet de créer un Arbitre manuellement.
     * @return Arbitre
     */
    public static Arbitre createInterface(){
        Arbitre myArbitre =  null;
        try {
            System.out.print("\nNom de Naissance : ");
            String nomNaissance = scanner.next();
            System.out.print("\nNom Courant : ");
            String nomCourant = scanner.next();
            System.out.print("\nPrenom : ");
            String prenom = scanner.next();
            System.out.print("\nSurnom : ");
            String surnom = scanner.next();
            System.out.print("\nLieu de Naissance : ");
            String lieuNaissance = scanner.next();
            System.out.print("\nNationnalité : ");
            String nationalite = scanner.next();
            
            System.out.print("\nTaille : ");
            int taille = scanner.nextInt();
            System.out.print("\nPoids : ");
            int poids = scanner.nextInt();
            
            Date dateNaissance = Date.createInterface("naissance");
            Random random = new Random();
            int esperanceVie = (int)(7*random.nextGaussian() + 79);

            Date dateDeces = Date.genererAleatoire(dateNaissance.getAnnee() + esperanceVie);

            myArbitre = new Arbitre(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids);

            
        } 
        catch(InputMismatchException e){
            myArbitre = generer();
            System.out.println("Vous avez rentré un mauvais parametre pour votre arbitre : You're a bad person !\nUn arbitre aléatoire a été crée à la place\n");
        }
        catch (Exception e) {
            myArbitre = generer();
            System.out.println("Vous avez rentré un mauvais parametre pour votre arbitre : You're a bad person !\nUn arbitre aléatoire a été crée à la place\n");
        }

        System.out.println("Arbitre crée\n");

        return myArbitre;
    }



    
    /**
     * Cette méthode annonce le score du match en indiquant le score (en set) de chaque équipe.
     * @since 03/11/2019
     * @param vainqueurSet
     * @param score1
     * @param score2 
     */
    public void annoncerScoreMatch(Joueur [] vainqueurSet, int score1, int score2){
        if(vainqueurSet.length == 1){
            System.out.println(vainqueurSet[0].getNomCourant() + " " + vainqueurSet[0].getPrenom() +" remporte le set.");
        }
        else if(vainqueurSet.length == 2){
            System.out.println(vainqueurSet[0].getNomCourant() + " " + vainqueurSet[0].getPrenom()+" et " + vainqueurSet[1].getNomCourant() + " " + vainqueurSet[1].getPrenom() +" remportent le set. ");
        }
        System.out.println("Score du match : " + String.valueOf(score1) + " - " + String.valueOf(score2)+ "\n\n");
    }
    
    /**
     * Cette méthode annonce le score du set en indiquant le score (en jeu) de chaque équipe.
     * @since 03/11/2019
     * @param vainqueurJeu
     * @param score1
     * @param score2 
     */
    public void annoncerScoreSet(Joueur [] vainqueurJeu, int score1, int score2){
        if(vainqueurJeu.length == 1){
            System.out.println(vainqueurJeu[0].getNomCourant() + " " + vainqueurJeu[0].getPrenom() +" remporte le jeu.");
        }
        else if(vainqueurJeu.length == 2){
            System.out.println(vainqueurJeu[0].getNomCourant() + " " + vainqueurJeu[0].getPrenom()+" et " + vainqueurJeu[1].getNomCourant() + " " + vainqueurJeu[1].getPrenom() +" remportent le jeu. ");
        }
        System.out.println("Score du set : " + String.valueOf(score1) + " - " + String.valueOf(score2) + "\n");
    }
    
    /**
     * Cette méthode annonce le score du jeu en indiquant le score (en échange remporté) de chaque équipe.
     * @since 03/11/2019
     * @param score1, score du joueur qui sert
     * @param score2
     */
    public void annoncerScoreJeu(int score1, int score2){
        /* Adaptation de l'affichage des scores:
        0 <=> 0
        1 <=> 15
        2 <=> 30
        3 <=> 40
        4 et + <=> Game ou AV
        */
        String scoreA = "0", scoreB = "0";
        
        if(score1 == 1){scoreA = "15";}
        else if(score1 == 2){scoreA = "30";}
        else if(score1 == 3){scoreA = "40";}
        
        if(score2 == 1){scoreB = "15";}
        else if(score2 == 2){scoreB = "30";}
        else if(score2 == 3){scoreB = "40";}
        
        if(score1 >= 4 && score2 <= score1 - 2){scoreA = "Game";}
        else if(score2 >= 4 && score1 <= score2 - 2){scoreB = "Game";}
        else if(score1 == score2 && score1 >= 3 && score2 >= 3){scoreA = "40"; scoreB ="40";}
        else if(score1 > 3 && score2 < score1){scoreA = "AV"; scoreB = "40";}
        else if(score2 > 3 && score1 < score2){scoreB = "AV"; scoreA = "40";}
        
        System.out.println("Echange : " + scoreA + "-" + scoreB + "\n");
    }
    
    /**
     * @since 21/11/2019
     * @param vainqueurMatch
     * @param phase 
     */
    public void annoncerVainqueurMatch(Joueur vainqueurMatch, Phase phase){
        String finPhrase;
        switch(phase){
            case AMICALE:
                finPhrase = "le match amical";
                break;
            case FINALE:
                finPhrase = "la finale";
                break;
            case DEMI_FINALE:
                finPhrase = "la demi finale";
                break;
            case QUART_FINALE:
                finPhrase = "le quart de finale";
                break;
            case HUITIEME_FINALE:
                finPhrase = "la huitième de finale";
                break;
            case TROISIEME_TOUR:
                finPhrase = "le troisième tour";
                break;
            case DEUXIEME_TOUR:
                finPhrase = "le deuxième tour";
                break;
            case PREMIER_TOUR:
                finPhrase = "le premier tour";
                break;
            default:
                finPhrase = "le match.";
                break;
        }
        System.out.println(vainqueurMatch.getNomCourant() + " " + vainqueurMatch.getPrenom() + " remporte " + finPhrase +".");
    }
    
    /**
     * Cette méthode permet de générer un objet de type Arbitre de manière aléatoire.
     * <h3>Exemple: </h3>
     * <p>
     * anneeNaissance: espérance = 1978 et écart_type = 15 donnera 
     * int anneeNaissance = (int)(15*random.nextGaussian() + 1991);
     * </p>
     * @since 17/11/2019
     * @return Arbitre
     * @see Random
     * @see Joueur
     * @see Spectateur
     */
    public static Arbitre generer(){
        Random random = new Random();
        
        /* Génération des attributs considérés communs */
        int anneeNaissance = (int)(15*random.nextGaussian() + 1991);
        String nomNaissance = Personne.nomFamille.get(random.nextInt(Personne.nomFamille.size()));
        String nomCourant = nomNaissance;   // Par défaut le nomCourant sera le nomNaissance
        String lieuNaissance = Personne.villeNaissance.get(random.nextInt(Personne.villeNaissance.size()));
        String nationalite = Personne.pays.get(random.nextInt(Personne.pays.size()));
        Date dateNaissance = Date.genererAleatoire(anneeNaissance);
        
        /* Attributs particuliers selon le sexe qui ici sera insinué */
        boolean sexe = random.nextBoolean();  // Determine le sexe de l'arbitre (contrairement à un joeur ou à un spectateur, la distinction de ne fera pas par un vetement)
        
        int esperanceVie = (sexe) ? (int)(7*random.nextGaussian() + 79) : (int)(7*random.nextGaussian() + 85);
        int taille = (sexe) ? (int)(6*random.nextGaussian() + 178) : (int)(6*random.nextGaussian() + 165);
        int poids = (sexe) ? (int)(6*random.nextGaussian() + 75) : (int)(6*random.nextGaussian() + 70);
        String prenom = (sexe) ? Personne.prenomMasculin.get(random.nextInt(Personne.prenomMasculin.size())) : Personne.prenomFeminin.get(random.nextInt(Personne.prenomFeminin.size()));
        String surnom = prenom;
        
        Date dateDeces = Date.genererAleatoire(anneeNaissance + esperanceVie);
        nomCourant = (sexe) ? nomNaissance : Personne.nomFamille.get(random.nextInt(Personne.nomFamille.size()));
        
        return new Arbitre(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids);
    }
}
