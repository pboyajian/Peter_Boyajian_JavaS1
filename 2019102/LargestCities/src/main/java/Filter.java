import java.util.HashMap;
import java.util.Map;

public class Filter {
    public  Map<String,City>  filterByPopulation(Map<String,City> map, int population){
        Map<String,City> retMap=new HashMap<>();
        for(Map.Entry<String,City> entry:map.entrySet()){
            if (entry.getValue().getPopulation()>population){
                retMap.put(entry.getKey(),entry.getValue());
            }
        }
        return retMap;
    }
}
