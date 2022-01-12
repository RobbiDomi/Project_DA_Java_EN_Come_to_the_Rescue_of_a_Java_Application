package com.hemebiotech.analytics;

import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import java.io.*;
import java.util.*;

/**
 * @summary  Counting symptoms and write the result on a file
 *
 */

public class AnalyticsCounter {

	public static void main(String args[])  {

		//retrieving Hashmap's readfile information
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();
		//counting the occurrence of elements
		Map<String, Integer> counter = countSymptoms (symptoms);

		System.out.println(counter);
		writeResult(counter);
	}

	/**
	 * @summary  counting the occurence
	 *
	 */

	public static Map<String, Integer> countSymptoms(List <String> symptoms) {
		// creating hashmap to store the symptoms's occurences
		Map<String, Integer> map = new TreeMap<>();

		for (String symptom : symptoms) {
			//storing the different symptoms and occurrences
			if (map.containsKey(symptom)) {
				map.put(symptom, map.get(symptom) + 1);
				//  the number of symptoms in the map
			} else {
				map.put(symptom, 1);
			}
		}
		return map;

	}

	public static void writeResult(Map<String, Integer> map) {
		/**
		 * @param  FileWriter to create file to load result
		 *
		 */
		try {
			FileWriter fw = new FileWriter("Project02Eclipse/result.out");
			BufferedWriter bw = new BufferedWriter(fw);

			// Scanning the map of string
			for (String symptom : map.keySet()) {
				bw.write(symptom + " : " + map.get(symptom) + "\n");
			}
			bw.close();

		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

}

