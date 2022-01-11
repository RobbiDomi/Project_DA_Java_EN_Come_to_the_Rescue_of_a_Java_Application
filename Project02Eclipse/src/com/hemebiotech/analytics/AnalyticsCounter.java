package com.hemebiotech.analytics;

import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import java.io.*;
import java.util.*;

/**
 * @summary  creating the function to count symptoms's occurrences
 *
 */

public class AnalyticsCounter {

	/**
	 * @summary  writing fontion the symptoms's occurences
	 *
	 */

	public static Map<String, Integer> countSymptoms(List <String> symptoms) {//Fonction
		// creating hashmap to store the symptoms's occurences
		Map<String, Integer> map = new TreeMap<>();

		for (String symptom : symptoms) {
			//storing the different symptoms and occurrences
			if (map.containsKey(symptom)) {
				map.put(symptom, map.get(symptom) + 1);
				//implementing the number of symptoms in the map
			} else {
				map.put(symptom, 1);
			}
		}
		return map;

	}

	public static void writeResult(Map<String, Integer> map) {//Fonction
		// TODO write to the result.out map
		/**
		 * @param  FileWriter to create file to load result
		 *
		 */
		try {
			FileWriter fw = new FileWriter("Project02Eclipse/result.out");
			BufferedWriter bw = new BufferedWriter(fw);

			// parcourir la map de String
			for (String symptom : map.keySet()) {
				bw.write(symptom + " : " + map.get(symptom) + "\n");
			}
			bw.close();

		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	/**
	 * @summary  priting the result
	 *
	 */
	public static void main(String args[])  {//Fonction

				//retrieving Hashmap's readfile information
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();
				//displaying the occurrence of elements
		Map<String, Integer> counter = countSymptoms (symptoms);

		System.out.println(counter);
		writeResult(counter);


	}
}

