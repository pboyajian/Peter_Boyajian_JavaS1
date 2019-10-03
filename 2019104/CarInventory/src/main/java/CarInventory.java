import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CarInventory {
    private Map<Integer,Car> carMap=new HashMap<>();

    public Map<Integer, Car> getCarMap() {
        return carMap;
    }

    public void add(Car car){

        carMap.put(Car.getCarsMade(),car);

    }
    public void delete(int userInput){
        carMap.remove(userInput);
    }
    public void list() {
        for (Map.Entry<Integer, Car> entry : carMap.entrySet()) {
            System.out.println(entry);
        }
    }
        public void list(Map<Integer,Car> map){
            for(Map.Entry<Integer,Car> entry: map.entrySet()){
                System.out.println(entry);
            }

    }
    public Map<Integer,Car> search(int userInt,String userString){
        switch (userInt){
            case 1:
                return carMap.
                        entrySet().
                        stream().
                        filter(b->b.getValue().
                                getMake().
                                equals(userString)).
                        collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
                            case 2:
                return carMap.
                        entrySet().
                        stream().
                        filter(b->b.getValue().
                                getModel().
                                equals(userString)).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
            case 3:
                int year=Integer.parseInt(userString);

                return carMap.
                        entrySet().
                        stream().
                        filter(b->b.getValue().
                                getYear()==year).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
            case 4:
                return carMap.
                        entrySet().
                        stream().
                        filter(b->b.getValue().
                                getColor().
                                equals(userString)).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
            case 5:
                int mileage=Integer.parseInt(userString);

                return carMap.
                        entrySet().
                        stream().
                        filter(b->b.getValue().
                                getMileage()==mileage).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
            default:
                return carMap;
        }

    }



}
