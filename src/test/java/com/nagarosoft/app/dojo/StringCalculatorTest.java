package com.nagarosoft.app.dojo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringCalculatorTest {

	@Test
	public void shouldReturnZeroWhenIsEmptyString() {
		assertThat(StringCalculator.add(""), is(0));
	}
	
	@Test
	public void shouldReturnTheSameNumberWhenNumbersAreOnlyOne() {
		assertThat(StringCalculator.add("1"), is(1));
	}
	
	@Test
	public void shouldAddTwoNumbers() {
		assertThat(StringCalculator.add("1,2"), is(3));
	}
	
	@Test
	public void shouldAddNumbers() {
		assertThat(StringCalculator.add("1,2,7"), is(10));
	}
	
	@Test
	public void shouldSupportNewLinesAsSeparator() {
		assertThat(StringCalculator.add("1\n2,7"), is(10));
	}
	
	@Test
	public void shouldSupportDifferentSeparator() {
		assertThat(StringCalculator.add("//;\n2;7"), is(9));
	}
	
	@Test
	public void shouldNotSupportNegatives() {
		Assertions.assertThrows(RuntimeException.class,
				() -> StringCalculator.add("1,-1"),
				"negatives not allowed: -1");
	}

	@Test
	public void shouldIgnoreNumbersBiggerThan1000() {
		assertThat(StringCalculator.add("1,2,7,10005"), is(10));
	}
	
}
