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

	public static Map<String, Integer> readFile() {//Fonction

		File occurence = new File("Project02Eclipse/symptoms.txt");
					// creating hashmap to store the symptoms's occurences
		Map<String, Integer> map = new HashMap<>();
					// creating a BufferReader to read the file symptoms.txt
		/**
		 * @param  BufferedReader to read the symptoms's file.txt
		 *
		 */
		try {
			BufferedReader reader = new BufferedReader(new FileReader(occurence));
			String line = reader.readLine();
			while (line != null) {
					//storing the different symptoms and occurrences
				if (map.containsKey(line)) {
					map.put(line, map.get(line) + 1);
					//implementing the number of symptoms in the map
				} else {
					map.put(line, 1);
				}
					// reading another line on the symptoms's files
				line = reader.readLine();
			}
					// closing the BufferReader
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
		/**
		 * @return returning the map/symptoms for use in other functions
		 *
		 */


	}
	/**
	 * @summary  priting the result
	 *
	 */
	public static void main(String args[])  {
				//retrieving Hashmap's readfile information
		Map<String, Integer> map = readFile();
				//displaying the occurrence of elements
		System.out.println(map);
		writeResult(map);
	}
}

