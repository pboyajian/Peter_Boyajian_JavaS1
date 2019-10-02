import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {
        Random random=new Random();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(90)+10);
        }
        System.out.println("ArrayList: "+list);
    }
}
