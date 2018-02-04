public class HiLo implements IHiLoGame {

    private int expectedVal;
    private int tries;
    private int maxVal = 500;
    private INumberGenerator numGenerator = null;

    public HiLo(INumberGenerator numGenerator){
        this.numGenerator = numGenerator;
    }

    @Override
    public void init() {
        expectedVal = numGenerator.generateNumber(maxVal);
        tries = 0;
    }

    @Override
    public GuessType verifyGuess(int guess){
        tries++;
        if (guess > expectedVal) {
            return GuessType.HIGH;
        } else if (guess < expectedVal) {
            return GuessType.LOW;
        } else {
            return GuessType.CORRECT;
        }
    }

    @Override
    public int getMaxVal(){
        return maxVal;
    }

    @Override
    public int getTries(){ return tries; }

}
