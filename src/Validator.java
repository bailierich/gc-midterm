import java.util.Scanner;

public class Validator {
	public static int getInt(Scanner scnr, String prompt) {
		System.out.print(prompt);
		boolean isValid = scnr.hasNextInt();
		while (!isValid) { // keep looping as long as they enter something invalid
			scnr.nextLine(); // advance the scanner past the bad input
			System.out.println("Oops. That's not a valid number. Please enter a number without decimals.");
			System.out.print(prompt);
			isValid = scnr.hasNextInt();
		}
		int answer = scnr.nextInt();
		scnr.nextLine();
		return answer;
	}
	
	public static boolean getYesOrNo(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String input = scnr.nextLine().toLowerCase();
		boolean isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		while (!isValid) { // keep looping as long as they enter something invalid
			System.out.println("Oops. Please enter yes or no.");
			System.out.print(prompt);
			input = scnr.nextLine().toLowerCase();
			isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		}
		return input.startsWith("y");
	}
	
	public static int getIntAtOrAbove(Scanner scnr, String prompt, int minValue) {
		int input = getInt(scnr, prompt);
		if (input < minValue) {
			// if invalid, just do same thing again
			System.out.println("Oops. The number must be at least " + minValue);
			return getIntAtOrAbove(scnr, prompt, minValue);
		} else {
			// if valid, return the answer
			return input;
		}
	}

	public static String getString(Scanner scnr, String prompt) {
		System.out.print(prompt);
		return scnr.nextLine();
	}
}
