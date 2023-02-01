package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	public static void main(String[] args) throws IOException {
		// Création d'une HashMap pour stocker les noms de maladies en tant que clés et leur nombre d'occurrences en tant que valeurs
		Map<String, Integer> diseaseCount = readDiseaseFile();

		// Création d'une liste pour stocker les noms de maladies
		List<String> diseases = new ArrayList<>(diseaseCount.keySet());
		// Tri de la liste des noms de maladies dans l'ordre alphabétique
		Collections.sort(diseases);

		// Écrit les résultats dans un fichier
		writeSortedDiseases(diseases, diseaseCount);

		// Affiche les résultats à l'écran
		displayResults(diseases, diseaseCount);
	}

	private static Map<String, Integer> readDiseaseFile() throws IOException {
		Map<String, Integer> diseaseCount = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\serha\\Desktop\\\\DEVELOPPEUR JAVA\\\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\\\symptoms.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				diseaseCount.put(line, diseaseCount.getOrDefault(line, 0) + 1);
			}
		}

		return diseaseCount;
	}

	private static void writeSortedDiseases(List<String> diseases, Map<String, Integer> diseaseCount) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.out"))) {
			for (String disease : diseases) {
				writer.write(disease + " : " + diseaseCount.get(disease));
				writer.newLine();
			}
		}
	}

	private static void displayResults(List<String> diseases, Map<String, Integer> diseaseCount) {
		for (String disease : diseases) {
			System.out.println(disease + " : " + diseaseCount.get(disease));
		}
	}
}
