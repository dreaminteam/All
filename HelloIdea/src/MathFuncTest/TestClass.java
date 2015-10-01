package MathFuncTest;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import org.junit.Test;

/**
 * Created by dreaminteam on 5.8.14.
 */
public class TestClass extends TestCase {

    public TestClass(String testName) {
        super(testName);
    }
    @Test
    public void testFactorialNull() {
        MathFunc math = new MathFunc();
        assertTrue(math.factorial() == 1);
    }
    @Test
    public void testFactorialPositive() {
        MathFunc math = new MathFunc(5);
        assertTrue(math.factorial() == 120);
    }
    @Test
    public void testPlus() {
        MathFunc math = new MathFunc(45);
        assertTrue(math.plus(123) == 168);
    }
    @Test
    public void testFactorialNegotive(){
        MathFunc math=new MathFunc(-4);
        assertTrue(math.factorial()==0);
    }
}
