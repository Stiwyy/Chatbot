package org.example;

import java.util.List;

public class SupportSystem {

	private InputReader reader;
	private Responder responder;

	public SupportSystem() {
		reader = new InputReader();
		responder = new Responder();
	}

	public void start() {
		boolean finished = false;
		printWelcome();

		while (!finished) {
			List<String> inputWords = reader.getInput();

			if (inputWords.contains("bye")) {
				finished = true;
			} else {
				// Pass inputWords directly to generateResponse
				String response = responder.generateResponse(inputWords);
				System.out.println(response);
			}
		}
		printGoodbye();
	}

	private void printWelcome() {
		System.out.println("Welcome to the DodgySoft Technical Support System.");
		System.out.println();
		System.out.println("Please tell us about your problem.");
		System.out.println("We will assist you with any problem you might have.");
		System.out.println("Please type 'bye' to exit our system.");
	}

	private void printGoodbye() {
		System.out.println("Nice talking to you. Bye...");
	}
}
