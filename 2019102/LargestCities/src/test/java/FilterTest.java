import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class FilterTest {
    public Filter filter=new Filter();
    @Before
    public void setUp() throws Exception{
        Filter filter=new Filter();
    }

    @Test
    public void shouldFilterByPopulation() {
        //Arrange
        City newYork=new City("New York",8654321);
        City losAngeles=new City("Los Angeles",4563218);
        City chicago=new City("Chicago",2716520);
        City denver=new City("Denver",704621);
        City desMoines=new City("Des Moines",217521);
        City atlanta=new City("Atlanta",486213);

        Map<String,City> states=new HashMap<>();
        states.put("New York",newYork);
        states.put("California",losAngeles);
        states.put("Illinois",chicago);
        states.put("Colorado",denver);
        states.put("Iowa",desMoines);
        states.put("Georgia",atlanta);

        Map<String,City> whatIExpect=new HashMap<>();
        whatIExpect.put("New York",newYork);
        whatIExpect.put("California",losAngeles);
        whatIExpect.put("Illinois",chicago);
        int pop=888888;
        //Act
        Map<String,City>  whatIget=filter.filterByPopulation(states,pop);
        //Assert
       // assertEquals(whatIExpect,filter.filterByPopulation(states,pop));
        assertEquals(whatIExpect,whatIget);//filter.filterByPopulation(states,pop));

    }
}