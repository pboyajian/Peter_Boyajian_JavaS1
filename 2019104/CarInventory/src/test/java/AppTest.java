import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.io.InputStream;

import static junit.framework.TestCase.assertTrue;

public class AppTest {
    private InputStream original;

    @Before
    public void setUp() {
        systemOutRule.clearLog();
        original = System.in;
    }


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @After
    public void resetIn() {
        System.setIn(original);
    }

    @Test
    public void shouldPrintWelcomeScreen(){
        //Arrange
        App.welcome();
        String output = systemOutRule.getLog();
        //Add
        assertTrue(output.contains("What would you like to do?"));
        assertTrue(output.contains("Enter a number."));
        assertTrue(output.contains("1. Add"));
        assertTrue(output.contains("2. Delete"));
        assertTrue(output.contains("3. List"));
        assertTrue(output.contains("4. Search"));
        //Assert

    }

}