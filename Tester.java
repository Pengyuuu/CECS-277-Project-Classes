/** @authors Eric Truong, Erina Lara
 * Date: March 3, 2020
 * Purpose: Program creates a vending machine, using a class of coins and a class of product.
 * Inputs: User choice for option, choice for a product to be bought, choice of product name
 *         price, and quantity, and choice for coin inserted.
 * Outputs: Vending Machine options, inventory list of products, list of coin options to be inserted,
 *          description, price, quantity of product, and coins removed from machine.
 */

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        // creates a Vending Machine
        VendingMachine box = new VendingMachine();
        Scanner scan = new Scanner(System.in);      // scans for input from user

        boolean goMachine = true; // loops until user decides to quit

        while (goMachine) {

            System.out.println("(S)how products (I)nsert coins (B)uy (A)dd product (R)emove coins (Q)uit");
            String choice = scan.nextLine();    // user option choice


            // SHOW INVENTORY OPTION
            if (choice.equals("s") || choice.equals("S")) {

                if (box.showInventory() == false){      // no products in inventory
                    System.out.println("No items in machine, please add products. ");   // tells user that there are no products
                }

                else {
                    for (int i = 0; i < box.getInventorySize(); i++) {      // prints inventory of products to user
                        System.out.println((i + 1) + ". " + box.getProduct(i));
                    }
                }
            }

            // INSERT COINS OPTION
            else if (choice.equals("i") || choice.equals("I")) {

                // coin value selection
                System.out.println("A) nickel @ 0.05 \nB) dime @ 0.10 \nC) quarter @ 0.25 \nD) dollar @ 1.00");

                choice = scan.nextLine();   // gets user choice for coin
                box.insertCoin(choice);     // inserts chosen coin, adds to balance

            }

            // BUY PRODUCT OPTION
            else if (choice.equals("b") || choice.equals("B")){

                if (box.showInventory() == false){  // no products in inventory
                    System.out.println("No items in machine, please add products. ");       // tells user there are no products
                }

                else {
                    for (int i = 0; i < box.getInventorySize(); i++){       // Prints inventory to user
                        System.out.println((i + 1) + ". " + box.getProduct(i));
                    }

                    int buying = Integer.parseInt(scan.nextLine()) - 1;     // user choice of product

                    if (box.buyItem(box.getProduct(buying))){            // user is able to purchase item
                        System.out.println("Purchased: " + box.getProduct(buying));      // tells user item is bought

                    }
                    else{   // User does not have enough money to buy item
                        System.out.println("Insufficient funds. ");     // tells user that he/she does not have enough funds
                    }
                }
            }

            // ADD PRODUCT OPTION
            else if (choice.equals("a") || choice.equals("A")) {

                System.out.print("Description: ");  // Product name
                String desc = scan.nextLine();      // user enters product name

                System.out.print("Price: "); // price of product
                double price = Double.parseDouble(scan.nextLine());     // user enters price of product

                System.out.print("Quantity: "); // quantity of product
                int quantity = Integer.parseInt(scan.nextLine());       // user enters quantity of product

                box.addProduct(new Product(desc, price, quantity));  // adds product with given details

            }

            // REMOVE COINS OPTION
            else if (choice.equals("R") || choice.equals("r")){

                double removeCoins = box.removeBalance();   // coins removed
                if (removeCoins != 0.0) {   // removes total balance of all coins inserted
                    System.out.println("Removed: $" + removeCoins);     // tells user total value of coins removed
                    box.setBalance();   // sets balance back to 0
                }

                else {      // removes 0 coins if valid purchase was not made
                    System.out.println("Removed: $" + removeCoins);
                }
            }

            // QUIT OPTION
            else if (choice.equals("Q") || choice.equals("q")){     // user decides to quit
                System.out.println("Vending Machine exited. ");     // tells user program has been exited
                goMachine = false;      // exits loop
            }
        }
    }
}