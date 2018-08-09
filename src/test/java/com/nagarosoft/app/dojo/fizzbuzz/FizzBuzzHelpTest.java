package com.nagarosoft.app.dojo.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by edrb on 5/12/17.
 */
public class FizzBuzzHelpTest {

    @Test
    public void shouldPrintTheNumberIfNumberIsNotMultipleOfThreeNeitherFive(){
        assertThat(FizzBuzz.Helper.convert(1), is("1"));
    }

    @Test
    public void shouldReturnFizzIfNumberIsMultipleOfThree() {
        assertThat(FizzBuzz.Helper.convert(6), is("Fizz"));
    }

    @Test
    public void shouldReturnBuzzIfNumberIsMultipleOfFive() {
        assertThat(FizzBuzz.Helper.convert(10), is("Buzz"));
    }

    @Test
    public void shouldReturnFizzBuzzIfNumberIsMultipleOfFiveANDThree() {
        assertThat(FizzBuzz.Helper.convert(15), is("FizzBuzz"));
    }

    @Test
    public void shouldReturnZeroIfNumberIsZero() {
        assertThat(FizzBuzz.Helper.convert(0), is("0"));
    }

}
