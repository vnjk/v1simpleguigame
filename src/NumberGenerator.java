public class NumberGenerator implements INumberGenerator {

    @Override
    public int generateNumber(int maxVal) {
        return (int) (Math.random() * maxVal + 1);
    }
}
