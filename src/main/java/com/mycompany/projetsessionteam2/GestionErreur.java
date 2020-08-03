
package com.mycompany.projetsessionteam2;

import java.io.File;

/**
 *
 * @author RB
 */
public class GestionErreur {
    
     public static void verifierCreationFichierSortie(File file){
    
    if(!file.exists()){
        System.out.println("Le fichier de sortie n'a pas été crée! ");
        System.exit(0);
    }
   }
    
}
