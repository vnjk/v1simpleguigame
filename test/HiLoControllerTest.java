import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HiLoControllerTest {
    private HiLoController hiLoController;
    private MockHiLoGame mockHiLoGame;

    @Before
    public void init() {
        mockHiLoGame = new MockHiLoGame();
        hiLoController = new HiLoController(mockHiLoGame);
    }

    @After
    public void teardown() {
        mockHiLoGame = null;
        hiLoController = null;
    }

    @Test
    public void init_CallsInitOnGame() {
        hiLoController.init();

        Assert.assertTrue(mockHiLoGame.IsInitialised);
    }

    @Test
    public void guess_WhenCorrectSetsGameStatusToFinished() {
        mockHiLoGame.GuessType = GuessType.CORRECT;
        hiLoController.guess(0);

        Assert.assertEquals(hiLoController.getGameStatus(), GameStatusType.FINISHED);
    }

    @Test
    public void guess_WhenHighSetsGameStatusToPlaying() {
        mockHiLoGame.GuessType = GuessType.HIGH;
        hiLoController.guess(0);

        Assert.assertEquals(hiLoController.getGameStatus(), GameStatusType.PLAYING);
    }

    @Test
    public void guess_WhenLowSetsGameStatusToPlaying() {
        mockHiLoGame.GuessType = GuessType.LOW;
        hiLoController.guess(0);

        Assert.assertEquals(hiLoController.getGameStatus(), GameStatusType.PLAYING);
    }

    @Test
    public void getMaxVal_ShouldReturnGamesMaxVal() {
        mockHiLoGame.MaxVal = 255;

        Assert.assertEquals(hiLoController.getMaxVal(), 255);
    }

    @Test
    public void getTries_ShouldReturnGamesTries() {
        mockHiLoGame.Tries = 10;

        Assert.assertEquals(hiLoController.getTries(), 10);
    }
}
