package com.hemebiotech.analytics;

import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import java.io.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		Path path = Paths.get(System.getProperty("user.dir"))
				.resolve("Project02Eclipse/symptoms.txt");

		Map<String, Integer> map = new HashMap<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
			String line = reader.readLine();
			while (line != null) {
				if (map.containsKey(line)) {
					map.put(line, map.get(line) + 1);
				} else {
					map.put(line, 1);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(map);
	}
	}

