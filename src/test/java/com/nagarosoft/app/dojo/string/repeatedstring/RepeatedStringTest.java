package com.nagarosoft.app.dojo.string.repeatedstring;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RepeatedStringTest {

    @Test void whenIsASingleAAndNumberGiveIsTenShouldReturnTen() {
        assertThat(RepeatedString.repeatedString("a", 1000000000000L), is(1000000000000L));
    }

    @Test void whenTheStringDoesNotContainAShouldReturnZero() {
        assertThat(RepeatedString.repeatedString("bbbb", 2), is(0L));
    }

    @Test void whenStringIsEmptyShouldReturnZero() {
        assertThat(RepeatedString.repeatedString("", 10), is(0L));
    }

    @Test void whenTheStringIsNotEmptyShouldReturnTheCountForAs() {
        assertThat(RepeatedString.repeatedString("aba", 10), is(7L));
    }

}
