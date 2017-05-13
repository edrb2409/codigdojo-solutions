package com.nagarosoft.app.dojo.bownlingGame;

import com.nagarosoft.app.dojo.bowlingGame.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by edrb on 5/13/17.
 */
public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);
        Assert.assertThat(game.score(), is(0));
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        Assert.assertThat(game.score(), is(20));
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);

        Assert.assertThat(game.score(), is(16));
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(1);
        rollMany(16,0);

        Assert.assertThat(game.score(), is(22));
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);

        Assert.assertThat(game.score(), is(300));
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollMany(int tries, int pins) {
        IntStream.rangeClosed(1, tries).forEach(roll -> game.roll(pins));
    }
}
