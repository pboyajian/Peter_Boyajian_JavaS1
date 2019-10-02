import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {
        Random random=new Random();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100)+1);
        }
        List<Integer> list2=new ArrayList<>();
        list2.addAll(list);
        System.out.println("list 1 = " + list);
        System.out.println("list 2 = " + list2);
    }
}
