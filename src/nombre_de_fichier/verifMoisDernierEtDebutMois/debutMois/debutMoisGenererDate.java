/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombre_de_fichier.verifMoisDernierEtDebutMois.debutMois;

import java.util.Calendar;
import nombre_de_fichier.verifMoisDernierEtDebutMois.verifDebutMois;

/**
 *
 * @author Max
 */
public class debutMoisGenererDate {

    public static int genererAnnee() {
        int annee = verifDebutMois.calendar.get(Calendar.YEAR);
        int annee2Chiffres = annee - 2000;
        return annee2Chiffres;
    }

    public static int genererMois() {
        int mois = verifDebutMois.calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
        int vraiMois = mois + 1;
        return vraiMois;
    }

    public static int genererJour() {
        int jour = verifDebutMois.calendar.get(Calendar.DAY_OF_MONTH);
        return jour;
    }
    
}
