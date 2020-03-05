/** @authors Eric Truong, Erina Lara
 * Date: March 3, 2020
 * Purpose: Program creates a vending machine, using a class of coins and a subclass of product.
 */

import java.util.ArrayList;

public class VendingMachine {

    private Coin balance;
    private ArrayList<Product> inventory;

    public VendingMachine(){
        inventory = new ArrayList<>();
        balance = new Coin();
    }

    public void addProduct(Product item){

        inventory.add(item);
    }

    public ArrayList<Product> getInventory(){

        return inventory;
    }

    public Product getProduct(int i){

        return inventory.get(i);
    }

    public int getInventorySize(){

        return inventory.size();
    }

    public void insertCoin(String n){

        balance.setBalance(n);
    }

    public double getBalance(){

        return balance.getBalance();
    }

    public void setBalance(){

        balance.setBalance();
    }


    public void buyItem(Product n){

        balance.buyItem(n.getPrice());
    }

    @Override
    public String toString () {
        String stock = "";
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            stock += p.toString() + '\n';

        }
        return stock;
    }

}
