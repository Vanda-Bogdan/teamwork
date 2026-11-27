package datareader;

import model.product.ProductBuilder;

import java.util.Scanner;

public class ProductDataReader implements DataReader<ProductBuilder> {

    private final Scanner scanner;

    public ProductDataReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void readData(ProductBuilder builder) {
        System.out.print("Введите название продукта: ");
        String name = scanner.nextLine();

        System.out.print("Введите цену: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Введите количество: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        builder.setName(name)
                .setPrice(price)
                .setQuantity(quantity);
    }
}