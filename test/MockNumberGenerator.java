public class MockNumberGenerator implements INumberGenerator {

    int mockVal = 0;

    public MockNumberGenerator(int mockVal){
        this.mockVal = mockVal;
    }

    @Override
    public int generateNumber(int unusedVal) {
        return mockVal;
    }



}
