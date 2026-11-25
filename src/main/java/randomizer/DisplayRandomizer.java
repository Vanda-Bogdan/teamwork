package randomizer;
import model.display.DisplayBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class DisplayRandomizer {

    ThreadLocalRandom random = ThreadLocalRandom.current();

    public Consumer<DisplayBuilder> displayRandomizer = builder -> {
        String[] models = {"Samsung", "LG", "Acer", "BenQ", "Xiaomi", "DELL", "Mitsubishi", "Sony", "Huawei", "HP", "Lenovo", "Philips"};

        builder.setModel(models[random.nextInt(models.length)]);
        builder.setDiagonal(random.nextDouble(11.0, 35.0));
        builder.setRefreshRate(random.nextInt(60, 241));
    };

}
