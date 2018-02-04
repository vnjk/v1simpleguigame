public interface IHiLoGame {
    void init();

    GuessType verifyGuess(int guess);
    int getMaxVal();
    int getTries();
}
