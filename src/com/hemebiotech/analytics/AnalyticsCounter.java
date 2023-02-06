package com.hemebiotech.analytics;

import com.hemebiotech.analytics.impl.CounterImpl;
import com.hemebiotech.analytics.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.impl.WriteSymptomDataToFile;

import java.util.List;
import java.util.Map;

/**
 * Classe qui lit un fichier contenant des noms de maladies et qui écrit dans un nouveau fichier
 * les maladies de façon distinct et son nombre d'apparitions
 */
public class AnalyticsCounter {

    private static final String SYMPTOMS = "C:\\Users\\serha\\Desktop\\\\DEVELOPPEUR JAVA\\\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\\\symptoms.txt";
    private static final String RESULTS = "results.out";

    public static void main(String[] args) {
        //Lit le fichier en entrée et renvoie la liste des maladies
        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(SYMPTOMS);
        List<String> symptoms = readSymptomDataFromFile.getSymptoms();

        //Compte le nombre de maladies et effectue un tri par ordre alphabétique grâce au Treemap
        ICounter counter = new CounterImpl(symptoms);
        Map<String, Integer> stringIntegerMap = counter.countDiseases();

        // Écrit les résultats dans un fichier
        ISymptomWriter writeSymptomDataToFile = new WriteSymptomDataToFile(RESULTS);
        writeSymptomDataToFile.write(stringIntegerMap);

    }
}