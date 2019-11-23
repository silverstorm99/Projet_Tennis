/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette énumération caractérise la phase (ou l'avencement du macth dans un tournoi). </b>
 * <ul><li>AMICALE</li>
 * <li>FINALE</li>
 * <li>DEMI_FINALE</li>
 * <li>QUART_FINALE</li>
 * <li>HUITIEME_FINALE</li>
 * <li>TROISIEME_TOUR</li>
 * <li>DEUXIEME_TOUR</li>
 * <li>PREMIER_TOUR</li></ul>
 * @since 25/10/2019
 * @author Nicolas
 */
public enum Phase {
    AMICALE, 
    PREMIER_TOUR,
    DEUXIEME_TOUR,
    TROISIEME_TOUR,
    HUITIEME_FINALE,
    QUART_FINALE,
    DEMI_FINALE,
    FINALE;
}
