/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.ArrayList;
import java.util.Scanner;

import menu.*;

/**
 * <b>Cette classe est le point d'entrée du programme.</b>
 * @author Nicolas, Clément
 * @since 13/10/2019
 * @see Menu
 * @see Tournoi
 */
public class Tennis {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        /* Test création match */
        /*

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

        */
        /* Test génération spectateur */
        /*

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

        */
        /* Test génération Joueur */
        /*

        System.out.println("\n\n Test générer Joueur");
        
        arraySize = 128;
        
        ArrayList <Joueur> joueurs = new ArrayList <Joueur> (arraySize);
        
        for(int i=joueurs.size(); i<arraySize; i++){
            joueurs.add(Joueur.generer(Vetement.SHORT));
            System.out.print(i+" ");
            System.out.println(joueurs.get(i));
        }

        */
        /* Test génération Arbitre */
        /*

        System.out.println("\n\n Test générer Arbitre");
        
        arraySize = 10;
        
        ArrayList <Arbitre> arbitres = new ArrayList <Arbitre> (arraySize);
        
        for(int i=arbitres.size(); i<arraySize; i++){
            arbitres.add(Arbitre.generer());
            System.out.print(i+" ");
            System.out.println(arbitres.get(i));
        }
        */
        
        /* Test création d'un tournoi */
        /*  
        System.out.println("\n\n Test générer Tournoi");
        
        ArrayList <Joueur> joueurs = new ArrayList <Joueur> ();
        joueurs.add(new Joueur("SCHMITT", "SCHMITT", "Nicolas", "Ruskov", new Date(23,02,1998), "Metz", new Date(25,11,2019), "France", 170, 59, Main.DROITE, "Satan Corporation", "Poutine", Vetement.SHORT, Couleur.BLEU, 0.80, 0.9, 0.95));
        joueurs.add(new Joueur("SANCHEZ", "SANCHEZ", "Clément", "Mamène", new Date(23,02,1998), "Metz", new Date(31,12,2999), "France", 170, 59, Main.DROITE, "Apple", "ALKPOTE", Vetement.SHORT, Couleur.ROUGE, 0.80, 0.9, 0.95));
        joueurs.add(new Joueur("DUBOIS", "DUBOIS", "Thomas", "Th4nx", new Date(23,02,1998), "Metz", new Date(31,12,2999), "France", 170, 59, Main.DROITE, "Apple", "ALKPOTE", Vetement.SHORT, Couleur.ROUGE, 0.80, 0.9, 0.95));
        
        Tournoi tournoi = new Tournoi(Ville.LONDRES, Categorie.SIMPLE_HOMME, joueurs);
        tournoi.play(true, true, true, true);
        
        /*
        for(int i=0; i<127; i++){
        System.out.print(i+" ");
        System.out.println(tournoi.getMatchs().get(i).toString());
        }
        */
        /*
        for(int i=0; i<128;i++){
        System.out.print(i+" ");
        System.out.println(tournoi.getJoueurs().get(i).toString());
        }
        */

    	Menu menuPrincipal = new Menu("Tennis game");
    	menuPrincipal.addChoice(new MenuItems("Creer un nouveau personnage"));
        menuPrincipal.addChoice(new MenuItems("Creer un tournoi"));
    	Boolean continu = true;
    	while(continu && !fini) {
            switch (menuPrincipal.getChoice()) {
                case 0:
                    createPersonnage();
                    break;
                case 1:
                    System.out.println("creation d'un tournoi");
                    break;
                case -1:
                    System.out.println("fini");
                    fini = true;
                    break;
                default:
                    break;
            }
        }
    }
    
    protected static Boolean fini = false;
    protected static ArrayList<Personne> mesPersonnages = new ArrayList<Personne>();
    protected static Scanner scanner = new Scanner(System.in);

    public static void createPersonnage(){
        //System.out.println("creation d'un nouveau personnage");
        Menu menuPersonnage = new Menu("Nouveau personnage");
        menuPersonnage.addChoice(new MenuItems("Creer un nouveau joueur"));
        menuPersonnage.addChoice(new MenuItems("Creer un nouveau arbitre"));
        menuPersonnage.addChoice(new MenuItems("Creer un nouveau spectateur"));
        menuPersonnage.addChoice(new MenuItems("Retourner en arriere",-2));
        
        Boolean continu = true;
    	while(continu && !fini){
            switch (menuPersonnage.getChoice()) {
                case 0:
                    System.out.println("creation d'un joueur");
                    mesPersonnages.add(Joueur.createJoueur());
                    break;
                case 1:
                    System.out.println("creation d'un arbitre");
                    break;
                case -2:
                    System.out.println("En arriere");
                    continu = false;
                    break;
                case -1:
                    System.out.println("fini");
                    fini = true;
                    break;
                default:
                    System.out.println("Action non implémenté");
                    break;
            }
        }
    }
}
