/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette énumération rescence toute les actions possibles que peut faire un joueur durant un échange.</b>
 * <ul><li>SERVICE_FAUTE</li>
 * <li>SERVICE_LET</li>
 * <li>CORRECT</li>
 * <li>FILET</li>
 * <li>FAUTE</li></ul>
 * @author Nicolas, Clément
 * @since 04/11/2019
 * @see Joueur
 */
public enum Action {
    SERVICE_FAUTE, SERVICE_LET,
    CORRECT, FILET, FAUTE
}
