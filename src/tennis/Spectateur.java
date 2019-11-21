/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.Random;

/**
 * 21/10/2019
 * @author Nicolas
 */
public class Spectateur extends Personne implements ActionSpectateur{
    protected Vetement vetement;
    protected Couleur couleur;
    protected Billet billet;
    
    public static int nbSpectateur = 0; // Compte le nombre de spectateur
    
    /* Constructor */
    
    /**
     * 21/10/2019
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
     * @param vetement
     * @param couleur 
     */
    public Spectateur(String nomNaissance, String nomCourant, String prenom,
                    String surnom, Date dateNaissance, String lieuNaissance,
                    Date dateDeces, String nationalite, int taille, int poids,
                    Vetement vetement, Couleur couleur){
        
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        this.vetement = vetement;
        this.couleur = couleur;
        
        nbSpectateur++;
    }
    
    
    /* Getters */
    
    
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
    
    /**
     * 21/10/2019
     * @return Billet
     */
    public Billet getBillet(){
        return this.billet;
    }
    
    
    /* Setters */
    
    
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
     * 15/11/2019
     * @param prix
     * @param tribune
     * @param place 
     */
    public void acheterBillet(int prix, Tribune tribune, int place){
        this.billet = new Billet(prix, tribune, place);
    }
    
    
    /* Interface ActionSpectateur methods */
    
    @Override
    public void applaudir(){
        System.out.println("CLAP CLAP CLAP");
    }
    
    @Override
    public void crier(){
        System.out.println("ALLEZ !!!");
    }
    
    @Override
    public void huer(){
        System.out.println("BOOOOOOOOOOO !!!! NUL !");
    }
    
    @Override
    public void dormir(){
        System.out.println("ZzZzZzZzZzZzZ");
    }
    
    /**
     * 15/11/209
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " " + this.vetement + " " + this.couleur + " " + this.billet;
    }
    
    /**
     * 15/11/2019
     * @return Spectateur
     * Cette méthode permet de générer un spectateur
     */
    public static Spectateur generer(){
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
               nationalite = Personne.pays[random.nextInt(Personne.pays.length)];
        Date dateNaissance = Date.genererAleatoire(anneeNaissance);
        Couleur couleur = (random.nextBoolean()) ? Couleur.BLEU : Couleur.ROUGE ;  // Une chance sur 2 que la chemise ou les lunettes du/de la spectateur/spectatrice soit bleu ou rouge.
        
        /* Attributs particuliers selon le sexe */
        Vetement vetement = (random.nextBoolean()) ? Vetement.CHEMISE : Vetement.LUNETTES; // Determine le sexe du spectateur
        
        int esperanceVie = (vetement == Vetement.CHEMISE) ? (int)(7*random.nextGaussian() + 79) : (int)(7*random.nextGaussian() + 85),
            taille = (vetement == Vetement.CHEMISE) ? (int)(6*random.nextGaussian() + 178) : (int)(6*random.nextGaussian() + 165),
            poids = (vetement == Vetement.CHEMISE) ? (int)(6*random.nextGaussian() + 75) : (int)(6*random.nextGaussian() + 70);
        String prenom = (vetement == Vetement.CHEMISE) ? Personne.prenomMasculin[random.nextInt(Personne.prenomMasculin.length)] : Personne.prenomFeminin[random.nextInt(Personne.prenomFeminin.length)],
               surnom = prenom;
        Date dateDeces = Date.genererAleatoire(anneeNaissance + esperanceVie);
        nomCourant = (vetement == Vetement.CHEMISE) ? nomNaissance : Personne.nomFamille[random.nextInt(Personne.nomFamille.length)];
        
        return new Spectateur(nomNaissance, nomCourant, prenom, surnom, 
                    dateNaissance, lieuNaissance, dateDeces, nationalite,
                    taille, poids, vetement, couleur);
    }
}


