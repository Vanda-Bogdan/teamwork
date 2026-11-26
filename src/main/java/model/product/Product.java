package model.product;

import java.util.Comparator;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public static final Comparator<Product> BY_NAME =
            Comparator.comparing(Product::getName);

    public static final Comparator<Product> BY_PRICE =
            Comparator.comparingDouble(Product::getPrice);

    public static final Comparator<Product> BY_QUANTITY =
            Comparator.comparingInt(Product::getQuantity);
    

    public static final Comparator<Product> DEFAULT_SORT =
            BY_NAME
                    .thenComparing(BY_PRICE)
                    .thenComparing(BY_QUANTITY);
}
