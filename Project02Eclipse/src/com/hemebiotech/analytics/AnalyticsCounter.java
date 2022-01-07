package com.hemebiotech.analytics;

import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import java.io.*;
import java.util.*;


public class AnalyticsCounter {

	/**
	 * @summary  writing fontion the symptoms's occurences
	 *
	 */

	public static void writeResult(Map<String, Integer> map) {
		// TODO write to the result.txt map
	   /**
	    * @param  FileWriter to create file to load result
	    *
	    */
		try {
			FileWriter fw = new FileWriter("Project02Eclipse/result.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			// parcourir la map de String
			for (String symptom : map.keySet()) {
				bw.write(symptom + " : " + map.get(symptom) + "\n");
			}
			bw.close();
		/**
		* @return storing symptoms's occurences
		*
		*/

		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	/**
	 * @summary  creating the function to count symptoms's occurrences
	 *
	 */

	public static Map<String, Integer> countSymptoms(List <String> symptoms) {//Fonction
		// creating hashmap to store the symptoms's occurences
		Map<String, Integer> map = new HashMap<>();

		/**
		 * @param  BufferedReader to read the symptoms's file.txt
		 *
		 */
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
	/**
	 * @summary  priting the result
	 *
	 */
	public static void main(String args[])  {
				//retrieving Hashmap's readfile information
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();
				//displaying the occurrence of elements
		Map<String, Integer> counter = countSymptoms (symptoms);

		System.out.println(counter);
		writeResult(counter);
	}
}

