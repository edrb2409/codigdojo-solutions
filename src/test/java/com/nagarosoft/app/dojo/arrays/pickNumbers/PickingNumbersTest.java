package com.nagarosoft.app.dojo.arrays.pickNumbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PickingNumbersTest {

    @Test void shouldReturnOneIfListHasOneElement() {
        assertEquals(1, PickingNumbers.pickingNumbers(Arrays.asList(1)));
    }

    @Test void shouldReturnTwoIfListHasTwoElementsAndDiffBetweenBothIsLowerThanOne() {
        assertEquals(2, PickingNumbers.pickingNumbers(Arrays.asList(1,2)));
    }

    @Test void shouldReturnTwoIfListHasMaximumTwoNumbersWithDiffLowerThanOne() {
        assertEquals(2, PickingNumbers.pickingNumbers(Arrays.asList(4,1,2)));
    }

    @Test void shouldReturnZeroIfListDoesNotHaveNumbersWithDiffLowerThaOne() {
        assertEquals(0, PickingNumbers.pickingNumbers(Arrays.asList(4,2,6)));
    }

    @Test void shouldReturnTheMaximunIfListHaveNumbersWithDiffLowerThaOne() {
        assertEquals(3, PickingNumbers.pickingNumbers(Arrays.asList(4,6,5,3,3,1)));
    }

    @Test void shouldReturnTheMaximunIfListHaveNumbersWithDiffLowerThaOne2() {
        assertEquals(22, PickingNumbers.pickingNumbers(Arrays.asList(4,2,3,4,4,9,98,98,3,3,3,4,2,98,1,98,98,1,1,4,98,2,98,3,9,9,3,1,4,1,98,9,9,2,9,4,2,2,9,98,4,98,1,3,4,9,1,98,98,4,2,3,98,98,1,99,9,98,98,3,98,98,4,98,2,98,4,2,1,1,9,2,4)));
    }
}
