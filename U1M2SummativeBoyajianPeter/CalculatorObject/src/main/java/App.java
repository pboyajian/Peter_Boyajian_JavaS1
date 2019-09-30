public class App {
    public static void main(String[] args) {
        Calculator calc=new Calculator();
       String[] lhs={//left hand side
               "1+1",
               "23-52",
               "34*2",
               "12/3",
               "12/7",
               "3.4+2.3",
               "6.7*4.4",
               "5.5-0.5",
               "10.8/2.2"
       };
       String[] rhs={//right hand side
               ""+calc.add(1,1),
               ""+calc.subtract(23,52),
               ""+calc.multiply(34,2),
               ""+calc.divide(12,3),
               ""+calc.divide(12,7),
               ""+calc.add(3.4,2.3),
               ""+calc.multiply(6.7,4.4),
               ""+calc.subtract(5.5,0.5),
               ""+calc.divide(10.8,2.2)
       };
        for (int i = 0; i < lhs.length; i++) {
            System.out.println(lhs[i]+" = "+rhs[i]);
        }
    }
}
