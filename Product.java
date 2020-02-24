public class Product extends VendingMachine {

    private String name;
    private double price;
    private int quantity;

    public Product(String s, double p, int q){

        super(s);
        price = p;
        quantity = q;
    }
}
