package menu;

import datareader.DataReader;
import datareader.ProductDataReader;
import model.product.Product;
import model.product.ProductBuilder;
import randomizer.ProductRandomizer;

import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class ProductConfig implements EntityConfig<Product, ProductBuilder> {

    @Override
    public ProductBuilder createBuilder() {
        return new ProductBuilder();
    }

    @Override
    public DataReader<ProductBuilder> createReader(Scanner scanner) {
        // Вам нужно будет создать этот класс
        return new ProductDataReader(scanner);
    }

    @Override
    public Consumer<ProductBuilder> createRandomizer(ProductBuilder builder) {
        return new ProductRandomizer().productRandomizer;
    }

    @Override
    public Comparator<Product> chooseSort(Menu menu) {
        return menu.chooseProductSort();
    }
}