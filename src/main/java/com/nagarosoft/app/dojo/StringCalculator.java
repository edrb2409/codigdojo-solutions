package com.nagarosoft.app.dojo;

import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

	public static int add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		}
		
		return sumOf(convert(numbers));
	}
	
	private static IntStream convert(String numbers) {
		return Stream.of(tokenize(numbers)).mapToInt(Integer::valueOf);
	}
	
	private static String[] tokenize(String numbers) {
		if(numbers.startsWith("//")) {
			return tokenizeCustomDelimeter(numbers);
		}
		
		return tokenizeDefaultDelimiters(numbers);
	}
	
	private static String[] tokenizeCustomDelimeter(String numbers) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
		matcher.matches();
		return matcher.group(2).split(matcher.group(1));
	}
	
	private static String[] tokenizeDefaultDelimiters(String numbers) {
		return numbers.split(",|\n");
	}
	
	private static int sumOf(IntStream numbersStream) {
		int [] numbers = numbersStream.toArray();
		
		if(hasNegatives(numbers)) {
			throw new RuntimeException("negatives not allowed: " + negativesFound(numbers));
		}
		
		return IntStream.of(numbers).filter(greaterThanOneThousand()).reduce(Integer::sum).getAsInt();
	}

	private static boolean hasNegatives(int[] numbers) {
		return IntStream.of(numbers).anyMatch(n -> n < 0);
	}
	
	private static String negativesFound(int[] numbers) {
		return IntStream.of(numbers).filter(n -> n < 0)
			.mapToObj(String::valueOf).collect(Collectors.joining());
	}
	
	private static IntPredicate greaterThanOneThousand() {
		return n -> n < 1000;
	}


}
