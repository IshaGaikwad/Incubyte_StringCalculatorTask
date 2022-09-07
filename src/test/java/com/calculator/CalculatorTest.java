/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ishag
 */
public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
    public void testUnknownNumbers(){
    	assertEquals(25, Calculator.add("1,8,5,3,6,2"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testNegativeNumver(){
    	try {
			Calculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			Calculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }

    @Test
    public void testOverThousand(){
    	assertEquals(997, Calculator.add("995,2"));
    }

    @Test
    public void testOtherDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}