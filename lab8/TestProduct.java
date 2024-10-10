package lesson8.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestProduct {
    public static void main(String[] args){
        Product m1 = new Product("MacBook", 1000.0, 1);
        Product m2 = new Product("MacBook aro", 2000.0, 2);
        Product m3 = new Product("MacBook air", 1500.0, 3);

        Product m4 = new Product("MacBook Pro", 3000.0, 4);

        Product m5 = new Product("MacBook Pro", 900.0, 4);
        Product m6 = new Product("MacBook Pro", 800.0, 4);

        Product m7 = new Product("MacBook Pro", 300.0, 4);
        Product m8 = new Product("MacBook Pro", 500.0, 4);


        List<Product> products = new ArrayList<Product>();

        products.add(m1);
        products.add(m2);
        products.add(m3);
        products.add(m4);

        Collections.sort(products, new PriceComparator());
        Collections.sort(products, new TitleComparator());
        System.out.println(products);

        products.add(m5);
        products.add(m6);
        Product.productSort(products, Product.SortMethod.BYTITLE);
        System.out.println(products);

        products.add(m7);
        products.add(m8);
        Product.productSortLambda(products, Product.SortMethod.BYPRICE);
        System.out.println(products);
    }
}
