package com.hemebiotech.analytics.Counter;

import java.util.Map;

public interface ICounter {

    /**
     * Méthode qui compte le nombre de maladies dans l'ordre alphabétique.
     * Retourne une map vide s'il n'y a aucune maladie.
     *
     * @return une map triée de maladies et de son nombre d'apparitions
     */
    Map<String, Integer> countDiseases();

}
