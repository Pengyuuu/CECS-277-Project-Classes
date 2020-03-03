public class Product extends VendingMachine{

    private String name;
    private double price;
    private int quantity;

    public Product () {
        name = "";
        price = 0.0;
        quantity = 0;
    }

    public Product (String name) {
        this.name = name;
    }

    public Product(String s, double p, int q){
        name = s;
        price = p;
        quantity = q;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double n){

        price = n;
    }

    public int getQuantity(){

        return quantity;
    }

    public void setQuantity(){

        quantity -= 1;
    }

    public double getPrice(){
        return price;
    }

    public String getName () {
        return name;
    }


    @Override
    public String toString(){

        return name + " @ " + price;
    }
}
