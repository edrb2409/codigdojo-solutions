package com.nagarosoft.app.dojo.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by edrb on 5/13/17.
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testPrintFirstNumber() {
        assertThat(fizzBuzz.limit(1).print(), is("[1]"));
    }

    @Test
    public void testPrintFirstTwoNumbers() {
        assertThat(fizzBuzz.limit(2).print(), is("[1,2]"));
    }

    @Test
    public void testPrintFizzForThreeInSequence() {
        assertThat(fizzBuzz.limit(3).print(), is("[1,2,Fizz]"));
    }

    @Test
    public void testPrintBuzzForFiveInSequence() {
        assertThat(fizzBuzz.limit(5).print(), is("[1,2,Fizz,4,Buzz]"));
    }

    @Test
    public void testPrintFizzBuzzForFifteenInSequence() {
        assertThat(fizzBuzz.limit(15).print(), is("[1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz]"));
    }

}
