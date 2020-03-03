public class Product{

    private String name;
    private double price;
    private int quantity;

    public Product(String s, double p, int q){

        name = s;
        price = p;
        quantity = q;
    }

    @Override
    public String toString(){

        return name + " @ " + price;
    }
}
