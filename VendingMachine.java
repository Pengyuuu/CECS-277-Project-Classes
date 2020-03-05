/** @authors Eric Truong, Erina Lara
 * Date: March 3, 2020
 * Purpose: Program creates a vending machine, using a class of coins and a class of product.
 */

import java.util.ArrayList;

public class VendingMachine {

    /** total balance of all coins inserted */
    private Coin balance;

    /** vending machine balance after an item is bought */
    private double vending_balance;

    /** inventory of products in vending machine */
    private ArrayList<Product> inventory;

    /** decides if a purchase was valid or not*/
    private boolean validPurchase;


    /** Default constructor, initializes inventory, balance, vending balance, and validPurchase
     */
    public VendingMachine(){

        inventory = new ArrayList<>();
        balance = new Coin();
        vending_balance = 0;
        validPurchase = false;
    }

    /** Adds specified product to inventory
     * @param item product to be added
     */
    public void addProduct(Product item){
        inventory.add(item);
    }

    /** Removes product from inventory
     * @param item product to be removed
     */
    public void removeProduct(Product item) {
        inventory.remove(item);
    }

    /** Gets inventory
     * @return a list of inventory
     */
    public ArrayList<Product> getInventory(){
        return inventory;
    }

    /** Gets product at specified index in inventory
     * @param i specified index
     * @return Product at specified index
     */
    public Product getProduct(int i){
        return inventory.get(i);
    }

    /** Gets size of inventory
     * @return inventory size
     */
    public int getInventorySize(){
        return inventory.size();
    }

    /** Inserts a coin into vending machine
     * @param n choice of coin value
     */
    public void insertCoin(String n){
        balance.setBalance(n);
        vending_balance += balance.getBalance();
        balance.setBalance(n);           // adds to balance
    }

    /** Gets total balance, copies into vending_balance
     * @return total balance
     */
    public double getBalance(){
        return balance.getBalance();
    }

    /** Sets balance back to 0
     */
    public void setBalance(){
        balance.setBalance();
    }

    /** Buys selected product item
     * @param n product to be bought
     * @return true if product was successfully bought, false if not
     */
    public boolean buyItem(Product n){

        if (balance.buyItem(n.getPrice()) == true & n.getQuantity() != 0 & vending_balance != 0) {
            validPurchase = true;   // valid purchase was made
            vending_balance = 0;    // resets vending balance to 0
            n.setQuantity();    // product quantity is -1
            return true;
        }

        else {     // if quantity is 0 or balance is does not meet or exceed product's price
            return false;
        }
    }

    /** Removes total balance of all coins inserted,
     * based on whether a valid purchase was made or not
     * @return balance of coins inserted
     */
    public double removeBalance() {

        if (validPurchase) {
            validPurchase = false;  // resets valid purchase to false
            return balance.getBalance();  // gives balance
        }
        else {      // if no valid purchase was made
            return 0.0;
        }
    }

    /** Shows updated inventory with products that do not
     * have a quantity that equals 0
     * @return true if inventory size is not 0, false if not
     */
    public boolean showInventory() {

        // removes products of 0 quantity
        for (int k = 0; k < this.getInventorySize(); k++) {

            if (this.getProduct(k).getQuantity() == 0) {
                this.removeProduct(this.getProduct(k));
                k --;
            }
        }
        return (this.getInventorySize() != 0);
    }

    /** Returns string of inventory
     * @return String of inventory list
     */
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