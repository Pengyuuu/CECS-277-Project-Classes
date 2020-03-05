/** @authors Eric Truong, Erina Lara
 * Date: March 3, 2020
 * Purpose: Program creates a vending machine, using a class of coins and a subclass of product.
 */

public class Coin {

    /** sets nickel value */
    private final double NICKLE = 0.05;

    /** sets dime value */
    private final double DIME = 0.10;

    /** sets quarter value */
    private final double QUARTER = 0.25;

    /** sets dollar value */
    private final double DOLLAR = 1.00;

    /** total balance of all coins inserted */
    private double balance;

    /** Default constructor, balance initialized to 0
     */
    public Coin(){
        balance = 0;
    }

    /** Gets total balance of all coins
     * @return total balance
     */
    public double getBalance(){
        return balance;
    }

    /** Sets balance to 0
     */
    public void setBalance(){
        balance = 0;
    }

    /** Adds coin to balance
     * @param n coin choice selected
     */
    public void setBalance(String n){

        // String a represents first choice for nickel
        if (n.equals("a") || n.equals("A")){

            balance += NICKLE;
        }

        // String b represents first choice for nickel
        else if (n.equals("b") || n.equals("B")){

            balance += DIME;
        }

        // String c represents first choice for nickel
        else if (n.equals("c") || n.equals("C")){

            balance += QUARTER;
        }

        // String d represents first choice for nickel
        else if (n.equals("d") || n.equals("D")){

            balance += DOLLAR;
        }
    }

    /** Returns true/false if user can buy item or not
     * @param price given price of product to be bought
     * @return true if user can buy item, false if cannot
     */
    public boolean buyItem(double price){
        return balance >= price;
    }

    /** Returns a string of balance
     * @return string of balance
     */
    @Override
    public String toString(){
        return "Balance: " + balance;
    }
}
