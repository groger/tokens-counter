/*
 * CompteurJetons.java
 *
 * Created on 1 octobre 2007, 13:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package compteurjetons2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Compte les jetons d'un fichier.
 * @author michel
 */
public class CompteurJetons  {

    float longueurMoyenne = 4; // longueur moyenne (approximative) des jetons initialis�e � 4
    long fichierOctets = -1;   // longueur du fichier en octets
    int nJetons = 0;           // nombre de jetons trouv�s
    String dernierJeton;       // dernier jeton trouv� pour fin de tracage
    boolean termine = false;   // vrai lorsque termin�
    boolean annule = false;

    /** Creates a new instance of CompteurJetons */
    public CompteurJetons() {
    }

    // Le progr�s est approximatif, surtout si les premiers jetons ne sont pas repr�sentatifs de la longueur moyenne
    public int getProgres() {
        if(termine && ! annule) return 100;
        return Math.max(Math.min((int)((100.0*(double)longueurMoyenne*(double)nJetons/(double)fichierOctets)), 100),0);
    }

    public boolean estTermine() { return termine; }

    /**
     * Compte le nombre de jetons du <b>fichier</b>
     * @fichier fichier source
     * @caller objet qui impl�mente PropertyChangeListener.  L'Objet sera notifi� d�s qu'un nouveau jeton est compt� afin de
     * fournir l'�tat d'avancement du d�compte de jetons.
     */
    public long Compte(File fichier, PropertyChangeListener caller) throws java.io.FileNotFoundException {
        Scanner s = null;
        fichierOctets = fichier.length();
        long l;
        try {
            try {
                s = new Scanner(new BufferedReader(new FileReader(fichier)));
            } catch(java.io.FileNotFoundException e) {
                System.out.println("Fichier "+fichier+" non trouvé");
            }

            l = fichier.length();
            System.out.println("Fichier: "+l);
            while (s.hasNext()) {
                dernierJeton = s.next();
                System.out.println("jeton : "+dernierJeton);
                nJetons++;
                longueurMoyenne = longueurMoyenne + ((float)dernierJeton.length() - longueurMoyenne)/(float)nJetons;
                // notification de l'objet qui doit rapporter le statut d'avancement du compteur
                caller.propertyChange(new PropertyChangeEvent(this,"compteur",null,null));
                try{
                    Thread.sleep(100);
                } catch(InterruptedException ie){
                    // Si interruption
                    System.out.println("CompteurJetons : interruption");
                    throw(ie);
                }
            }
        } catch(InterruptedException ie) {
            // sors de la boucle
            annule = true;
        }   finally {
            if (s != null) {
                s.close();
            }
            termine = true;
            System.out.println("terminé");
        }
        return(nJetons);
    }
}


