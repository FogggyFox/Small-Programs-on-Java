import Exceptions.*;
import Shops.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class oop2 {
    public static void main(String[] args) {
        ShopSearch ss = new ShopSearch();
        ss.NewProduct("Laptop");
        ss.NewProduct("Xiaomi");
        ss.NewProduct("Cucumber");
        ss.NewProduct("Pencil");
        ss.NewProduct("Sofa");
        ss.NewProduct("Book");
        ss.NewProduct("Milk");
        ss.NewProduct("Coffee");
        ss.NewProduct("Beer");
        ss.NewProduct("Chocolate");

        ss.NewShop("IKEA", "St.Petersburg");
        ss.NewShop("IKEA", "Moscow");
        ss.NewShop("DNS", "Saratov");

        System.out.println("1-2 Task.\n");
        System.out.println("Created products:\n");
        for (Product item : ss.products){
            System.out.println(item.name);
        }
        System.out.println("Created shops:\n");
        for (Shop item : ss.shops){
            System.out.println(item.name+ " " + item.address);
        }
        System.out.println(ss.products.size());
        System.out.println("3 Task.\n");
        double price=0;
        for (Shop sh : ss.shops){
            for (Product pr : ss.products){
                price = Math.random()*1000;
                if ( price > 10 & ((int)price % 2 == 0 | (int)price % 3 == 0 ) ){
                    try {
                        ss.Add(sh, pr, (int) (price / 9), price);
                    } catch (AddProductException e) {
                        System.out.println("\n"+e.getMessage());
                    }
                }
            }
            System.out.println("\nIn shop " + sh.name +"," + sh.address);
            System.out.println(sh.stocks.size());
            for (Stock st: sh.stocks){
                String str = String.format("%.2f", st.price);
                System.out.println(st.product.name + " " + st.number + " " + str);
            }
        }
        System.out.println("Добавление без цены");
        for (Shop sh : ss.shops){
            for (Product pr : ss.products){
                int number = (int) (Math.random() * 100);
                if (number > 0 & (number % 2 == 0 || number % 3 == 0)){
                    try {
                        ss.Add(sh, pr, number);
                    } catch (AddProductException e) {
                        System.out.println("\n"+e.getMessage());
                    }
                }
            }
            System.out.println("\nIn shop " + sh.name +"," + sh.address);
            System.out.println(sh.stocks.size());
            for (Stock st: sh.stocks){
                String str = String.format("%.2f", st.price);
                System.out.println(st.product.name + " " + st.number + " " + str);
            }
        }
        System.out.println("\nTask 4.\n");
        int let = 4;
        System.out.println("Для примера найдем самый дешевый магазин, чтобы купить " + ss.products.get(let).name);
        try {
            var chshop = ss.CheapestShop(ss.products.get(let));
            System.out.println("The cheapest " + ss.products.get(let).name + " in " + chshop.name + "," + chshop.address);
        } catch (CheapestShopException e) {
            System.out.println("\n"+e.getMessage());
        }
        System.out.println("\nTask 5.\n");
        double pp= 1000;
        let = 0;
        System.out.println("Купим в " + ss.shops.get(let).name+","+ss.shops.get(let).address+ " на " + pp);
        try {
            List<Pair<String, Integer>> ll = ss.MaxBuy(ss.shops.get(let), pp);
            System.out.println("Купили:");
            for (Pair item : ll){
                System.out.println(item.getL() + ", " + item.getR());
            }
        } catch (MaxBuyException | AnotherException e) {
            System.out.println("\n"+e.getMessage());
        }
        System.out.println("\nTask 6.\n");
        let=1;
        int nn= 20;
        int let2 = 5;
        System.out.println("Пытаемся купить продукт " + ss.products.get(let2).name + " в кол-ве " + nn + " в " + ss.shops.get(let).name+" , "+ ss.shops.get(let).address) ;
        if (ss.TryBuy(ss.shops.get(let), ss.products.get(let2), nn)){
            try {
                double total = ss.Buy(ss.shops.get(let), ss.products.get(let2), nn);
                String str = String.format("%.2f", total);
                System.out.println("Итоговая стоимость:" + str);
            } catch (BuyProductException e) {
                System.out.println("\n"+e.getMessage());
            }

        }
        else {
            System.out.println("Can't be bought. There are not " + nn + " items in this shop");
        }
        System.out.println("\nTask 7.\n");
        List <Pair<Product, Integer>> list = new ArrayList<>();
        System.out.println("Найдем самый дешевый магазин для покупки этого списка вещей:");
        for (Product item : ss.products){
            int count = (int) (Math.random()*10);
            if (count>0 && count%3!=0){
                list.add(new Pair(item,count));
                System.out.println(item.name + " " + count);
            }
        }

        try {
            Shop totalshop= ss.CheapestShopForList(list);
            System.out.println("Подходящий магазин:" + totalshop.name+"," + totalshop.address);
        } catch (BuyProductException | CheapestShopException e) {
            System.out.println("\n"+e.getMessage());
        }
    }

}
