/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.Random;

/**
 * <b>Cette classe permet de créer un objet de type Spectateur.</b>
 * @since 21/10/2019
 * @author Nicolas
 * @see Random
 * @see Personne
 * @see Vetement
 * @see Couleur
 * @see Billet
 * @see ActionSpectateur
 */
public class Spectateur extends Personne implements ActionSpectateur{
    protected Vetement vetement;
    protected Couleur couleur;
    protected Billet billet;
    
    public static int nbSpectateur = 0; // Compte le nombre de spectateur
    
    /* Constructor */
    
    /**
     * @since 21/10/2019
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
    public Spectateur(String nomNaissance, String nomCourant, String prenom, String surnom, Date dateNaissance, String lieuNaissance, Date dateDeces, String nationalite, int taille, int poids, Vetement vetement, Couleur couleur){
        super(nomNaissance, nomCourant, prenom, surnom, dateNaissance, 
                lieuNaissance, dateDeces, nationalite, taille, poids);
        this.vetement = vetement;
        this.couleur = couleur;
        
        nbSpectateur++;
    }
    
    
    /* Getters */
    
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
    
    /**
     * @return Billet
     */
    public Billet getBillet(){
        return this.billet;
    }
    
    
    /* Setters */
  
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
     * Cette méthode permet au spectateur d'acheter un billet pour voir le match.
     * @since 15/11/2019
     * @param prix
     * @param tribune
     * @param place 
     */
    public void acheterBillet(int prix, Tribune tribune, int place){
        this.billet = new Billet(prix, tribune, place);
    }
    
    /**
     * Cette méthode permet au spectateur d'acheter un billet pour voir le match.
     * @since 24/11/2019
     * @param billet 
     */
    public void acheterBillet(Billet billet){
        this.billet = billet;
    }
    
    /**
     * Cette méthode renvoie les variables d'instances du spectateur.
     * @since 15/11/209
     * @return String
     */
    @Override
    public String toString(){
        return super.toString() + " " + this.vetement + " " + this.couleur + " " + this.billet;
    }
    
    /**
     * Cette méthode permet de générer un objet de type Spectateur de manière aléatoire.
     * <h3>Exemple: </h3>
     * <p>
     * anneeNaissance: espérance = 1978 et écart_type = 15 donnera 
     * int anneeNaissance = (int)(15*random.nextGaussian() + 1991);
     * </p>
     * @since 15/11/2019
     * @return Spectateur
     */
    public static Spectateur generer(){
        Random random = new Random();
        
        /* Génération des attributs considérés communs */
        int anneeNaissance = (int)(15*random.nextGaussian() + 1991);
        String nomNaissance = Personne.nomFamille.get(random.nextInt(Personne.nomFamille.size()));
        String nomCourant = nomNaissance;   // Par défaut le nomCourant sera le nomNaissance
        String lieuNaissance = Personne.villeNaissance.get(random.nextInt(Personne.villeNaissance.size()));
        String nationalite = Personne.pays.get(random.nextInt(Personne.pays.size()));
        Date dateNaissance = Date.genererAleatoire(anneeNaissance);
        Couleur couleur = (random.nextBoolean()) ? Couleur.BLEU : Couleur.ROUGE ;  // Une chance sur 2 que la chemise ou les lunettes du/de la spectateur/spectatrice soit bleu ou rouge.
        
        /* Attributs particuliers selon le sexe */
        Vetement vetement = (random.nextBoolean()) ? Vetement.CHEMISE : Vetement.LUNETTES; // Determine le sexe du spectateur
        
        int esperanceVie = (vetement == Vetement.CHEMISE) ? (int)(7*random.nextGaussian() + 79) : (int)(7*random.nextGaussian() + 85);
        int taille = (vetement == Vetement.CHEMISE) ? (int)(6*random.nextGaussian() + 178) : (int)(6*random.nextGaussian() + 165);
        int poids = (vetement == Vetement.CHEMISE) ? (int)(6*random.nextGaussian() + 75) : (int)(6*random.nextGaussian() + 70);
        String prenom = (vetement == Vetement.CHEMISE) ? Personne.prenomMasculin.get(random.nextInt(Personne.prenomMasculin.size())) : Personne.prenomFeminin.get(random.nextInt(Personne.prenomFeminin.size()));
        String surnom = prenom;
        Date dateDeces = Date.genererAleatoire(anneeNaissance + esperanceVie);
        nomCourant = (vetement == Vetement.CHEMISE) ? nomNaissance : Personne.nomFamille.get(random.nextInt(Personne.nomFamille.size()));
        
        return new Spectateur(nomNaissance, nomCourant, prenom, surnom, dateNaissance, lieuNaissance, dateDeces, nationalite, taille, poids, vetement, couleur);
    }
}

