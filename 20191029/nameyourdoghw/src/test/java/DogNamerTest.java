import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DogNamerTest {
private DogNamer dogNamer;
private List<String> nameList=new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        dogNamer = new DogNamer();

        nameList.add("Rover");
        nameList.add("Winston");
        nameList.add("Spike");
        nameList.add("Spot");
        nameList.add("Speck");
        nameList.add("Diogi");
        nameList.add("Max");
    }
    @Test
    public void shouldReturnAppropriateName(){
        String expectedName1="Rover Winston Smith";
        String expectedName2="Winston Smith";
        String expectedName3="Smith";
        String expectedName4="Diogi Smith";
        String actualName1=dogNamer.generateName(nameList,0,1,"Smith");
        String actualName2=dogNamer.generateName(nameList,1,2,"Smith");
        String actualName3=dogNamer.generateName(nameList,2,3,"Smith");
        String actualName4=dogNamer.generateName(nameList,2,5,"Smith");
        assertEquals(expectedName1,actualName1);
        assertEquals(expectedName2,actualName2);
        assertEquals(expectedName3,actualName3);
        assertEquals(expectedName4,actualName4);
    }
}