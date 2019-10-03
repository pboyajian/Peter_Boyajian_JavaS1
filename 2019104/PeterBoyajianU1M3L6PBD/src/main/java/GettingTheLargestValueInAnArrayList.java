import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GettingTheLargestValueInAnArrayList {
    public static void main(String[] args) {
        Random random=new Random();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100)+1);
        }
        System.out.println("list = " + list);
        int max=list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>=max){
                max=list.get(i);
            }
        }
        System.out.println("The largest value is "+max);
    }
}

