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
public enum Vetement {
    SHORT,
    JUPE,
    CHEMISE,
    LUNETTES;

    public static Vetement createInterface(){
        Vetement v = null;
        Menu menuVetement = new Menu();
        menuVetement.addChoice(new MenuItems("Short"));
        menuVetement.addChoice(new MenuItems("Jupe"));
        menuVetement.addChoice(new MenuItems("Chemise"));
        menuVetement.addChoice(new MenuItems("Lunettes"));
        switch (menuVetement.getChoice()) {
            case 0:
                v = Vetement.SHORT;
                break;
            case 1:
                v = Vetement.JUPE;
                break;
            case 2:
                v = Vetement.CHEMISE;
                break;
            case 3:
                v = Vetement.LUNETTES;
                break;
            default:
                break;
        }
        return v;
        
    }
}
