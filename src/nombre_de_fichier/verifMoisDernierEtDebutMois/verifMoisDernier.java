/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombre_de_fichier.verifMoisDernierEtDebutMois;

import java.io.*;
import java.util.*;
import nombre_de_fichier.Nombre_de_fichier;
import nombre_de_fichier.config;
import nombre_de_fichier.verifMoisDernierEtDebutMois.moisDernier.moisDernierCreerListes;
import nombre_de_fichier.verifMoisDernierEtDebutMois.moisDernier.moisDernierGenererDate;
import nombre_de_fichier.verifMoisDernierEtDebutMois.moisDernier.moisDernierNombreFichiers;

/**
 *
 * @author Max
 */
public class verifMoisDernier {
    
    static String chemin = config.chemin;
    public static Calendar calendar = new GregorianCalendar();
    
    static int anneeActuelle = moisDernierGenererDate.genererAnnee();
    static int moisActuel = moisDernierGenererDate.genererMois();
    static int jourActuel = moisDernierGenererDate.genererJour();
        
    static int moisRecherche= moisDernierGenererDate.genererMoisRecherche(moisActuel);
    static int anneeRecherche = moisDernierGenererDate.genererAnneeRecherche(anneeActuelle, moisRecherche);
    
    public static int joursDansLeMois = moisDernierNombreFichiers.joursDansLeMois(anneeRecherche, moisRecherche);
    static int fichiersTheorique = moisDernierNombreFichiers.fichiersTheorique(joursDansLeMois);
    
    static List<String> listeAnnee = moisDernierCreerListes.filtreAnnee(chemin, anneeRecherche);
    static List<String> listeMois = moisDernierCreerListes.filtreMois(chemin, moisRecherche);
    public static List<String> liste1Mois = moisDernierCreerListes.liste1Mois(listeAnnee, listeMois);
    
    static int nombreFichiersReel = moisDernierNombreFichiers.comparaison(liste1Mois, fichiersTheorique);
    
    static List<String> listeTheorique = moisDernierCreerListes.creerListeTheorique(anneeRecherche, moisRecherche, joursDansLeMois);
    static List<String> listeFinale = moisDernierCreerListes.creerListeFinale(liste1Mois, listeTheorique);
        
   
    public static String verifMoisDernier(){
        
        
                StringBuilder sb = new StringBuilder();
            for (String s : listeFinale)
            {
                sb.append(s);
                sb.append(" / ");
            }
        
            return sb.toString();
        /*
        System.out.println("Aujourd'hui, nous sommes le " + jourActuel + "/" 
                + moisActuel + "/" + anneeActuelle + ".");
       
        System.out.println("Pour le mois dernier (" + moisRecherche + "/" 
                + anneeRecherche +"), il y'a " + nombreFichiersReel + " fichiers sur "
                + fichiersTheorique + ".");
        
        System.out.println("Il manque " + 
                (fichiersTheorique - nombreFichiersReel) + " fichiers.");
        
        if (!listeFinale.isEmpty()) {
            System.out.println("Voici la liste des fichiers manquants : \n" + listeFinale);  
        }*/
    }

    
}
