import java.util.ArrayList;

public class VendingMachine {

    private double balance;
    private ArrayList<Product> inventory;

    public VendingMachine(){
        inventory = new ArrayList<>();
        balance = 0.0;
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

    public double getBalance(){

        return balance;
    }

    public void setBalance(){

        balance = 0.0;
    }

    public void setBalance(double n){

        balance += n;
    }

    public void returnBalance(Product n){

        balance -= n.getPrice();
    }

    public void showProducts() {
        if (inventory.size() != 0) {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(inventory.get(i));
            }
        }
        else if (inventory.size() == 0){
            System.out.println("No products.");
        }

    }

    public void insertCoins(String choice) {
        if (choice.equals("A") || choice.equals("a")) {
            this.setBalance(0.05);
        }
        else if (choice.equals("B") || choice.equals("b")) {
            this.setBalance(0.10);
        }
        else if (choice.equals("C") || choice.equals("c")) {

            this.setBalance(0.25);
        }
        else if (choice.equals("D") || choice.equals("d")) {

            this.setBalance(1.000);
        }

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
