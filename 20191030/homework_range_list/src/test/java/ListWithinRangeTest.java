import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListWithinRangeTest {
private List<Integer> l1;
private List<Integer> l2;
private List<Integer> l3;
private List<Integer> l4;
private ListWithinRange listWithinRange;
    @Before
    public void setUp() throws Exception {
        listWithinRange=new ListWithinRange();
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        l3=new ArrayList<>();
        l1.addAll(Arrays.asList(1,2,3,4,5,6));
        l2.addAll(Arrays.asList(1,2,3,4,5));
        l3.addAll(Arrays.asList(-1,-2,-3,-4,-5));
        l4=new ArrayList<>();

    }
    @Test
    public void shouldReturnTrueWhenFirstInSecond(){
        assertTrue(listWithinRange.isListWithinRange(l2,l1));
    }
    @Test
    public void shouldReturnTrueWhenSecondInFirst(){
        assertTrue(listWithinRange.isListWithinRange(l1,l2));
    }
    @Test
    public void shouldReturnFalseWhenNeitherIsASubsetOfTheOther(){
        assertFalse(listWithinRange.isListWithinRange(l1,l3));
    }
    @Test
    public void shouldReturnTrueWhenNullOrEmpty(){
        assertTrue(listWithinRange.isListWithinRange(l1,l4));
    }
}