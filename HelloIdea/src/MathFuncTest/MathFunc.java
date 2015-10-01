package MathFuncTest;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Created by dreaminteam on 5.8.14.
 */
public class MathFunc {
    private int variable;

    public MathFunc() {
        variable = 0;
    }
    public MathFunc(int var) {
        variable = var;
    }

    public int getVariable() {
        return variable;
    }
    public void setVariable(int variable) {
        this.variable = variable;
    }

    public long factorial() {
        long result = 1;
        if (variable > 1) {
            for (int i=1; i<=variable; i++)
                result = result*i;
        }
        return result;
    }

    public long plus(int var) {
        long result = variable + var;
        return result;
    }
    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        TestSuite suite = new TestSuite();
        suite.addTest(new TestClass("testFactorialNull"));
        suite.addTest(new TestClass("testFactorialPositive"));
        suite.addTest(new TestClass("testPlus"));
        suite.addTest(new TestClass("testFactorialNegotive"));
        runner.doRun(suite);
    }
}
