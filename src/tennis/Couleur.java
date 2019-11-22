/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import menu.*;

/**
 * 21/10/2019
 * @author Nicolas
 */
public enum Couleur {
    BLEU, ROUGE;
    public static Couleur createInterface(){
        Couleur c = Couleur.BLEU;
        Menu menuCouleur = new Menu();
        menuCouleur.addChoice(new MenuItems("Bleu"));
        menuCouleur.addChoice(new MenuItems("Rouge"));
        switch (menuCouleur.getChoice()) {
            case 0:
                c = Couleur.BLEU;
                break;
            case 1:
                c = Couleur.ROUGE;
                break;
            default:
                break;
        }
        return c;
    }
}
