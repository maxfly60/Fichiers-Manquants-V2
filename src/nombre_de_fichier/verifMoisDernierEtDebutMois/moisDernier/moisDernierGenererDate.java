/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombre_de_fichier.verifMoisDernierEtDebutMois.moisDernier;

import java.util.Calendar;
import nombre_de_fichier.verifMoisDernierEtDebutMois.*;

/**
 *
 * @author Max
 */
public class moisDernierGenererDate {

    public static int genererAnneeRecherche(int anneeActuelle, int moisActuel) {
        int anneeRecherche;
        if (moisActuel == 12) {
            anneeRecherche = anneeActuelle - 1;
        } else {
            anneeRecherche = anneeActuelle;
        }
        return anneeRecherche;
    }

    public static int genererAnnee() {
        int annee = verifMoisDernier.calendar.get(Calendar.YEAR);
        int annee2Chiffres = annee - 2000;
        return annee2Chiffres;
    }

    public static int genererJour() {
        int jour = verifMoisDernier.calendar.get(Calendar.DAY_OF_MONTH);
        return jour;
    }

    public static int genererMois() {
        int mois = verifMoisDernier.calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
        int vraiMois = mois + 1;
        return vraiMois;
    }

    public static int genererMoisRecherche(int moisActuel) {
        int moisRecherche;
        if (moisActuel == 1) {
            moisRecherche = 12;
        } else {
            moisRecherche = moisActuel - 1;
        }
        return moisRecherche;
    }
    
}
