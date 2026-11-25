package getdata;

import model.EntityBuilder;
import model.display.Display;

import java.util.ArrayList;
import java.util.List;

public class RandomDataStrategy<T> implements GetDataStrategy<T> {

    private final EntityBuilder<T> builder;
    private final int size;

    public RandomDataStrategy(EntityBuilder<T> builder, int size) {
        this.builder = builder;
        this.size = size;
    }

    @Override
    public List<T> getData() {

        List<T> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            // Здесь генерируются случайные значения
            // и передаются в Builder.

            result.add(builder.build());
        }

        return result;
    }
}
