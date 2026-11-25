package randomizer;


import model.product.ProductBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class ProductRandomizer {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    public Consumer<ProductBuilder> productRandomizer = builder -> {
        String[] name = {"Dr. Papper", "Coca-cola", "Sprite", "Seven-up", "Fanta", "Pepsi", "Lexapro", "Zodac", "Prozac", "Coffee"};

        builder.setName(name[random.nextInt(name.length)]);
        builder.setPrice(random.nextDouble(100.0, 3500.0));
        builder.setQuantity(random.nextInt(1, 1337));
    };
}
