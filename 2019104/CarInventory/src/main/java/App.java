import java.util.Scanner;

public class App {
    public static void welcome(){
    System.out.println("What would you like to do?");
    System.out.println("Enter a number.");
    System.out.println("1. Add");
    System.out.println("2. Delete");
    System.out.println("3. List");
    System.out.println("4. Search");

}
    public static void main(String[] args) {
        CarInventory carInventory=new CarInventory();
        Scanner scanner=new Scanner(System.in);
        String[] searchStrings={"","Make","Model","Year","Color","Mileage"};
        while(true){
            welcome();
            int userInput=Integer.parseInt(scanner.nextLine());
            switch (userInput){
                case 1:
                    System.out.println("Please enter the following properties of the car you would like to add:");
                    System.out.print("Make: ");
                    String make=scanner.nextLine();
                    System.out.println();
                    System.out.print("Model: ");
                    String model=scanner.nextLine();
                    System.out.println();
                    System.out.print("Year: ");
                    int year=Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    System.out.print("Color: ");
                    String color=scanner.nextLine();
                    System.out.println();
                    System.out.print("Mileage: ");
                    int mileage=Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    Car car=new Car(make,model,year,color,mileage);
                    carInventory.add(car);
                    break;
                case 2:
                    carInventory.list();
                    System.out.print("Select a car: ");
                    int userInt=Integer.parseInt(scanner.nextLine());
                    carInventory.delete(userInt);
                    break;
                case 3:
                    carInventory.list();
                    break;
                case 4:
                    System.out.println("How would you like to filter?");
                    System.out.println("Enter a number.");
                    System.out.println("1. Make");
                    System.out.println("2. Model");
                    System.out.println("3. Year");
                    System.out.println("4. Color");
                    System.out.println("5. Mileage");
                    System.out.print("? ");
                    int searchParam1=Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    System.out.println("Enter the desired "+searchStrings[searchParam1]);
                    String searchParam2=scanner.nextLine();
                    carInventory.list(carInventory.search(searchParam1,searchParam2));
                    break;
                default:
                    welcome();
            }




        }

    }
}
