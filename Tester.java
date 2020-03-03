import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        VendingMachine box = new VendingMachine();

        Scanner scan = new Scanner(System.in);

        boolean goMachine = true;

        while (goMachine) {

            System.out.println("(S)how products (I)nsert coins (B)uy (A)dd product (R)emove coins (Q)uit");

            String choice = scan.nextLine();

            if (choice.equals("s") || choice.equals("S")) {

                for (int i = 0; i < box.getInventorySize(); i++) {

                    System.out.println(box.getProduct(i));
                }
            }
            else if (choice.equals("i") || choice.equals("I")) {

                System.out.println("A) nickel @ 0.05 \nB) dime @ 0.10 \nC) quarter @ 0.25 \nD) dollar @ 1.00");

                choice = scan.nextLine();

                if (choice.equals("A") || choice.equals("a")) {

                    box.setBalance(0.05);
                }
                else if (choice.equals("B") || choice.equals("b")) {

                    box.setBalance(0.10);
                }
                else if (choice.equals("C") || choice.equals("c")) {

                    box.setBalance(0.25);
                }
                else if (choice.equals("D") || choice.equals("d")) {

                    box.setBalance(1.00);
                }
            }

            else if (choice.equals("b") || choice.equals("B")){

                if (box.getInventory() == null){

                    System.out.println("No items in machine, please add products");
                }
                else{

                    for (int i = 0; i < box.getInventorySize(); i++){

                        System.out.println((i + 1) + ". " + box.getProduct(i));
                    }

                    int buying = scan.nextInt() - 1;

                    if (box.getProduct(buying).getPrice() <= box.getBalance()){

                        System.out.println("Purchased: " + box.getProduct(buying));

                        box.getProduct(buying).setQuantity();

                        box.checkInventory();
                    }
                    else{

                        System.out.println("Insufficient funds");

                        box.setBalance();
                    }
                }
            }
            else if (choice.equals("a") || choice.equals("A")) {

                System.out.print("Description: ");

                String desc = scan.nextLine();

                System.out.print("Price: ");

                double price = scan.nextDouble();

                System.out.print("Quantity: ");

                //int quantity = scan.nextInt();

                box.addProduct(new Product(desc, price, 10));
            }

            else if (choice.equals("R") || choice.equals("r")){

                System.out.println("Removed: " + box.getBalance());

                box.setBalance();
            }

            else if (choice.equals("Q") || choice.equals("q")){

                goMachine = false;
            }

            //scan.nextLine();
        }
    }
}
