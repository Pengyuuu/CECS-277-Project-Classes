import java.util.Scanner;
import java.util.ArrayList;

public class Tester {

    public static void main(String[] args){

        ArrayList<VendingMachine> machine = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("(S)how products (I)nsert coins (B)uy (A)dd product (R)emove coins (Q)uit");

        String choice = scan.nextLine();

        if (choice.equals("s") || choice.equals("S")){

            for (int i = 0; i < machine.size(); i++){

                System.out.println(machine.get(i));
            }
        }

        else if (choice.equals("a") || choice.equals("A")){

            System.out.print("Description: ");

            String desc = scan.nextLine();

            System.out.print("\n Price: ");

            double price = scan.nextDouble();

            System.out.print("\n Quantity: ");

            int quantity = scan.nextInt();

            Product addItem = new Product(desc, price, quantity);

            machine.add(addItem);
        }

    }
}
