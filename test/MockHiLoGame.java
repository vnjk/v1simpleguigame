public class MockHiLoGame implements IHiLoGame {
    public boolean IsInitialised;
    public GuessType GuessType;
    public int MaxVal;
    public int Tries;

    @Override
    public void init() {
        IsInitialised = true;
    }

    @Override
    public GuessType verifyGuess(int guess) {
        return GuessType;
    }

    @Override
    public int getMaxVal() {
        return MaxVal;
    }

    @Override
    public int getTries() {
        return Tries;
    }
}
