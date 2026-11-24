package model.product;

import model.EntityBuilder;
import model.display.Display;

public class ProductBuilder implements EntityBuilder<Product>  {

    private String name;
    private double price;
    private int quantity;

    @Override
    public Product build() {
        return new Product(name, price, quantity);
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
