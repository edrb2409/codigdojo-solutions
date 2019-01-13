package com.nagarosoft.app.dojo.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmoothieTest {

    @Test void classicSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                Smoothie.ingredients("Classic"));
    }

    @Test void classicSmoothieWithoutStrawberryAndPeanut() {
        assertEquals("banana,honey,mango,peach,pineapple",
                Smoothie.ingredients("Classic,-strawberry,-peanut"));
    }

    @Test void shouldRaiseAnExceptionWhenIsInvalidMenuOption() {
        assertThrows(IllegalArgumentException.class,
                () -> Smoothie.ingredients("Something"));
    }

    @Test void shouldRaiseAnExceptionWhenMessageIsInvalidOrLost() {
        assertThrows(IllegalArgumentException.class,
                () -> Smoothie.ingredients(""));
    }

    @Test void shouldRaiseAnExceptionWhenOptionHasAnAdditionalIngredient() {
        assertThrows(IllegalArgumentException.class,
                () -> Smoothie.ingredients("Classic,chocolate"));
    }
}
