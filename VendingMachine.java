import java.util.ArrayList;

public class VendingMachine {

    private Coin balance;
    private ArrayList<Product> inventory;
    private boolean validPurchase;


    public VendingMachine(){

        inventory = new ArrayList<>();
        balance = new Coin();
        validPurchase = false;
    }

    public void addProduct(Product item){

        inventory.add(item);
    }

    public void removeProduct(Product item) {
        inventory.remove(item);
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


    public boolean buyItem(Product n){

        if (balance.buyItem(n.getPrice()) == true & n.getQuantity() != 0) {
            validPurchase = true;
            n.setQuantity();
            return true;
        }

        else {
            return false;
        }
    }

    public double removeBalance() {

        if (validPurchase) {
            validPurchase = false;
            return balance.getBalance();
        }
        else {
            return 0.0;
        }
    }

    public boolean showInventory() {

        for (int k = 0; k < this.getInventorySize(); k++) {
            if (this.getProduct(k).getQuantity() == 0) {
                this.removeProduct(this.getProduct(k));
                k --;
            }
        }

        return (this.getInventorySize() != 0);
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
