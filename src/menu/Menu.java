package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Cette classe affiche l'interface permettant de faire l'intéraction entre l'utilisateur et le programme.</b>
 * @author Clément
 * @since 17/11/2019
 * @see MenuItems
 */
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    
    public ArrayList<MenuItems> choices = new ArrayList<MenuItems>();
    
    /* Constructor */
    
    public Menu(){
    	this.choices.add(new MenuItems("Quittez le programme",-1));
    }
    
    /**
     * Cette méthode permet de gérer les choix de l'utilisateur.
     * @param choice 
     */
    public void addChoice(MenuItems choice){
        this.choices.add(this.choices.size() - 1,new MenuItems(choice.description,this.choices.size() - 1));
    }

    /**
     * Cette méthode permet d'afficher le menu selon les entrées de l'utilisateur.
     * @return int
     */
    protected int afficherMenu(){
        System.out.println("--------------------------");
        for (int i = 0; i < this.choices.size(); i++) {
            System.out.printf("|  %d. %s%n",i, this.choices.get(i).description);
        }
        System.out.println("|\n|  Fait ton choix :");
        System.out.print("> ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            // Not a interger
            if (e instanceof InputMismatchException) {
                System.out.println("Veulliez rentrer un entier !");   
                scanner.next();
            }
            return -1;
        }
    }

    /**
     * @return int
     */
    public int getChoice(){
        int choice = this.afficherMenu();
        //System.out.println(choices.size());
        while(choice < 0 || choice >= choices.size()){
            choice = this.afficherMenu();
        }

        return (this.choices.get(choice) != null) ? this.choices.get(choice).value : choice;
    }
}
