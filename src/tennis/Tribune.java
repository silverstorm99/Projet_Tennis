/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette énumération répertorie les tribunes dans un stade.</b>
 * <ul><li>N</li>
 * <li>S</li>
 * <li>E</li>
 * <li>O</li>
 * <li>NE</li>
 * <li>NO</li>
 * <li>SE</li>
 * <li>SO</li></ul>
 * @since 21/10/2109
 * @author Nicolas
 * @see Billet
 */
public enum Tribune {
    N, S, E, O, // Nord, Sud, Est, Ouest
    NE, NO, SE, SO; // Nord-Est, Nord-Ouest, Sud-Est, Sud-Ouest
}
