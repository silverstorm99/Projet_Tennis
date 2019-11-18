package menu;

import java.util.ArrayList;
import java.util.Scanner;

import menu.MenuItems;

public class Menu<T,R> {
    protected ArrayList<MenuItems<T,R>> choices = new ArrayList<MenuItems<T,R>>();
    public Menu(){
        
    }
    public void addChoice(MenuItems<T,R> choice){
        this.choices.add(choice);
    }

    protected void afficherMenu(){
        for (int i = 0; i < this.choices.size(); i++) {
            System.out.printf("%d. %s%n",i, this.choices.get(i).description);
        }
    }

    public String getChoice(){
        Scanner scanner = new Scanner(System.in);
        this.afficherMenu();
        int choice = scanner.nextInt();

        while(choice < 0 || choice > choices.size()){
            this.afficherMenu();
            choice = scanner.nextInt();
        }

        return this.choices.get(choice).valeur;
        
    }
}
