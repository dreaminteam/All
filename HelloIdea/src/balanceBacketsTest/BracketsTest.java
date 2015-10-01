package balanceBacketsTest;

import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by dreaminteam on 5.8.14.
 */
public class BracketsTest {

    BalanceBracketsTest bBt;
    @Before
    public void init(){
        bBt=new BalanceBracketsTest();
    }

    @Test
    public void balanseTestTrue() throws FileNotFoundException {
        assertTrue(bBt.balanceTest("..(..)..(.(.(..).)....)"));
        assertTrue(bBt.balanceTest(""));
    }

    @Test
    public void balanseTestFalse() throws FileNotFoundException{
        assertFalse(bBt.balanceTest("..(..)..(..(..)..)..(..(.."));
        assertFalse(bBt.balanceTest("..(..)..(..(..)..)..).)..."));
    }
}
