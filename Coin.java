public class Coin {

    private final double NICKLE = 0.05;

    private final double DIME = 0.10;

    private final double QUARTER = 0.25;

    private final double DOLLAR = 1.00;

    private double balance;

    public Coin(){

        balance = 0;
    }

    public double getBalance(){

        return balance;
    }

    public void setBalance(){

        balance = 0;
    }

    public void setBalance(String n){

        if (n.equals("a") || n.equals("A")){

            balance += NICKLE;
        }

        else if (n.equals("b") || n.equals("B")){

            balance += DIME;
        }

        else if (n.equals("c") || n.equals("C")){

            balance += QUARTER;
        }

        else if (n.equals("d") || n.equals("D")){

            balance += DOLLAR;
        }
    }

    public void buyItem(double price){

        balance -= price;
    }

    public String toString(){

        return "Balance: " + balance;
    }
}
