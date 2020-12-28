/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.calculator;

/**
 * @author sandhya
 *
 */
public class CalculatorTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.calculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, calculator.add("1,2"));
	}

	@Test
	public void testThreeNumbers() {
		assertEquals(6, calculator.add("1,2,3"));
	}

	@Test
	public void testNewLine() {
		assertEquals(6, calculator.add("1\n2,3"));
	}

	@Test
	public void testNewLine1() {
		assertEquals(1, calculator.add("1,\n"));
	}

	@Test
	public void testOtherDelimiter() {
		assertEquals(3, calculator.add("//;\n1;2"));
	}

	@Test
    public void testNegativeNumver(){
    	try {
			calculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			calculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }
	
	@Test
    public void testOverThousand(){
    	assertEquals(2, calculator.add("1001,2"));
    }

}
