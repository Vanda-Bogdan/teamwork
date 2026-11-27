package randomizer;

import model.automobile.Automobile;
import model.automobile.AutomobileBuilder;
import model.product.ProductBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class AutomobileRandomizer {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    public Consumer<AutomobileBuilder> automobileRandomizer = builder -> {
        String[] model = {"Honda Civic", "LADA Vesta", "Mercedes-Benz E-Class", "Toyota Corolla", "Mazda 6", "Porsche 911", "Volkswagen Passat", "Fiat 500", "Chevrolet Camaro", "Citroën C4"};

        builder.setModel(model[random.nextInt(model.length)]);
        builder.setEnginePower(random.nextDouble(50.0, 650.0));
        builder.setYear(random.nextInt(1980, 2027));
    };
}
