package ConstructionTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by dreaminteam on 7.8.14.
 */
public class ConstructionTreeTest {

    ConstructionTree cT;

    @Before
    public void init() {
        cT = new ConstructionTree();
    }

    @Test
    public void NodeNumber() {

        Node n0 = cT.constructor(cT.arrayToList(o), 0);
        n0.sumNumber();
        assertTrue(n0.getsN().size() == 1);
        n0.setsN();

        Node n = cT.constructor(cT.arrayToList(a), 0);
        n.sumNumber();
        assertTrue(n.getsN().size() == 6);
        n.setsN();

        Node r = cT.constructor(cT.arrayToList(b), 0);
        r.sumNumber();
        assertTrue(r.getsN().size() == 7);
        r.setsN();

        Node k = cT.constructor(cT.arrayToList(c), 0);
        k.sumNumber();
        assertTrue(k.getsN().size() == 8);
        k.setsN();

    }

    String[] o = {"[", "]"};
    String[] a = {"[", "1", "[", "2", "3", "]", "4", "[", "5", "[", "6", "7", "[", "1", "]", "]", "]", "[", "8", "]", "]"};
    String[] b = {"[", "[", "1", "[", "2", "3", "]", "4", "[", "5", "[", "6", "7", "[", "1", "]", "]", "]", "[", "8", "]", "]", "11", "]"};
    String[] c = {"[", "4", "5", "[", "[", "1", "[", "2", "3", "]", "4", "[", "5", "[", "6", "7", "[", "1", "]", "]", "]", "[", "8", "]", "]", "7", "]", "]"};
    String[] d = {"[", "[", "]"};

}
