/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;
import menu.*;

/**
 * <b>Cette énumération rescence les vêtements que pourront porter les joueurs et les spectateurs.</b>
 * <ul><li>SHORT</li>
 * <li>JUPE</li>
 * <li>CHEMISE</li>
 * <li>LUNETTES</li></ul>
 * @since 21/10/2019
 * @author Nicolas, Clément
 * @see Joueur
 * @see Spectateur
 */
public enum Vetement {
    SHORT,
    JUPE,
    CHEMISE,
    LUNETTES;

    /**
     * @return Vetement
     */
    public static Vetement createInterface(){
        Vetement v = null;
        Menu menuVetement = new Menu("Il porte :");
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
