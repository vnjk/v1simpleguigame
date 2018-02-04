import java.io.BufferedReader;
import java.util.Scanner;

public class HiLoController {

    private IHiLoGame game = null;
    private GameStatusType gameStatus = null;
    private GuessType guessStatus = null;
    private int latestGuess = 0;




    public HiLoController(IHiLoGame game){
        this.game = game;
        gameStatus = GameStatusType.STARTED;
    }

    public void init(){
        game.init();
    }

    public void guess(int value) {
        latestGuess = value;
        guessStatus = game.verifyGuess(value);
        if (guessStatus.equals(GuessType.CORRECT)) {
            gameStatus = GameStatusType.FINISHED;
        } else {
            gameStatus = GameStatusType.PLAYING;
        }
    }

    public GameStatusType getGameStatus() {
        return gameStatus;
    }

    public GuessType getGuessStatus() {
        return guessStatus;
    }

    public int getLatestGuess() {
        return latestGuess;
    }

    public int getMaxVal(){
        int maxVal = game.getMaxVal();
        return maxVal;
    }

    public int getTries(){
        return game.getTries();
    }

    public boolean playAgain(String response) {
        return response.equalsIgnoreCase("y");
    }





}
