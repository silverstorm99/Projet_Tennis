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
        
        /* Test création match */
        
        Joueur player = new Joueur("SCHMITT", "SCHMITT", "Nicolas", "Nico",
                new Date(23,2,1998), "Metz", new Date(19,11,2019), "France",
                170, 60, Main.DROITE, "URSS", "Poutine", Vetement.SHORT, Couleur.BLEU);
        
        Joueur player2 = new Joueur("Sanchez", "SANCHEZ", "Clement", "Clem",
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
        
        Arbitre [] arbitre1 = {arbitre};
        Joueur [] equipe1 = {player};
        Joueur [] equipe2 = {player2};
        Spectateur [] spectateur = {};
        Match match = new Match(Categorie.SIMPLE_HOMME, Phase.FINALE, arbitre1, equipe1, equipe2, spectateur);
        match.play();
        
        /* Test génération spectateur */
        
        System.out.println("\n\n Test générer Spectateur");
        
        int arraySize = 100;
        
        ArrayList <Spectateur> spectateurs = new ArrayList <Spectateur> (arraySize);
        
        // Ajout d'un premier spectateur dans la liste
        Spectateur spectateur2 = new Spectateur("SCHMITT", "SCHMITT", "Nicolas", "Ruskov", new Date(23,02,1998), "Metz", new Date(25,11,2019), "France", 170, 60, Vetement.CHEMISE, Couleur.BLEU);
        spectateurs.add(spectateur2);
        System.out.println(spectateurs.get(0));
        
        // On complète la liste en générant d'autre spectateur
        for(int i=spectateurs.size(); i<arraySize; i++){
            spectateurs.add(Spectateur.generer());
            System.out.print(i+" ");
            System.out.println(spectateurs.get(i));
        }
        
        /* Test génération Joueur */
        
        System.out.println("\n\n Test générer Joueur");
        
        arraySize = 128;
        
        ArrayList <Joueur> joueurs = new ArrayList <Joueur> (arraySize);
        
        for(int i=joueurs.size(); i<arraySize; i++){
            joueurs.add(Joueur.generer(Vetement.SHORT));
            System.out.print(i+" ");
            System.out.println(joueurs.get(i));
        }
        
        /* Test génération Arbitre */
        
        System.out.println("\n\n Test générer Arbitre");
        
        arraySize = 10;
        
        ArrayList <Arbitre> arbitres = new ArrayList <Arbitre> (arraySize);
        
        for(int i=arbitres.size(); i<arraySize; i++){
            arbitres.add(Arbitre.generer());
            System.out.print(i+" ");
            System.out.println(arbitres.get(i));
        }
        
        //Tournoi tournoi = new Tournoi(Ville.LONDRES, Categorie.SIMPLE_HOMME);
    }
}






















