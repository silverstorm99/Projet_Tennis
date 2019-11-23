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
 * 21/11/2019
 * @author Nicolas
 * Cette classe permet de lire les données des différents fichiers contenant 
 * chacun les prénoms, noms, pays et sponsors.
 */
public abstract class FileData {
    private static File path = new File(""); // C:\Users\Nicolas\Documents\NetBeansProjects\Projet_Tennis
    
    /**
     * 22/11/2019
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
     * 22/11/2019
     * @param data
     * @return ArrayList
     * @throws IOException 
     */
    private static ArrayList <String> getDataFromFile(String data) throws IOException{
        ArrayList <String> arrayList = new ArrayList <String> (20);
        
        BufferedReader file = new BufferedReader(new FileReader(path.getAbsoluteFile()+"\\src\\data\\"+data+".txt"));
        String line;
        
        while ((line = file.readLine()) != null){
            arrayList.add(line);
        }
        file.close();
     
        return arrayList;
    }
}
