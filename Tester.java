import java.util.Scanner;
import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {

        ArrayList<Product> items = new ArrayList<>();

        Balance bal = new Balance();

        Scanner scan = new Scanner(System.in);

        boolean goMachine = true;

        while (goMachine) {

            System.out.println("(S)how products (I)nsert coins (B)uy (A)dd product (R)emove coins (Q)uit");

            String choice = scan.nextLine();

            if (choice.equals("s") || choice.equals("S")) {

                for (int i = 0; i < items.size(); i++) {

                    System.out.println(items.get(i));
                }
            }
            else if (choice.equals("i") || choice.equals("I")) {

                System.out.println("A) nickel @ 0.05 \nB) dime @ 0.10 \nC) quarter @ 0.25 \nD) dollar @ 1.00");

                choice = scan.nextLine();

                if (choice.equals("A") || choice.equals("a")) {

                    bal.setBal(0.05);
                }
                else if (choice.equals("B") || choice.equals("b")) {

                    bal.setBal(0.10);
                }
                else if (choice.equals("C") || choice.equals("c")) {

                    bal.setBal(0.25);
                }
                else if (choice.equals("D") || choice.equals("d")) {

                    bal.setBal(1.000);
                }
            }

            else if (choice.equals("b") || choice.equals("B")){

                if (items == null){

                    System.out.println("No items in machine, please add products");
                }
                else{

                    for (int i = 0; i < items.size(); i++){

                        System.out.println((i + 1) + ". " + items.get(i));
                    }

                    int buying = scan.nextInt();

                    if (items.get(buying).getPrice() <= bal.getBal()){

                        System.out.println("Purchased: " + items.get(buying));

                        items.get(buying).setQuantity();
                    }
                    else{

                        System.out.println("Insufficient funds");

                        bal.setBal();
                    }
                }
            }
            else if (choice.equals("a") || choice.equals("A")) {

                System.out.print("Description: ");

                String desc = scan.nextLine();

                System.out.print("\nPrice: ");

                double price = scan.nextDouble();

                System.out.print("\nQuantity: ");

                int quantity = scan.nextInt();

                Product addItem = new Product(desc, price, quantity);

                items.add(addItem);
            }

            else if (choice.equals("R") || choice.equals("r")){

                System.out.println("Removed: " + bal.getBal());

                bal.setBal();
            }

            else if (choice.equals("Q") || choice.equals("q")){

                goMachine = false;
            }
        }
    }
}
