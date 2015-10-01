package dit.dreaminteam;

import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by dreaminteam on 27.2.15.
 */
public class Project2Test extends TestSuite {

    private final String foulderTest = "test/";
    private final Set<String> nameTestJsonFiles = new HashSet<>();

    @Before
    public void setFileJsonData() {
        nameTestJsonFiles.add(foulderTest + "Test1.json");
        nameTestJsonFiles.add(foulderTest + "Test2.json");
        nameTestJsonFiles.add(foulderTest + "Test3.json");
        nameTestJsonFiles.add(foulderTest + "Test4.json");
    }

    @After
    public void clearNameTestJsonData() {
        nameTestJsonFiles.clear();
    }

    @Test
    public void testProject2() {
        for (String name : nameTestJsonFiles) {

        }
    }
}

