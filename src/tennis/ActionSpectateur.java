/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 * 10/11/2019
 * @author Nicolas
 */
public interface ActionSpectateur {
    
    public default void applaudir(){
        System.out.println("CLAP CLAP CLAP");
    }
    public default void crier(){
        System.out.println("ALLEZ !!!");
    }
    public default void huer(){
        System.out.println("BOOOOOOOOOOO !!!! NUL !");
    }
    public default void dormir(){
        System.out.println("ZzZzZzZzZzZzZ");
    }
}





