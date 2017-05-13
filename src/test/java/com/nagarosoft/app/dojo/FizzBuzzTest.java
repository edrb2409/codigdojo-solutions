package com.nagarosoft.app.dojo;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by edrb on 5/12/17.
 */
public class FizzBuzzTest {

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

}
