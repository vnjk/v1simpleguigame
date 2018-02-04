public class MockNumberGenerator implements INumberGenerator {

    private int mockVal;

    public MockNumberGenerator(int mockVal){
        this.mockVal = mockVal;
    }

    @Override
    public int generateNumber(int unusedVal) {
        return mockVal;
    }
}
