/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import menu.*;

/**
 * <b>Cette énumération détermine si le joueur est droitier ou gaucher.</b>
 * @since 21/10/2019
 * @author Nicolas, Clément
 * @see Joueur
 */
public enum Main {
    DROITE, GAUCHE;
    public static Main createInterface(){
        Main m = Main.DROITE;
        Menu menuMain = new Menu("Votre joueur est ");
        menuMain.addChoice(new MenuItems("Droitier"));
        menuMain.addChoice(new MenuItems("Gaucher"));
        switch (menuMain.getChoice()) {
            case 0:
                m = Main.DROITE;
                break;
            case 1:
                m = Main.GAUCHE;
                break;
            default:
                break;
        }
        return m;
    }
}
