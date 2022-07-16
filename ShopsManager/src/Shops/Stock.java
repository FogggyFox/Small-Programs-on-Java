package Shops;

public class Stock {
    public int number;
    public double price;
    public Product product;

    public Stock(Product product, int number, double price) {
        this.product = product;
        this.number = number;
        this.price = price;
    }

}
