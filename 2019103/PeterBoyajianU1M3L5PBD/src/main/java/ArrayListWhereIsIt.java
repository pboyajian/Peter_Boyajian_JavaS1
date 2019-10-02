import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {
    public static void main(String[] args) {
        Random random=new Random();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(50)+1);
        }
        System.out.println("list = " + list);
        Scanner scanner=new Scanner(System.in);
        System.out.print("Value to find: ");
        int userInt=Integer.parseInt(scanner.nextLine());
        boolean there =false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==userInt){
                System.out.println(userInt+" is in slot "+i+".");
                there=true;
            }
        }
        if (!there){
            System.out.println(userInt+" is NOT in the ArrayList.");
        }
    }
}
