/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Cette classe permet de lire les données des différents fichiers: </b>
 * <ul><li>nomFamille.txt</li>
 * <li>pays.txt</li>
 * <li>prenomFeminin.txt</li>
 * <li>prenomMasculin.txt</li>
 * <li>sponsor.txt</li>
 * <li>villeNaissance.txt</li></ul>
 * @author Nicolas
 * @since 21/11/2019
 */
public abstract class FileData {
    private static File path = new File(""); // C:\Users\Nicolas\Documents\NetBeansProjects\Projet_Tennis
    
    /**
     * Cette méthode permet de sélectionner et renvoyer les données du fichier que l'on veut lire.
     * @param data
     * @return ArrayList
     */
    public static ArrayList <String> getData(String data){
        try {
            return getDataFromFile(data);
        } 
        catch (IOException ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Cette méthode lit et renvoie les données du fichier sélectionné.
     * @param data
     * @return ArrayList
     * @throws IOException 
     */
    private static ArrayList <String> getDataFromFile(String data) throws IOException{
        ArrayList <String> arrayList = new ArrayList <String> (20);
        
        BufferedReader file = new BufferedReader(new FileReader(path.getAbsoluteFile()+"/data/"+data+".txt"));
        String line;
        
        while ((line = file.readLine()) != null){
            arrayList.add(line);
        }
        file.close();
     
        return arrayList;
    }
}
