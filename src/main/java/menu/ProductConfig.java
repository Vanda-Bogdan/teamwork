package menu;

import datareader.ConsoleReader;
import datareader.ProductConsoleReader;
import filereader.FileReader;
import filereader.ProductFileReader;
import model.product.Product;
import model.product.ProductBuilder;
import randomizer.ProductRandomizer;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class ProductConfig implements EntityConfig<Product, ProductBuilder> {

    @Override
    public ProductBuilder createBuilder() {
        return new ProductBuilder();
    }

    @Override
    public ConsoleReader<ProductBuilder> createConsoleReader(Scanner scanner) {
        return new ProductConsoleReader(scanner);
    }

    @Override
    public Consumer<ProductBuilder> createRandomizer(ProductBuilder builder) {
        return new ProductRandomizer().productRandomizer;
    }

    @Override
    public FileReader<ProductBuilder> createFileReader(BufferedReader reader) {
        return new ProductFileReader(reader);
    }

    @Override
    public Comparator<Product> chooseSort(Menu menu) {
        return menu.chooseProductSort();
    }
}