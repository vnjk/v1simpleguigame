import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HiLoTest {
    MockNumberGenerator mockNumGen = null;
    HiLo game = null;

    @Before
    public void init(){
        mockNumGen = new MockNumberGenerator(250);
        game = new HiLo(mockNumGen);
        game.init();
    }

    @After
    public void teardown(){
        mockNumGen = null;
        game = null;
    }

    @Test
    public void afterInitTriesShouldEqualZero() {
        Assert.assertEquals(game.getTries(), 0);
    }

    @Test
    public void afterAnyGuessTriesShouldIncrement() {
        Integer beforeTries = game.getTries();
        game.verifyGuess(0);
        Integer afterTries = game.getTries();

        Assert.assertTrue(afterTries.equals(beforeTries + 1));
    }

    @Test
    public void guessingCorrectNumberShouldReturnCorrect() {
        Assert.assertEquals(game.verifyGuess(250), GuessType.CORRECT);
    }

    @Test
    public void guessingLowNumberShouldReturnLow() {
        Assert.assertEquals(game.verifyGuess(0), GuessType.LOW);
    }

    @Test
    public void guessingHighNumberShouldReturnHigh() {
        Assert.assertEquals(game.verifyGuess(400), GuessType.HIGH);
    }

    @Test
    public void guessingNumberOutsideOfMaximumRangeShouldBeTooHigh() {
        Assert.assertEquals(game.verifyGuess(700), GuessType.HIGH);
    }
}
