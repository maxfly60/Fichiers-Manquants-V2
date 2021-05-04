/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombre_de_fichier.verifMoisDernierEtDebutMois;

import java.io.*;
import java.util.*;
import nombre_de_fichier.config;
import nombre_de_fichier.verifMoisDernierEtDebutMois.debutMois.debutMoisCreerListe;
import nombre_de_fichier.verifMoisDernierEtDebutMois.debutMois.debutMoisGenererDate;
import nombre_de_fichier.verifMoisDernierEtDebutMois.debutMois.debutMoisNombreFichiers;
import static nombre_de_fichier.verifMoisDernierEtDebutMois.verifMoisDernier.liste1Mois;
/**
 *
 * @author Max
 */
public class verifDebutMois {
    
    static String chemin = config.chemin;
    public static Calendar calendar = new GregorianCalendar();
    
    static int anneeActuelle = debutMoisGenererDate.genererAnnee();
    static int moisActuel = debutMoisGenererDate.genererMois();
    static int jourActuel = debutMoisGenererDate.genererJour();
    
    static List<String> listeAnnee = debutMoisCreerListe.filtreAnnee(chemin, anneeActuelle);
    static List<String> listeMois = debutMoisCreerListe.filtreMois(chemin, moisActuel);
    static List<String> liste1Mois = debutMoisCreerListe.liste1Mois(listeAnnee, listeMois);
    
    static List<String> listeTheorique = debutMoisCreerListe.creerListeTheorique(anneeActuelle, moisActuel, jourActuel);
    static List<String> listeFinale = debutMoisCreerListe.creerListeFinale(liste1Mois, listeTheorique);
    
    static int nombreTheorique = debutMoisNombreFichiers.nombreTheorique(listeTheorique);
    static int nombreReel = debutMoisNombreFichiers.nombreReel(liste1Mois);
    
    public static String verifDebutMois(){
        
        StringBuilder sb = new StringBuilder();
            for (String s : listeFinale)
            {
                sb.append(s);
                sb.append(" / ");
            }
        
            return sb.toString();
        /*    
        if (!listeFinale.isEmpty()) {
            System.out.println("Voici la liste des fichiers manquants depuis "
                    + "le début du mois actuel: \n" + listeFinale);  
        } else {
            System.out.println("Il ne manque pas de fichier depuis le début "
                    + "du mois actuel.");
        }*/
        
    }

}
