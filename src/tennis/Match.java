/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * 25/10/2019
 * @author Nicolas
 */
public class Match {
    protected Categorie categorie;
    protected Phase phase;
    protected Arbitre [] arbitres;
    protected Joueur[] equipe1;
    protected Joueur[] equipe2;
    protected Spectateur[] spectateurs;
    
    
    /* Constructors */
    
    /**
     * 02/11/2019
     * @param categorie
     * @param phase
     * @param arbitres
     * @param equipe1
     * @param equipe2
     * @param spectateurs 
     */
    public Match(Categorie categorie, Phase phase, Arbitre [] arbitres, 
            Joueur [] equipe1, Joueur [] equipe2, Spectateur [] spectateurs) throws IllegalArgumentException {
        
        
        /* Exceptions */
        
        if(arbitres.length == 0){throw new IllegalArgumentException("Il n'y a pas d'abitre(s) pour arbitrer le match.");}
        
        switch (categorie) {
            case SIMPLE_HOMME:
                if(equipe1.length != 1){throw new IllegalArgumentException("L'équipe 1 est composée de " + equipe1.length + " joueur(s).");}
                if(equipe2.length != 1){throw new IllegalArgumentException("L'équipe 2 est composée de " + equipe2.length + " joueur(s).");}
                if(equipe1[0].getVetement() != Vetement.SHORT){throw new IllegalArgumentException("Le joueur de l'équipe 1 n'est pas un homme.");}
                if(equipe2[0].getVetement() != Vetement.SHORT){throw new IllegalArgumentException("Le joueur de l'équipe 2 n'est pas un homme.");}
                break;
            case DOUBLE_HOMME:
                if(equipe1.length != 2){throw new IllegalArgumentException("L'équipe 1 est composée de " + equipe1.length + " joueur(s).");}
                if(equipe2.length != 2){throw new IllegalArgumentException("L'équipe 2 est composée de " + equipe2.length + " joueur(s).");}
                if(equipe1[0].getVetement() != Vetement.SHORT){throw new IllegalArgumentException("Le joueur 1 de l'équipe 1 n'est pas un homme.");}
                if(equipe1[1].getVetement() != Vetement.SHORT){throw new IllegalArgumentException("Le joueur 2 de l'équipe 1 n'est pas un homme.");}
                if(equipe2[0].getVetement() != Vetement.SHORT){throw new IllegalArgumentException("Le joueur 1 de l'équipe 2 n'est pas un homme.");}
                if(equipe2[1].getVetement() != Vetement.SHORT){throw new IllegalArgumentException("Le joueur 2 de l'équipe 2 n'est pas un homme.");}
                break;
            case SIMPLE_FEMME:
                if(equipe1.length != 1){throw new IllegalArgumentException("L'équipe 1 est composée de " + equipe1.length + " joueur(s).");}
                if(equipe2.length != 1){throw new IllegalArgumentException("L'équipe 2 est composée de " + equipe2.length + " joueur(s).");}
                if(equipe1[0].getVetement() != Vetement.JUPE){throw new IllegalArgumentException("Le joueur de l'équipe 1 n'est pas une femme.");}
                if(equipe2[0].getVetement() != Vetement.JUPE){throw new IllegalArgumentException("Le joueur de l'équipe 2 n'est pas une femme.");}
                break;
            case DOUBLE_FEMME:
                if(equipe1.length != 2){throw new IllegalArgumentException("L'équipe 1 est composée de " + equipe1.length + " joueur(s).");}
                if(equipe2.length != 2){throw new IllegalArgumentException("L'équipe 2 est composée de " + equipe2.length + " joueur(s).");}
                if(equipe1[0].getVetement() != Vetement.JUPE){throw new IllegalArgumentException("Le joueur 1 de l'équipe 1 n'est pas une femme.");}
                if(equipe1[1].getVetement() != Vetement.JUPE){throw new IllegalArgumentException("Le joueur 2 de l'équipe 1 n'est pas une femme.");}
                if(equipe2[0].getVetement() != Vetement.JUPE){throw new IllegalArgumentException("Le joueur 1 de l'équipe 2 n'est pas une femme.");}
                if(equipe2[1].getVetement() != Vetement.JUPE){throw new IllegalArgumentException("Le joueur 2 de l'équipe 2 n'est pas une femme.");}
                break;
            default:
                throw new IllegalArgumentException("La categorie du match n'existe pas");
        }
        
        
        this.categorie = categorie;
        this.phase = phase;
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
    }
    
    /**
     * 18/11/2019
     * @param categorie
     * @param phase
     * @param arbitres
     * @param spectateurs 
     */
    public Match(Categorie categorie, Phase phase, Arbitre [] arbitres, Spectateur [] spectateurs){
        
        // Exceptions
        if(arbitres.length == 0){throw new IllegalArgumentException("Il n'y a pas d'abitre(s) pour arbitrer le match.");}
        
        this.categorie = categorie;
        this.phase = phase;
        this.arbitres = arbitres;
        this.spectateurs = spectateurs;
    }
    
    
    /* Getters */
    
    /**
     * 25/10/2019
     * @return Categorie
     */
    public Categorie getCategorie() {
        return this.categorie;
    }
    
    /**
     * 25/10/2019
     * @return Phase
     */
    public Phase getPhase() {
        return this.phase;
    }
    
    /**
     * 25/10/2019
     * @return Arbitre[]
     */
    public Arbitre [] getArbitres() {
        return this.arbitres;
    }

    /**
     * 02/11/2019
     * @return Joueur[]
     */
    public Joueur [] getEquipe1() {
        return this.equipe1;
    }
    
    /**
     * 02/11/2019
     * @return Joueur[]
     */
    public Joueur [] getEquipe2() {
        return this.equipe2;
    }

    /**
     * 25/10/2019
     * @return Spectateur[]
     */
    public Spectateur [] getSpectateurs() {
        return this.spectateurs;
    }
    
    /* Setters */
    
    /**
     * 18/11/2019
     * @param equipe1 
     */
    public void setEquipe1(Joueur[] equipe1) {
        this.equipe1 = equipe1;
    }

    /**
     * 18/11/2019
     * @param equipe2 
     */
    public void setEquipe2(Joueur[] equipe2) {
        this.equipe2 = equipe2;
    }
    
    /* Methods */
    
    /**
     * 20/11/2019
     * @param muteMatch
     * @param muteSet
     * @param muteJeu
     * @param muteEchange
     * @return Joueur []
     * Cette méthode renvoie l'équipe qui remporte le match
     */
    public Joueur [] play(boolean muteMatch, boolean muteSet, boolean muteJeu, boolean muteEchange){
        // Exception dans le cas où il n'y a pas de joueurs
        if(this.equipe1.length == 0 || this.equipe2.length == 0){throw new IllegalArgumentException("Il n'y a pas de joueur pour ce match.");}
                
        Joueur [] vainqueurMatch = {}; // Equipe qui remportera le match
        Joueur [] vainqueurSet = {}; // Equipe qui remportera le set
        int score1 = 0, score2 = 0; // Scores (set) de chaques équipes
        
        int service = Math.random() < 0.5 ? 0 : 1; // Determine aleatoirement qui sert le premier
 
        // Premier et deuxième sets
        while((score1 < 2 && score2 < 2) || score1 == score2){
            // Set décisif si égalité
            if(score1 == score2 && score1 != 0 && !muteMatch){ 
                System.out.println("\nSet décisif " + score1);
            }
            Set set = new Set(this.arbitres, this.equipe1, this.equipe2, this.spectateurs,(service++) %2);
            
            vainqueurSet = set.play(muteSet, muteJeu, muteEchange);
            if(vainqueurSet == this.equipe1){score1++;}
            else if(vainqueurSet == this.equipe2){score2++;}
            
            // Permet d'afficher ou non le résultat du match
            if(!muteMatch){
                this.arbitres[0].annoncerScoreMatch(vainqueurSet, score1, score2);
            }
        }
        
        if(score1 < score2){vainqueurMatch = this.equipe2;}
        else if(score1 > score2){vainqueurMatch = this.equipe1;}
        
        return vainqueurMatch;
    }
    
    /**
     * 18/11/2019
     * @return String
     */
    @Override
    public String toString(){
        return this.categorie + " " + this.phase + " " + this.categorie + " " + 
                this.arbitres + " " + this.equipe1 + " " + this.equipe2 + " " + this.spectateurs;
    }
}

