package com.nagarosoft.app.dojo.fizzbuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by edrb on 5/13/17.
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testPrintFirstNumber() {
        Assert.assertThat(fizzBuzz.limit(1).print(), is("[1]"));
    }

    @Test
    public void testPrintFirstTwoNumbers() {
        Assert.assertThat(fizzBuzz.limit(2).print(), is("[1,2]"));
    }

    @Test
    public void testPrintFizzForThreeInSequence() {
        Assert.assertThat(fizzBuzz.limit(3).print(), is("[1,2,Fizz]"));
    }

    @Test
    public void testPrintBuzzForFiveInSequence() {
        Assert.assertThat(fizzBuzz.limit(5).print(), is("[1,2,Fizz,4,Buzz]"));
    }

    @Test
    public void testPrintFizzBuzzForFifteenInSequence() {
        Assert.assertThat(fizzBuzz.limit(15).print(), is("[1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz]"));
    }

}
