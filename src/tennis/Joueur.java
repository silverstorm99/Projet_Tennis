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
 * <b>Cette classe permet de créer un objet de type Joueur.</b>
 * @since 13/10/2019
 * @author Nicolas, Clément
 * @see Personne
 * @see Main
 * @see Vetement
 * @see Statistique
 * @see Action
 * @see ActionSpectateur
 */
public class Joueur extends Personne implements ActionSpectateur{
    protected Main main;
    protected String sponsor;
    protected int classement;
    protected String entraineur;
    protected Vetement vetement;
    protected Couleur couleur;
    
    protected Statistique statistique = new Statistique();
    
    public static int nbJoueur = 0; // Compte le nombre de joueur
    
    /*Constructor */
    
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
     * @param main
     * @param sponsor
     * @param entraineur
     * @param vetement
     * @param couleur
     * @param probaServiceCorrect
     * @param probaRenvoieCorrect
     * @param probaRenvoieFaute    // Condition : probaRenvoieCorrect < probaRenvoieFaute < 1
     */
    public Joueur (String nomNaissance, String nomCourant, String prenom,String surnom, Date dateNaissance, String lieuNaissance,Date dateDeces, String nationalite, int taille, int poids,Main main, String sponsor, String entraineur, Vetement vetement, Couleur couleur, double probaServiceCorrect, double probaRenvoieCorrect, double probaRenvoieFaute){
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids);
        this.main = main;
        this.sponsor = sponsor;
        this.classement = nbJoueur + 1;
        this.entraineur = entraineur;
        this.vetement = vetement;
        this.couleur = couleur;
        this.statistique.setProbaServiceCorrect(probaServiceCorrect);
        this.statistique.setProbaRenvoieCorrect(probaRenvoieCorrect);
        this.statistique.setProbaRenvoieFaute(probaRenvoieFaute);
        
        nbJoueur ++;
    }
    
    protected static Scanner scanner = new Scanner(System.in);

    /**
     * Cette méthode permet de créer un joueur manuellement.
     * @return Joueur
     * @throws InputMismatchException 
     */
    public static Joueur createJoueur() throws InputMismatchException{
        Joueur j = null;
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
            System.out.print("\nSponsor : ");
            String sponsor = scanner.next();
            System.out.print("\nEntraineur : ");
            String entraineur = scanner.next();
             
            System.out.print("\nProbabilité de réussir le service [0;1[ : ");
            double probaServiceCorrect = scanner.nextDouble();
            System.out.print("\nProbabilité p de réussir le renvoie de la balle [0;1[ : ");
            double probaRenvoieCorrect = scanner.nextDouble();
            System.out.print("\nProbabilité de faire faute lors du renvoie de la balle [p;1[ : ");
            double probaRenvoieFaute = scanner.nextDouble();
      
            Main main = Main.createInterface();
            Vetement vetement = Vetement.createInterface();
            
            Date dateNaissance = Date.createInterface("naissance");
            Random random = new Random();
            int esperanceVie = (vetement == Vetement.SHORT) ? (int)(7*random.nextGaussian() + 79) : (int)(7*random.nextGaussian() + 85);

            Date dateDeces = Date.genererAleatoire(dateNaissance.getAnnee() + esperanceVie);
            
            Couleur couleur = Couleur.createInterface();

            j = new Joueur(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids, main, sponsor, entraineur, vetement, couleur, probaServiceCorrect, probaRenvoieCorrect, probaRenvoieFaute);
        } 
        catch(InputMismatchException e){
            j = generer(Vetement.CHEMISE);
            System.out.println("Vous avez rentré un mauvais parametre pour votre joueur : You're a bad person !\nUn joueur aléatoire a été crée à la place\n");
        }
        catch (Exception e) {
            j = generer(Vetement.CHEMISE);
            System.out.println("Vous avez rentré un mauvais parametre pour votre joueur : You're a bad person !\nUn joueur aléatoire a été crée à la place\n");
        }

        System.out.println("Joueur crée\n");

        return j;
    }

    
    /* Getters */ 
    
    /**
     * @return Main
     */
    public Main getMain() {
        return this.main;
    }

    /**
     * @return String
     */
    public String getSponsor() {
        return this.sponsor;
    }

    /**
     * @return int
     */
    public int getClassement() {
        return this.classement;
    }

    /**
     * @return String
     */
    public String getEntraineur() {
        return this.entraineur;
    }

    /**
     * @return Vetement
     */
    public Vetement getVetement() {
        return this.vetement;
    }

    /**
     * @return Couleur
     */
    public Couleur getCouleur() {
        return this.couleur;
    }
    
    
    /* Setters */

    /**
     * @param main 
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * @param sponsor 
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * @param entraineur 
     */
    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    /**
     * @param vetement 
     */
    public void setVetement(Vetement vetement) {
        this.vetement = vetement;
    }

    /**
     * @param couleur 
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }    
    
    
    /* Methods */
    
    
    /**
     * Cette méthode permet d'afficher la valeurs des variables d'instances du joueur.
     * @since 21/10/2019
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " " + this.main + " " + this.sponsor + " " + 
                this.classement + " " + this.entraineur + " " + this.vetement 
                + " " + this.couleur;
    }
    
    /**
     * Cette méthode permet au joueur de servir durant le match.
     * @return Action
     */
    protected Action servir(){
        double random = Math.random();
        if(random < this.statistique.getProbaServiceCorrect()){return Action.CORRECT;}
        //else if(random < 0.66){return Action.SERVICE_FAUTE;}
        else{return Action.SERVICE_FAUTE;}
    }
    
    /**
     * Cette méthode permet au joueur de pouvoir renvoyer la balle.
     * @return Action
     */
    Action renvoyer(){
        double random = Math.random();
        if(random < this.statistique.getProbaRenvoieCorrect()){return Action.CORRECT;}
        else if(random < this.statistique.getProbaRenvoieFaute()){return Action.FAUTE;}
        else{return Action.FILET;}
    }
    
    
    /**
     * <ul><li>False : l'echange n'est pas terminé</li>
     * <li>True : échange terminé (donc point gagné ou faute)</li></ul>
     * @since 21/10/2019
     * @param equipe
     * @param arbitres
     * @param nbEchange
     * @param muteEchange
     * @return
     */
    public static Action play(Joueur[] equipe, Arbitre[] arbitres, int nbEchange, boolean muteEchange){
        if(!muteEchange){System.out.print(equipe[0].getPrenom());}
        if (nbEchange == 0) {
            if(!muteEchange){System.out.println(" sert");}
            return equipe[0].servir();
        }else{
            if(!muteEchange){System.out.println(" renvoie");}
            return equipe[0].renvoyer();
        }
    }
    
    /**
     * Cette méthode permet de générer un objet de type Joueur de manière aléatoire.
     * <h3>Exemple: </h3>
     * <p>
     * anneeNaissance: espérance = 1978 et écart_type = 15 donnera 
     * int anneeNaissance = (int)(15*random.nextGaussian() + 1991);
     * </p>
     * @since 16/11/2019
     * @param vetement, ce paramètre determine le sexe du joueur
     * @return Joueur
     * @see Random
     * @see Joueur
     * @see Spectateur
     */
    public static Joueur generer(Vetement vetement){
        Random random = new Random();
        
        /* Génération des attributs considérés communs */
        int anneeNaissance = (int)(7*random.nextGaussian() + 1991);
        String nomNaissance = Personne.nomFamille.get(random.nextInt(Personne.nomFamille.size()));
        String nomCourant = nomNaissance;   // Par défaut le nomCourant sera le nomNaissance
        String lieuNaissance = Personne.villeNaissance.get(random.nextInt(Personne.villeNaissance.size()));
        String nationalite = Personne.pays.get(random.nextInt(Personne.pays.size()));
        String sponsor = Personne.sponsor.get(random.nextInt(Personne.sponsor.size()));
        String entraineur = Personne.nomFamille.get(random.nextInt(Personne.nomFamille.size()));
        Date dateNaissance = Date.genererAleatoire(anneeNaissance);
        Couleur couleur = (random.nextBoolean()) ? Couleur.BLEU : Couleur.ROUGE ;  // Une chance sur 2 que la chemise ou les lunettes du/de la spectateur/spectatrice soit bleu ou rouge.
        Main main = (random.nextBoolean()) ? Main.DROITE : Main.GAUCHE;
        double probaServiceCorrect = random.nextDouble()*0.95;
        double probaRenvoieCorrect = random.nextDouble()*0.95;
        double probaRenvoieFaute = probaRenvoieCorrect + (random.nextDouble() * (1 - probaRenvoieCorrect));
        
        /* Attributs particuliers selon le sexe */
        int esperanceVie = (vetement == Vetement.SHORT) ? (int)(7*random.nextGaussian() + 79) : (int)(7*random.nextGaussian() + 85);
        int taille = (vetement == Vetement.SHORT) ? (int)(6*random.nextGaussian() + 178) : (int)(6*random.nextGaussian() + 165);
        int poids = (vetement == Vetement.SHORT) ? (int)(6*random.nextGaussian() + 75) : (int)(6*random.nextGaussian() + 70);
        String prenom = (vetement == Vetement.SHORT) ? Personne.prenomMasculin.get(random.nextInt(Personne.prenomMasculin.size())) : Personne.prenomFeminin.get(random.nextInt(Personne.prenomFeminin.size()));
        String surnom = prenom;
        Date dateDeces = Date.genererAleatoire(anneeNaissance + esperanceVie);
        nomCourant = (vetement == Vetement.SHORT) ? nomNaissance : Personne.nomFamille.get(random.nextInt(Personne.nomFamille.size()));
        
        return new Joueur(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids, main, sponsor, entraineur, vetement, couleur, probaServiceCorrect, probaRenvoieCorrect, probaRenvoieFaute);
    }
}




