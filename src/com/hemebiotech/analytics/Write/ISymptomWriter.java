package com.hemebiotech.analytics.Write;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Méthode qui écrit la liste des maladies et de son nombre d'apparitions dans un fichier
     *
     * @param diseases map des maladies et son nombre d'apparitions
     */
    void write(Map<String, Integer> diseases);
}
