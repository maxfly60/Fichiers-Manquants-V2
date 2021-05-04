/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombre_de_fichier.verifMoisDernierEtDebutMois.debutMois;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Max
 */
public class debutMoisCreerListe {

    public static List liste1Mois(List listeAnnee, List listeMois) {
        List<String> liste1Mois;
        liste1Mois = new ArrayList<String>(listeAnnee); // Liste année
        liste1Mois.retainAll(listeMois); // Liste année + mois
        return liste1Mois;
    }

    public static List filtreMois(String chemin, int moisActuel) {
        // Creates an array in which we will store the names of files and directories
        String[] liste;
        String moisActuelString;
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File dossier = new File(chemin);
        if (moisActuel < 10) {
            moisActuelString = "0" + String.valueOf(moisActuel);
        } else {
            moisActuelString = String.valueOf(moisActuel);
        }
        FilenameFilter filter_mois = new FilenameFilter() {
            @Override
            public boolean accept(File dossier, String name) {
                return name.regionMatches(2, moisActuelString, 0, 2);
            }
        };
        liste = dossier.list(filter_mois);
        List<String> liste_mois = new ArrayList<String>(Arrays.asList(liste));
        return liste_mois;
    }

    public static List filtreAnnee(String chemin, int anneeActuelle) {
        String[] liste;
        String anneeActuelleString = String.valueOf(anneeActuelle);
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File dossier = new File(chemin);
        FilenameFilter filtreAnnee = new FilenameFilter() {
            @Override
            public boolean accept(File dossier, String name) {
                return name.regionMatches(0, anneeActuelleString, 0, 2);
            }
        };
        liste = dossier.list(filtreAnnee);
        List<String> listeAnnee = new ArrayList<String>(Arrays.asList(liste));
        return listeAnnee;
    }

    public static List creerListeTheorique(int anneeActuelle, int moisActuel, int jourActuel) {
        List<String> listeTheorique = new ArrayList<String>();
        int jour;
        int heure;
        // A FAIRE
        for (jour = 1; jour < jourActuel; jour++) {
            if (moisActuel < 10) {
                if (jour < 10) {
                    for (heure = 0; heure < 10; heure++) {
                        listeTheorique.add(anneeActuelle + "0" + moisActuel + "0" + jour + "0" + heure + ".CSV");
                    }
                    for (heure = 10; heure < 24; heure++) {
                        listeTheorique.add(anneeActuelle + "0" + moisActuel + "0" + jour + "" + heure + ".CSV");
                    }
                } else {
                    for (heure = 0; heure < 10; heure++) {
                        listeTheorique.add(anneeActuelle + "0" + moisActuel + "" + jour + "0" + heure + ".CSV");
                    }
                    for (heure = 10; heure < 24; heure++) {
                        listeTheorique.add(anneeActuelle + "0" + moisActuel + "" + jour + "" + heure + ".CSV");
                    }
                }
            } else {
                if (jour < 10) {
                    for (heure = 0; heure < 10; heure++) {
                        listeTheorique.add(anneeActuelle + "" + moisActuel + "0" + jour + "0" + heure + ".CSV");
                    }
                    for (heure = 10; heure < 24; heure++) {
                        listeTheorique.add(anneeActuelle + "" + moisActuel + "0" + jour + heure + ".CSV");
                    }
                } else {
                    for (heure = 0; heure < 10; heure++) {
                        listeTheorique.add(anneeActuelle + "" + moisActuel + jour + "0" + heure + ".CSV");
                    }
                    for (heure = 10; heure < 24; heure++) {
                        listeTheorique.add(anneeActuelle + "" + moisActuel + jour + "" + heure + "" + ".CSV");
                    }
                }
            }
        }
        return listeTheorique;
    }

    public static List creerListeFinale(List liste1Mois, List listeTheorique) {
        List<String> listeFinale = new ArrayList<String>(listeTheorique);
        listeFinale.removeAll(liste1Mois);
        return listeFinale;
    }
    
}
