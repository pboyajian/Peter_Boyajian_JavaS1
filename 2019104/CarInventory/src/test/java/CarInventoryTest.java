import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CarInventoryTest {
    private InputStream original;
    static CarInventory carInventory;

    @Before
    public void setUp() {
        carInventory = new CarInventory();
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
    public void shouldAddCar(){
        Car car=new Car("a","a",3,"a",4);
        carInventory.add(car);
    Map<Integer, Car> expectedMap=new HashMap<>();
    expectedMap.put(1,car);
    assertEquals(expectedMap,carInventory.getCarMap());



}
@Test
    public void shouldDeleteCar(){
    Car car=new Car("a","a",3,"a",4);
    carInventory.add(car);
    carInventory.delete(1);
    Map<Integer, Car> expectedMap=new HashMap<>();
    assertEquals(expectedMap,carInventory.getCarMap());

}
@Test
    public void shouldListCar(){
    Car car=new Car("a","a",3,"a",4);
    carInventory.add(car);
    carInventory.list();
    String output = systemOutRule.getLog();
    assertTrue(output.contains("1=Car{make='a', model='a', year=3, color='a', mileage=4}"));
}
@Test
    public void shouldSearchCarMake(){

    Car car=new Car("a","a",3,"a",4);
    carInventory.add(car);
    Car car2=new Car("a","ab",31,"a",41);
    carInventory.add(car2);
    Car car3=new Car("b","ab",3,"c",4);
    carInventory.add(car3);
    carInventory.list(carInventory.search(1,"a"));
    String output = systemOutRule.getLog();
    assertTrue(output.contains("1=Car{make='a', model='a', year=3, color='a', mileage=4}"));
    assertTrue(output.contains("2=Car{make='a', model='ab', year=31, color='a', mileage=41}"));
}

    @Test
    public void shouldSearchCarModel(){

        Car car=new Car("a","a",3,"a",4);
        carInventory.add(car);
        Car car2=new Car("a","ab",31,"a",41);
        carInventory.add(car2);
        Car car3=new Car("b","ab",3,"c",4);
        carInventory.add(car3);
        carInventory.list(carInventory.search(2,"ab"));
        String output = systemOutRule.getLog();
        assertTrue(output.contains("2=Car{make='a', model='ab', year=31, color='a', mileage=41}"));
        assertTrue(output.contains("3=Car{make='b', model='ab', year=3, color='c', mileage=4}"));
    }

    @Test
    public void shouldSearchCarYear(){

        Car car=new Car("a","a",3,"a",4);
        carInventory.add(car);
        Car car2=new Car("a","ab",31,"a",41);
        carInventory.add(car2);
        Car car3=new Car("b","ab",3,"c",4);
        carInventory.add(car3);
        carInventory.list(carInventory.search(3,"3"));
        String output = systemOutRule.getLog();
        assertTrue(output.contains("1=Car{make='a', model='a', year=3, color='a', mileage=4}"));
        assertTrue(output.contains("3=Car{make='b', model='ab', year=3, color='c', mileage=4}"));
    }

    @Test
    public void shouldSearchCarColor(){

        Car car=new Car("a","a",3,"a",4);
        carInventory.add(car);
        Car car2=new Car("a","ab",31,"a",41);
        carInventory.add(car2);
        Car car3=new Car("b","ab",3,"c",4);
        carInventory.add(car3);
        carInventory.list(carInventory.search(4,"c"));
        String output = systemOutRule.getLog();
        assertTrue(output.contains("3=Car{make='b', model='ab', year=3, color='c', mileage=4}"));
    }


    @Test
    public void shouldSearchCarMileage(){

        Car car=new Car("a","a",3,"a",4);
        carInventory.add(car);
        Car car2=new Car("a","ab",31,"a",41);
        carInventory.add(car2);
        Car car3=new Car("b","ab",3,"c",4);
        carInventory.add(car3);
        carInventory.list(carInventory.search(5,"4"));
        String output = systemOutRule.getLog();
        assertTrue(output.contains("1=Car{make='a', model='a', year=3, color='a', mileage=4}"));
        assertTrue(output.contains("3=Car{make='b', model='ab', year=3, color='c', mileage=4}"));
    }


    @Test
    public void shouldFindNoSearchResultsForInvalidInput(){

        Car car=new Car("a","a",3,"a",4);
        carInventory.add(car);
        Car car2=new Car("a","ab",31,"a",41);
        carInventory.add(car2);
        Car car3=new Car("b","ab",3,"c",4);
        carInventory.add(car3);
        carInventory.list(carInventory.search(4,""));
        carInventory.list(carInventory.search(1,""));
        carInventory.list(carInventory.search(2,""));
        carInventory.list(carInventory.search(3,"0"));
        carInventory.list(carInventory.search(5,"0"));

        String output = systemOutRule.getLog();
        assertFalse(output.contains("1=Car{make='a', model='a', year=3, color='a', mileage=4}"));
        assertFalse(output.contains("2=Car{make='a', model='ab', year=31, color='a', mileage=41}"));
        assertFalse(output.contains("3=Car{make='b', model='ab', year=3, color='c', mileage=4}"));
    }
}