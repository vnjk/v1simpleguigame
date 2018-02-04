public class HiLo extends IGame{

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

    public int getMaxVal(){
        return maxVal;
    }

    public int getTries(){ return tries; }

}
