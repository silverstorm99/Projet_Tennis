/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * <b>Cette énumération permet de catégoriser le type de match et/ou le type de tournoi: </b>
 * <ul><li>SIMPLE_HOMME</li>
 * <li>DOUBLE_HOMME</li>
 * <li>SIMPLE_FEMME</li>
 * <li>DOUBLE_FEMME</li>
 * <li>SIMPLE_MIXTE</li>
 * <li>DOUBLE_MIXTE</li></ul>
 * @since 25/10/2019
 * @author Nicolas
 * @see Match
 * @see Tournoi
 */
public enum Categorie {
    SIMPLE_HOMME, DOUBLE_HOMME,
    SIMPLE_FEMME, DOUBLE_FEMME,
    SIMPLE_MIXTE, DOUBLE_MIXTE;
}
