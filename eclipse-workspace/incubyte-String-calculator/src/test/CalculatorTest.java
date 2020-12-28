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
		public void testTwoNumbers(){
			assertEquals(3, calculator.add("1,2"));
		}

}
