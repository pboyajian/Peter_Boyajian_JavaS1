import java.util.Random;

public class HowManyTimesTo7 {
    public static void main(String[] args) {
        Random rand=new Random();
        int first=-1;
        int total=0;
        int die1,die2;
        boolean noSevens=true;
        int max=100;
        for (int i = 1; i <= max; i++) {
            die1=rand.nextInt(6)+1;
            die2=rand.nextInt(6)+1;
            int sum=die1+die2;
            //System.out.println(i+" : "+sum);
            if (sum==7){
                if (noSevens){
                    first=i;
                    noSevens=false;
                }
                total++;
            }

        }
        System.out.println("We rolled a total of " + total+" 7s (and the corresponding expected value, rounded to the nearest roll, was "+(max/6+1) +").");
        System.out.println("The first occurrence of a 7 was on roll number " + first+".");
    }
}
