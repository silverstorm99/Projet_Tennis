/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.ArrayList;

/**
 * 13/10/2019
 * @author Nicolas
 */
public class Tennis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Joueur player = new Joueur("SCHMITT", "SCHMITT", "Nicolas", "Nico",
                new Date(23,2,1998), "Metz", new Date(19,11,2019), "France",
                170, 60, Main.DROITE, "URSS", "Poutine", Vetement.SHORT, Couleur.BLEU);
        
        Joueur player2 = new Joueur("SCHMITT", "SCHMITT", "Nicolas", "Nico",
                new Date(14,07,1960), "Metz", new Date(9,11,2019), "France",
                170, 60, Main.GAUCHE, "URSS", "Poutine", Vetement.SHORT, Couleur.BLEU);
        
        Joueur player3 = new Joueur("SCHMITT", "SCHMITT", "Nicolas", "Nico",
                new Date(23,2,1998), "Metz", new Date(19,11,2019), "France",
                170, 60, Main.DROITE, "URSS", "Poutine", Vetement.SHORT, Couleur.BLEU);
        
        Joueur player4 = new Joueur("SCHMITT", "SCHMITT", "Nicolas", "Nico",
                new Date(14,07,1960), "Metz", new Date(9,11,2019), "France",
                170, 60, Main.GAUCHE, "URSS", "Poutine", Vetement.SHORT, Couleur.BLEU);
        
        Arbitre arbitre = new Arbitre("Mamene", "Mamene", "Rico", "Rico",
                new Date(14,07,1995), "Metz", new Date(19,11,2019), "France",
                170, 60);
        
        Arbitre [] arbitres = {arbitre};
        Joueur [] equipe1 = {player};
        Joueur [] equipe2 = {player2};
        Spectateur [] spectateur = {};
        Match match = new Match(Categorie.SIMPLE_HOMME, Phase.FINALE, arbitres, equipe1, equipe2, spectateur);
        match.play();
        
        int arraySize = 100;
        
        ArrayList <Spectateur> spectateurs = new ArrayList <Spectateur> (arraySize);
        
        for(int i=0; i<arraySize; i++){
            spectateurs.add(Spectateur.generer());
            System.out.println(spectateurs.get(i));
        }
        
        //Tournoi tournoi = new Tournoi(Ville.LONDRES, Categorie.SIMPLE_HOMME);
    }
}
















