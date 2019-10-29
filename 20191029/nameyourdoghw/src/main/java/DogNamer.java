import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * WRITE TESTS IN A SEPARATE TEST CLASS, AND IMPLEMENT THE METHOD
 * generateName
 * BELOW
 *
 *
 * The DogNamer class has a method that will generate a dog name for you.
 * Given a list of names, two numbers, and a surname, the generateName method will
 * give you a full dog name (first and middle) with a surname
 * The only rule is that no two names in the result can start with the same letter.
 * So,
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 0 and 1
 * and the surname Smith
 *
 * the generateName method will give the name
 * Rover Winston Smith
 *
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 1 and 2
 * and the surname Smith
 * the generateName method will give the name
 * Winston Smith
 *
 *
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 2 and 3
 * and the surname Smith
 * the generateName method will give the name
 * Smith
 *
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 2 and 5
 * and the surname Smith
 * the generateName method will give the name
 * Diogi Smith
 */


public class DogNamer {
    public static void main(String[] args) {
        DogNamer dogNamer = new DogNamer();

        List<String> nameList1 = new ArrayList<>();
        nameList1.add("Rover");
        nameList1.add("Winston");
        nameList1.add("Spike");
        nameList1.add("Spot");
        nameList1.add("Speck");
        nameList1.add("Diogi");
        nameList1.add("Max");
        System.out.println(dogNamer.generateName(nameList1, 0, 1, "Smith"));
    }

    public String generateName(List<String> nameList1, int firstIx, int middleIx, String lastName) {
        String retName=lastName;
        char firstCharOfLastName=lastName.charAt(0);
        if (nameList1.get(middleIx).charAt(0)!=firstCharOfLastName){
            retName=nameList1.get(middleIx)+" "+retName;
        }
        if (nameList1.get(firstIx).charAt(0)!=firstCharOfLastName){
            retName=nameList1.get(firstIx)+" "+retName;
        }
        return retName;
    }

    public String generateName(/*parameters go here*/) {
        // your code goes here
        return null;
    }
}
