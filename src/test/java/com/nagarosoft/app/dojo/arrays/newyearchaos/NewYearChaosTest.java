package com.nagarosoft.app.dojo.arrays.newyearchaos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewYearChaosTest {

    NewYearChaos newYearChaos;

    @BeforeEach void init() {
        newYearChaos = new NewYearChaos();
    }

    @Test void testWhenTheArrayHasNoBribes() {
        assertThat(newYearChaos.minimumBribes(new int[]{1, 2, 3, 4}), is("0"));
    }

    @Test void testWhenTheArrayHasOneBribeShouldReturnOne() {
        assertThat(newYearChaos.minimumBribes(new int[]{1, 2, 4, 3}), is("1"));
    }

    @Test void testWhenTheArrayHasMultipleValidBridesShouldReturnTwo() {
        assertThat(newYearChaos.minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}), is("7"));
    }

    @Test void testWhenTheArrayHasMultipleInvalidBridesShouldReturnTooChaotic() {
        assertThat(newYearChaos.minimumBribes(new int[]{2, 5, 1, 3, 4}), is("Too chaotic"));
    }

}
