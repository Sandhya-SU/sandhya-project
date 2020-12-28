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
		for (String number : numbers) {
			total += toInt(number);
		}

		return total;
	}

}
