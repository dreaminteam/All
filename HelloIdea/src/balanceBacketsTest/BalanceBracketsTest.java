package balanceBacketsTest;

import java.io.FileNotFoundException;
import java.util.*;


/**
 * Created by dreaminteam on 4.8.14.
 */
public class BalanceBracketsTest {

 /*   public static void main(String[] args) throws FileNotFoundException{
        TestRunner runner=new TestRunner();
        TestSuite suite=new TestSuite();
        suite.addTest(new TestClass("balanseTestTrue"));
        suite.addTest(new TestClass("balanseTestFalse"));
        runner.doRun(suite);
    }
    */

    public boolean balanceTest(String str)  {

        Stack<Character> staff = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char br = str.charAt(i);
            if (br == '(') {
                staff.push(br);
            } else if (br==')'){
                if (!staff.empty()) {
                    staff.pop();
                } else {
                    return false;
                }
            }
        }
        if (!staff.empty()){
            return false;
        } else {
            return true;
        }
    }

  /*  public String initFile(String path) throws FileNotFoundException{

        Scanner scanner = new Scanner(new File(path));
        String str="";
        while (scanner.hasNext()){
            String nL=scanner.nextLine();
            str+=nL;
            System.out.println(nL);
        }
        return str;
    }*/
}
