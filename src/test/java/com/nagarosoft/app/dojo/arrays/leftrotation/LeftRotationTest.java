package com.nagarosoft.app.dojo.arrays.leftrotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeftRotationTest {

    LeftRotation leftRotation;

    @BeforeEach
    void init() {
        leftRotation = new LeftRotation();
    }

    @Test
    void testWhenRotationIsANegativeNumberThrowsAnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> leftRotation.rotate(new int[]{1,2}, -1));
    }

    @Test void testWhenRotationIsZeroShouldReturnSameArray() {
        assertThat(leftRotation.rotate(new int[]{1,2}, 0), is(new int[]{1,2}));
    }

    @Test void testWhenRotationIsGraterThanArraySizeShouldReturnArrayRotated() {
        assertThat(leftRotation.rotate(new int[]{1,2}, 3), is(new int[]{2,1}));
    }

    @Test void testWhenRotationIsEqualToTheArraySizeShouldReturnSameArray() {
        assertThat(leftRotation.rotate(new int[]{1,2}, 2), is(new int[]{1,2}));
    }

    @Test void testWhenRotationIsValidShouldReturnRotatedArray() {
        assertThat(leftRotation.rotate(new int[]{1,2,3,4,5}, 4), is(new int[]{5,1,2,3,4}));
    }

}
