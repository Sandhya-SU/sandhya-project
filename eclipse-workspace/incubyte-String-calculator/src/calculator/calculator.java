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
			if (text.matches("//(.*)\n(.*)")) {
				String sep = Character.toString(text.charAt(2));
				if(sep.contentEquals("[")){
					delimiter = text.substring(3, text.indexOf("]"));
					
					
					
					delimiter = text.substring(3, text.indexOf("]"));
					text = text.substring(text.indexOf("]")+1);
				}else {
					delimiter = text.substring(2, text.indexOf("\n"));
					text = text.substring(text.indexOf("\n"+1));
				}
//				delimiter = Character.toString(text.charAt(2));
//				text = text.substring(4);
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
			if(number.isEmpty()) {
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
