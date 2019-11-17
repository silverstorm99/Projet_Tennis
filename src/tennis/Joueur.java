/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.Random;

/**
 * 13/10/2019
 * @author Nicolas
 */
public class Joueur extends Personne implements ActionSpectateur{
    protected Main main;
    protected String sponsor;
    protected int classement;
    protected String entraineur;
    
    protected Vetement vetement;
    protected Couleur couleur;
    
    public static int nbJoueur = 0; // Compte le nombre de joueur
    
    public Joueur (String nomNaissance, String nomCourant, String prenom,String surnom, Date dateNaissance, String lieuNaissance,Date dateDeces, String nationalite, int taille,
        int poids,Main main, String sponsor, String entraineur, Vetement vetement, Couleur couleur){
        
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids);
        this.main = main;
        this.sponsor = sponsor;
        this.classement = nbJoueur + 1;
        this.entraineur = entraineur;
        
        this.vetement = vetement;
        this.couleur = couleur;
        
        nbJoueur ++;
    }

    /* Getters */ 
    
    /**
     * 21/10/2019
     * @return Main
     */
    public Main getMain() {
        return this.main;
    }

    /**
     * 21/10/2019
     * @return String
     */
    public String getSponsor() {
        return this.sponsor;
    }

    /**
     * 21/10/2019
     * @return int
     */
    public int getClassement() {
        return this.classement;
    }

    /**
     * 21/10/2019
     * @return String
     */
    public String getEntraineur() {
        return this.entraineur;
    }

    /**
     * 21/10/2019
     * @return Vetement
     */
    public Vetement getVetement() {
        return this.vetement;
    }

    /**
     * 21/10/2019
     * @return Couleur
     */
    public Couleur getCouleur() {
        return this.couleur;
    }
    
    /* Setters */

    /**
     * 21/10/2019
     * @param main 
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * 21/10/2019
     * @param sponsor 
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * 21/10/2019
     * @param entraineur 
     */
    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    /**
     * 21/10/2019
     * @param vetement 
     */
    public void setVetement(Vetement vetement) {
        this.vetement = vetement;
    }

    /**
     * 21/10/2019
     * @param couleur 
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }    
    
    /* Methods */
    
    /**
     * 21/10/2019
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " " + this.main + " " + this.sponsor + " " + 
                this.classement + " " + this.entraineur + " " + this.vetement 
                + " " + this.couleur;
    }
    
    
    protected Action servir(){
        // Simulation
        double random = Math.random();
        if(random < 0.66){return Action.CORRECT;}
        //else if(random < 0.66){return Action.SERVICE_FAUTE;}
        else{return Action.SERVICE_FAUTE;}
    }
    
    Action renvoyer(){
        // Simulation
        double random = Math.random();
        if(random < 0.8){return Action.CORRECT;}
        else if(random < 0.9){return Action.FAUTE;}
        else{return Action.FILET;}
    }
    
    
    /*
    * 21/10/2019
     * @return Boolean
     * servir, retourner un service, renvoyer la balle de l'adversaire, 
     * faire des fautes, appeler l'arbitre, s'encourager, boire, criersa victoire/sa défaite
     * 
     * False veut dire que l'echange nest pas fini
     * True oui (donc point gagne ou faute)
     * */
    public static Action play(Joueur[] equipe,Arbitre[] arbitres,int nbEchange){
        System.out.print(equipe[0].getPrenom());
        if (nbEchange == 0) {
            System.out.println(" sert");
            return equipe[0].servir();
        }else{
            System.out.println(" renvoie");
            return equipe[0].renvoyer();
        }
    }
    
    /**
     * 16/11/2019
     * @param vetement, ce paramètre determine le sexe du joueur
     * @return Joueur
     */
    public static Joueur generer(Vetement vetement){
        /* 
        Création d'un objet de type Random pour générer de manière aléatoire
        les différents attributs du spectateur ou de la spectatrice.
        
        anneeNaissance, esperanceVie, taille et poids suivront une loi normale
        
        Exemple: 
        anneeNaissance: espérance = 1978 et écart_type = 15 donnera 
        int anneeNaissance = (int)(15*random.nextGaussian() + 1991);
        */
        Random random = new Random();
        
        /* Génération des attributs considérés communs */
        int anneeNaissance = (int)(15*random.nextGaussian() + 1991);
        String nomNaissance = Personne.nomFamille[random.nextInt(Personne.nomFamille.length)],
               nomCourant = nomNaissance,   // Par défaut le nomCourant sera le nomNaissance
               lieuNaissance = Personne.villeNaissance[random.nextInt(Personne.villeNaissance.length)],
               nationalite = Personne.pays[random.nextInt(Personne.pays.length)],
               sponsor = Personne.sponsor[random.nextInt(Personne.sponsor.length)],
               entraineur = Personne.nomFamille[random.nextInt(Personne.nomFamille.length)];
        Date dateNaissance = Date.generer(anneeNaissance);
        Couleur couleur = (random.nextBoolean()) ? Couleur.BLEU : Couleur.ROUGE ;  // Une chance sur 2 que la chemise ou les lunettes du/de la spectateur/spectatrice soit bleu ou rouge.
        Main main = (random.nextBoolean()) ? Main.DROITE : Main.GAUCHE;
        
        /* Attributs particuliers selon le sexe */
        int esperanceVie = (vetement == Vetement.SHORT) ? (int)(7*random.nextGaussian() + 79) : (int)(7*random.nextGaussian() + 85),
            taille = (vetement == Vetement.SHORT) ? (int)(6*random.nextGaussian() + 178) : (int)(6*random.nextGaussian() + 165),
            poids = (vetement == Vetement.SHORT) ? (int)(6*random.nextGaussian() + 75) : (int)(6*random.nextGaussian() + 70);
        String prenom = (vetement == Vetement.SHORT) ? Personne.prenomMasculin[random.nextInt(Personne.prenomMasculin.length)] : Personne.prenomFeminin[random.nextInt(Personne.prenomFeminin.length)],
               surnom = prenom;
        Date dateDeces = Date.generer(anneeNaissance + esperanceVie);
        nomCourant = (vetement == Vetement.SHORT) ? nomNaissance : Personne.nomFamille[random.nextInt(Personne.nomFamille.length)];
        
        return new Joueur(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids, main, sponsor, entraineur, vetement, couleur);
    }
}






