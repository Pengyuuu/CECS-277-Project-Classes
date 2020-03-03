import java.util.ArrayList;

public class VendingMachine {

    private double balance;
    private ArrayList<Product> inventory;

    public VendingMachine(){

        balance = 0.0;
        inventory = new ArrayList<>();
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

    public void checkInventory(){

        for (int i = 0; i < inventory.size(); i++){

            if (inventory.get(i).getQuantity() == 0){

                inventory.remove(i);
            }
        }
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
}
