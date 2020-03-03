import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        VendingMachine box = new VendingMachine();

        Scanner scan = new Scanner(System.in);


        boolean goMachine = true;
        int count = 0;

        while (goMachine) {

            System.out.println((count+=1) + "(S)how products (I)nsert coins (B)uy (A)dd product (R)emove coins (Q)uit");

            String choice = scan.nextLine();

            if (choice.equals("s") || choice.equals("S")) {
                box.showProducts();

            }
            else if (choice.equals("i") || choice.equals("I")) {

                System.out.println("A) nickel @ 0.05 \nB) dime @ 0.10 \nC) quarter @ 0.25 \nD) dollar @ 1.00");

                choice = scan.nextLine();

                box.insertCoins(choice);

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

                System.out.print("\nPrice: ");
                double price = Double.parseDouble(scan.nextLine());

                System.out.print("\nQuantity: ");
                int quantity = Integer.parseInt(scan.nextLine());

                box.addProduct(new Product(desc, price, quantity));

            }

            else if (choice.equals("R") || choice.equals("r")){
                System.out.println("Removed: " + box.getBalance());
                box.setBalance();
            }

            else if (choice.equals("Q") || choice.equals("q")){
                System.out.println(box.toString());
                goMachine = false;
            }
        }
    }
}
