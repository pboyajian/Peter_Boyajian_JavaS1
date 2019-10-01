import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        City newYork=new City("New York",8654321);
        City losAngeles=new City("Los Angeles",4563218);
        City chicago=new City("Chicago",2716520);
        City denver=new City("Denver",704621);
        City desMoines=new City("Des Moines",217521);
        City atlanta=new City("Atlanta",486213);

        Map<String,City>states=new HashMap<>();
        states.put("New York",newYork);
        states.put("California",losAngeles);
        states.put("Illinois",chicago);
        states.put("Colorado",denver);
        states.put("Iowa",desMoines);
        states.put("Georgia",atlanta);
        System.out.printf("%-15s %-15s %-15s %n","State","City","Population");
        for(String state:states.keySet()){
            System.out.printf("%-15s %-15s %-15d %n",state,states.get(state).getName(),states.get(state).getPopulation());

        }
        Filter filter=new Filter();
        System.out.println("Enter a population to use as a filter.");
        int filterPop=Integer.parseInt(scanner.nextLine());
        for(String state:filter.filterByPopulation(states,filterPop).keySet()){
            System.out.println(state);
        }
    }
}
