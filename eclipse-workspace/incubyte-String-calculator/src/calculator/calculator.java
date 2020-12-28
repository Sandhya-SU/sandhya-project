/**
 * 
 */
package calculator;

/**
 * @author sandhya
 *
 */
public class calculator {

	public static int add(String text) {
		if (text.equals("")) {
			return 0;
		} else {
			String delimiter = ",";
			if (text.matches("//(.*)\n(.*)")) {// checking for delimiters other than ,
				if (!Character.toString(text.charAt(2)).contentEquals("[")) { // if it doesn't have array of delimiters
																				// then separating the string with the
																				// provide delimiter
					delimiter = text.substring(2, text.indexOf("\n"));
					text = text.substring((text.indexOf("\n") + 1));
				} else {
					delimiter = "";
					int i = 2;
					while (Character.toString(text.charAt(i)).contentEquals("[")) {// checking for multiple delimiter if
																					// exist looping through it
						
						if (i == 2) {// for the first occurrence index of the delimiter will differs so getting the
										// delimiter based on the index value
							delimiter = delimiter.concat(text.substring(3, text.indexOf("]")));
						} else {
							delimiter = delimiter.concat(text.substring(1, text.indexOf("]")));
						}
						text = text.substring(text.indexOf("]") + 1);
						i = 0;
					}
				}
			}
			String numList[] = splitNumbers(text, delimiter + "|\n");
			return sum(numList);
		}
	}

	private static String[] splitNumbers(String numbers, String divider) {
		return numbers.split(divider);
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static int sum(String[] numbers) {
		int total = 0;
		String negString = "";

		for (String number : numbers) {
			if (number.isEmpty()) {
				number = "0";
			}
			if (toInt(number) < 0) {
				if (negString.equals(""))
					negString = number;
				else
					negString += ("," + number);
			}
			if (toInt(number) <= 1000) {
				total += toInt(number);
			}
		}

		if (!negString.equals("")) {
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}
		return total;
	}

}
