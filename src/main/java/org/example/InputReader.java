package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;

public class InputReader {

	private BufferedReader reader;

	public InputReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public List<String> getInput() {
		System.out.print("> ");
		String inputLine = readInputLine().trim().toLowerCase();

		// Split the input line into words and store them in a List
		List<String> words = Arrays.asList(inputLine.split(" "));
		return words;
	}

	private String readInputLine() {
		String line = "";
		try {
			line = reader.readLine();
		} catch (java.io.IOException exc) {
			System.out.println("There was an error during reading: " + exc.getMessage());
		}
		return line;
	}
}
