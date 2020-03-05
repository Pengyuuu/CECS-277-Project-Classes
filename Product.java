/** @authors Eric Truong, Erina Lara
 * Date: March 3, 2020
 * Purpose: Program creates a vending machine, using a class of coins and a subclass of product.
 */

public class Product extends VendingMachine{

    /** name of product */
    private String name;

    /** price of product */
    private double price;

    /** quantity of product */
    private int quantity;

    /** Default constructor for product, all values set to null or 0
     */
    public Product () {
        name = "";
        price = 0.0;
        quantity = 0;
    }

    /** Creates Product with given name
     * @param name name of product
     */
    public Product (String name) {
        this.name = name;
    }

    /** Creates a product with given name, price, and quantity
     * @param s name of product
     * @param p price of product
     * @param q quantity of product
     */
    public Product(String s, double p, int q){
        name = s;
        price = p;
        quantity = q;
    }

    /** Sets product quantity to given quantity
     * @param quantity specified quantity of product
     */
    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    /** Sets price of product to given price
     * @param n specified price of product
     */
    public void setPrice(double n){
        price = n;
    }

    /** Gets quantity of product
     * @return product's quantity
     */
    public int getQuantity(){
        return this.quantity;
    }

    /** Removes 1 from quantity of product
     */
    public void setQuantity(){
        this.quantity -= 1;
    }

    /** Gets price of product
     * @return product's price
     */
    public double getPrice(){
        return price;
    }

    /** returns name of product
     * @return product name
     */
    public String getName () {
        return name;
    }

    /** Returns string of product name and its price
     * @return string of product name and price
     */
    @Override
    public String toString(){
        return name + " @ " + price;
    }
}
