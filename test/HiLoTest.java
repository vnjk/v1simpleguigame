import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HiLoTest {


    MockNumberGenerator mockNumGen = null;
    HiLo game = null;

    @Before
    public void init(){
        mockNumGen = new MockNumberGenerator(500);
        game = new HiLo(mockNumGen);
    }
    @Test
    public void correctAnswer(){
        //input stream?


    }

    @After
    public void teardown(){
        mockNumGen = null;
        game = null;
    }


}
