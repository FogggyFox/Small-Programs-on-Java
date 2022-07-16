package Shops;

import Exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ShopSearch {
    public List<Product> products = new ArrayList<>();
    public List<Shop> shops = new ArrayList<>();

    public void NewShop(String name, String address) {
        shops.add(new Shop(shops.size() + 1, name, address));
    }

    public void NewProduct(String name) {
        products.add(new Product(products.size() + 1, name));
    }

    public void Add(Shop shop, Product product, int number, double price) throws AddProductException {
        if (price < 0) throw new AddProductException("Price can't be negative");
        if (number < 0) throw new AddProductException("Number of products can't be zero or negative");
        if (!checkShop(shop)) throw new AddProductException("Shop " + shop.name + " doesn't exist");
        if (!checkProduct(product)) throw new AddProductException("Product " + product.name + " doesn't exist");

        int productmark = findProduct(product);
        int shopmark = findShop(shop);

        shops.get(shopmark).Add(products.get(productmark), number, price);
    }

    public void Add(Shop shop, Product product, int number) throws AddProductException {
        if (number < 0) throw new AddProductException("Number of products can't be zero or negative");

        if (!checkShop(shop)) throw new AddProductException("Shop " + shop.name + " doesn't exist");


        if (!checkProduct(product)) throw new AddProductException("Product " + product.name + " doesn't exist");
        int productmark = findProduct(product);
        int shopmark = findShop(shop);

        shops.get(shopmark).Add(products.get(productmark), number);
    }

    public Shop CheapestShop(Product product) throws CheapestShopException {
        double min= Double.MAX_VALUE;
        Shop CheapShop=null;

        for (Shop item : shops){
            for (Stock pr : item.stocks){
                if (pr.product.id == product.id & pr.price < min){
                    CheapShop = item;
                    min = pr.price;
                }
            }
        }
        if (CheapShop == null) throw new CheapestShopException("Product " + product.name + " doesn't exist in all shops");
        return CheapShop;
    }

    public List<Pair<String, Integer>> MaxBuy(Shop shop, double maxprice) throws MaxBuyException, AnotherException {
        if (!checkShop(shop)) throw new MaxBuyException("Shop " + shop.name + " doesn't exist");
        int shopmark = findShop(shop);
        List<Pair<String, Integer>> variants = new ArrayList<>();
        for (Stock item : shops.get(shopmark).stocks)
        {
            double price = shop.GetPrice(item.product);
            int number = shop.GetNumber(item.product);
            int enough = (int)Math.min(number, Math.floor(maxprice / price));
            if (enough >= 1) {
                variants.add(new Pair<>(item.product.name, enough));
            }
        }
        return variants;
    }
    public boolean TryBuy(Shop shop, Product product, int number){
        if (!checkShop(shop)) return false;
        if (!checkProduct(product)) return false;

        return shops.get(findShop(shop)).TryBuy(product, number);
    }
    public double Buy(Shop shop, Product product, int number) throws BuyProductException {
        return shops.get(findShop(shop)).Buy(product, number);
    }
    public Shop CheapestShopForList(List<Pair<Product, Integer>> list) throws BuyProductException, CheapestShopException {
        Shop CheapShop=null;
        double min= Double.MAX_VALUE;
        double Total = 0;
        for (Shop item : shops){
            for (Pair<Product, Integer> pr : list){
                if (TryBuy(item, pr.getL(), pr.getR())){
                    Total += Buy(item, pr.getL(), pr.getR());
                }
                else{
                    Total=0;
                    break;
                }
            }
            if ( Total != 0 & Total < min){
                min = Total;
                CheapShop=item;
            }
        }
        if (CheapShop == null) throw new CheapestShopException("This list of products can't be bought in these shops");
        return CheapShop;
    }
    public int findShop(Shop shop){
        int shopmark = 0;
        for (int i = 0; i < shops.size(); i++) {
            if (shops.get(i).id == shop.id) {
                shopmark = i;
                break;
            }
        }
        return shopmark;
    }
    public int findProduct(Product product){
        int productmark = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id == product.id) {
                productmark = i;
                break;
            }
        }
        return productmark;
    }
    public boolean checkProduct(Product product){
        boolean mark = false;
        for (Product item : products) {
            if (item.id == product.id) {
                mark = true;
                break;
            }
        }
        return mark;
    }
    public boolean checkShop(Shop product){
        boolean mark = false;
        for (Shop item : shops) {
            if (item.id == product.id) {
                mark = true;
                break;
            }
        }
        return mark;
    }
}
