/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombre_de_fichier.verifMoisDernierEtDebutMois.moisDernier;

import java.util.List;
import nombre_de_fichier.verifMoisDernierEtDebutMois.verifMoisDernier;

/**
 *
 * @author Max
 */
public class moisDernierNombreFichiers {

    public static int joursDansLeMois(int annee, int mois) {
        int joursDansLeMois = 0;
        if (mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) {
            // Mois à 31 jours.
            joursDansLeMois = 31;
        } else {
            if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
                // Mois à 30 jours.
                joursDansLeMois = 30;
            } else {
                if (mois == 2 && (annee % 400 == 0 || (annee % 4 == 0 && annee % 100 != 0))) {
                    // Mois à 29 jours. (fevrier bissextile)
                    joursDansLeMois = 29;
                } else {
                    // Mois à 28 jours.
                    joursDansLeMois = 28;
                }
            }
        }
        return joursDansLeMois;
    }

    public static int comparaison(List liste1mois, int fichiersTheorique) {
        int nombreFichiersReel;
        nombreFichiersReel = verifMoisDernier.liste1Mois.size();
        return nombreFichiersReel;
    }

    public static int fichiersTheorique(int jourDansLeMois) {
        int fichiersTheorique = 0;
        if (jourDansLeMois == 31) {
            fichiersTheorique = 744;
        } else {
            if (jourDansLeMois == 30) {
                fichiersTheorique = 720;
            } else {
                if (jourDansLeMois == 29) {
                    fichiersTheorique = 696;
                } else {
                    // Mois à 28 jours.
                    fichiersTheorique = 672;
                }
            }
        }
        return fichiersTheorique;
    }
    
}
