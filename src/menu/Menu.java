package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author clement
 *
 */
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private String title = new String("");
    public ArrayList<MenuItems> choices = new ArrayList<MenuItems>();
    
    
    /**
     * This constructor allow to create easily menu 
     * @param title
     */
    public Menu(String title){
    	this.choices.add(new MenuItems("Quittez le programme",-1));
    	this.title = title;
    }
    

    
    /**
     * This method permit to add a choice to the menu
     * @see MenuItems
     * @param choice
>>>>>>> correction
     */
    public void addChoice(MenuItems choice){
        this.choices.add(this.choices.size() - 1,new MenuItems(choice.description,this.choices.size() - 1));
    }
    
    
	/**
	 * <p>This function is call inside getChoice and return the index of the MenuItems</p>
	 * 
	 * @return index
	 */
    protected int afficherMenu(){
        System.out.printf("---------- %s -------------\n",this.title);
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

     * <p>This method print the menu (call of afficherMenu)</p>
     * <p>It manage error (index enter by user out of range) </p>
     * 
     * <p>If the items have a special value, it return it instead of his index</p>
     * @see MenuItems
     * @return index(int)
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
