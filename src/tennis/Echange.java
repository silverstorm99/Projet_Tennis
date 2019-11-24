/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette classe permet de créer un échange entre deux équipes/joueurs.</b>
 * @since 25/10/2019
 * @author Nicolas, Clément
 * @see Jeu
 * @see Joueur
 * @see Arbitre
 * @see Spectateur
 */
public class Echange {
    protected Arbitre [] arbitres;
    protected Joueur[] equipe1;
    protected Joueur[] equipe2;
    protected Spectateur[] spectateurs;
    protected int service;
    
    /* Constructor */
    
    /**
     * @since 03/11/2019
     * @param arbitres
     * @param equipe1
     * @param equipe2
     * @param spectateurs 
     */
    public Echange(Arbitre[] arbitres, Joueur[] equipe1, Joueur[] equipe2, Spectateur[] spectateurs, int service) {
        this.arbitres = arbitres;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.spectateurs = spectateurs;
        this.service = service;
    }
    
    /* Method */
    
    /**
     * Cette méthode renvoie l'équipe qui remporte l'échange.
     * @since 20/11/2019
     * @param muteEchange
     * @return Joueur []
     */
    public Joueur [] play(boolean muteEchange){
        Joueur [][] equipe = {this.equipe1, this.equipe2};     
        int nbEchange = 0; // permet de tracer l'echange en cours
        Action echange = Action.CORRECT;
        int fauteService = 0;
        
        while(echange == Action.CORRECT){
            echange = Joueur.play(equipe[(this.service + nbEchange) %2],this.arbitres,nbEchange,muteEchange);
            nbEchange++;
            if (echange == Action.SERVICE_LET) {
                // on remet a zero pour que le joeur puisse re-servir sans compter de faute 
                if(!muteEchange){
                    System.out.println(equipe[(this.service + --nbEchange)%2][0].getPrenom() + " a fait un let");
                }
                echange = Action.CORRECT;
                nbEchange = 0;
            }
            else if (echange == Action.SERVICE_FAUTE && fauteService==0) {
                // on remet a zero pour que le joeur puisse re-servir en comptant la faute 
                if(!muteEchange){
                    System.out.println(equipe[(this.service + --nbEchange)%2][0].getPrenom() + " a fait une faute au service a lechange");
                }
                echange = Action.CORRECT;
                nbEchange = 0;
                fauteService++;
            }

        }
        
        // Permet d'afficher ou non les résultats de chaque échanges
        if(!muteEchange){
            System.out.println(equipe[(this.service + nbEchange)%2][0].getPrenom() + " a gagne car "+  equipe[(this.service + nbEchange + 1)%2][0].getPrenom() + " a perdu l'echange avec " + echange);
        }

        return equipe[(this.service + nbEchange)%2];
    }
}

