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
public enum Main {
    DROITE, GAUCHE;
    public static Main createInterface(){
        Main m = Main.DROITE;
        Menu menuMain = new Menu();
        menuMain.addChoice(new MenuItems("Droite"));
        menuMain.addChoice(new MenuItems("Gauche"));
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
