/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombre_de_fichier.verifMoisDernierEtDebutMois.moisDernier;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nombre_de_fichier.verifMoisDernierEtDebutMois.verifMoisDernier;

/**
 *
 * @author Max
 */
public class moisDernierCreerListes {

    public static List liste1Mois(List listeAnnee, List listeMois) {
        List<String> liste1Mois;
        liste1Mois = new ArrayList<String>(listeAnnee); // Liste année
        liste1Mois.retainAll(listeMois); // Liste année + mois
        return liste1Mois;
    }

    public static List filtreMois(String chemin, int moisRecherche) {
        // Creates an array in which we will store the names of files and directories
        String[] liste;
        String moisRechercheString;
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File dossier = new File(chemin);
        if (moisRecherche < 10) {
            moisRechercheString = "0" + String.valueOf(moisRecherche);
        } else {
            moisRechercheString = String.valueOf(moisRecherche);
        }
        FilenameFilter filter_mois = new FilenameFilter() {
            @Override
            public boolean accept(File dossier, String name) {
                return name.regionMatches(2, moisRechercheString, 0, 2);
            }
        };
        liste = dossier.list(filter_mois);
        List<String> liste_mois = new ArrayList<String>(Arrays.asList(liste));
        return liste_mois;
    }

    public static List filtreAnnee(String chemin, int anneeRecherche) {
        String[] liste;
        String anneeRechercheString = String.valueOf(anneeRecherche);
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File dossier = new File(chemin);
        FilenameFilter filtreAnnee = new FilenameFilter() {
            @Override
            public boolean accept(File dossier, String name) {
                return name.regionMatches(0, anneeRechercheString, 0, 2);
            }
        };
        liste = dossier.list(filtreAnnee);
        List<String> listeAnnee = new ArrayList<String>(Arrays.asList(liste));
        return listeAnnee;
    }

    public static List creerListeTheorique(int anneeRecherche, int moisRecherche, int jourDansLeMois) {
        List<String> listeTheorique = new ArrayList<String>();
        int jour;
        int heure;
        if (moisRecherche < 10) {
            for (jour = 1; jour < 10; jour++) {
                for (heure = 0; heure < 10; heure++) {
                    listeTheorique.add(anneeRecherche + "0" + moisRecherche + "0" + jour + "0" + heure + ".CSV");
                }
                for (heure = 10; heure < 24; heure++) {
                    listeTheorique.add(anneeRecherche + "0" + moisRecherche + "0" + jour + "" + heure + ".CSV");
                }
            }
            for (jour = 10; jour <= verifMoisDernier.joursDansLeMois; jour++) {
                for (heure = 0; heure < 10; heure++) {
                    listeTheorique.add(anneeRecherche + "0" + moisRecherche + "" + jour + "0" + heure + ".CSV");
                }
                for (heure = 10; heure < 24; heure++) {
                    listeTheorique.add(anneeRecherche + "0" + moisRecherche + "" + jour + "" + heure + ".CSV");
                }
            }
        } else {
            for (jour = 1; jour < 10; jour++) {
                for (heure = 0; heure < 10; heure++) {
                    listeTheorique.add(anneeRecherche + "" + moisRecherche + "0" + jour + "0" + heure + ".CSV");
                }
                for (heure = 10; heure < 24; heure++) {
                    listeTheorique.add(anneeRecherche + "" + moisRecherche + "0" + jour + "" + heure + ".CSV");
                }
            }
            for (jour = 10; jour <= verifMoisDernier.joursDansLeMois; jour++) {
                for (heure = 0; heure < 10; heure++) {
                    listeTheorique.add(anneeRecherche + "" + moisRecherche + "" + jour + "0" + heure + ".CSV");
                }
                for (heure = 10; heure < 24; heure++) {
                    listeTheorique.add(anneeRecherche + "" + moisRecherche + "" + jour + "" + heure + ".CSV");
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
