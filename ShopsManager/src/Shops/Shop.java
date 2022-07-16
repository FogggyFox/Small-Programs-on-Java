package Shops;

import Exceptions.AddProductException;
import Exceptions.AnotherException;
import Exceptions.BuyProductException;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public int id;
    public String name;
    public String address;
    public List<Stock> stocks = new ArrayList<>();

    public Shop(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void Add(Product product, int number) throws AddProductException {
        boolean mark = false;
        for (Stock item : stocks) {
            if (item.product.id == product.id) {
                item.number += number;
                mark = true;
                break;
            }
        }
        if (!mark) throw new AddProductException("Error with adding " + product.name + " in " + name + "," + address + ": price does not exists");
    }

    public void Add(Product product, int number, double price){
        boolean mark = false;
        for (Stock item : stocks) {
            if (item.product.id == product.id) {
                item.number += number;
                item.price = price;
                mark = true;
                break;
            }
        }
        if (!mark) stocks.add(new Stock(product, number, price));
    }

    public double Buy(Product product, int number) throws BuyProductException {
        boolean mark = false;
        for (Stock item : stocks) {
            if (item.product.id == product.id) {
                mark = true;
                break;
            }
        }
        if (!mark) throw new BuyProductException("No such product "+product.name+" in shop "+ name);
        int stockmark=0;
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).product.id == product.id) {
                stockmark = i;
                break;
            }
        }
        if (stocks.get(stockmark).number < number) throw new BuyProductException("Not enough count of this product");

        var totalPrice = number * stocks.get(stockmark).price;
        stocks.get(stockmark).number -= number;

        return totalPrice;
    }

    public boolean TryBuy(Product product, int number)
    {
        try
        {
            double totalPrice = Buy(product, number);
            return true;
        } catch (BuyProductException buyProductException) {
            return false;
        }
    }

    public double GetPrice(Product product) throws AnotherException {
        boolean mark = false;
        for (Stock item : stocks) {
            if (item.product.id == product.id) {
                mark = true;
                break;
            }
        }
        if (!mark) throw new AnotherException("No such product "+product.name+" in shop "+ name);
        int stockmark=0;
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).product.id == product.id) {
                stockmark = i;
                break;
            }
        }
        return stocks.get(stockmark).price;
    }

    public int GetNumber(Product product) throws AnotherException {
        boolean mark = false;
        for (Stock item : stocks) {
            if (item.product.id == product.id) {
                mark = true;
                break;
            }
        }
        if (!mark) throw new AnotherException("No such product "+product.name+" in shop "+ name);
        int stockmark=0;
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).product.id == product.id) {
                stockmark = i;
                break;
            }
        }
        return stocks.get(stockmark).number;
    }

}
