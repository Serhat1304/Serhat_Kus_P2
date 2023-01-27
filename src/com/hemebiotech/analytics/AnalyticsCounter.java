package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	private static List<Maladie> list;

	public static void main(String args[]) throws Exception {
		list = new ArrayList<>();
		/*Map<String, Integer> map = new HashMap<>();*/

		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("C:\\Users\\serha\\Desktop\\DEVELOPPEUR JAVA\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt"));
		String line = reader.readLine();

		// counts headaches
		while (line != null) {

			/*if(map.containsKey(line)) {
				map.put(line, map.get(line) + 1);
			} else {
				map.put(line, 1);
			}
*/
			Maladie maladie = new Maladie(line);

			if(!list.contains(maladie)) {
				list.add(maladie);
			} else {
				int indexMaladie = list.indexOf(maladie);
				Maladie maladieInList = list.get(indexMaladie);
				maladieInList.setNbApparitions(maladieInList.getNbApparitions() + 1);
			}


			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");

		list = list.stream().sorted(Comparator.comparing(Maladie::getNom)).collect(Collectors.toList());

		for(Maladie m : list) {
			writer.write(m.getNom() + ": " + m.getNbApparitions() + "\n");
		}


		writer.close();

		System.out.println(list);
	}
}
